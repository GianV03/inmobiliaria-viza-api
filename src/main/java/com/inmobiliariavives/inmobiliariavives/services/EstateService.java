package com.inmobiliariavives.inmobiliariavives.services;

import com.inmobiliariavives.inmobiliariavives.dto.EstateGetDTO;
import com.inmobiliariavives.inmobiliariavives.dto.EstatePostDTO;
import com.inmobiliariavives.inmobiliariavives.models.EstateEntity;
import com.inmobiliariavives.inmobiliariavives.models.MasterEntity;
import com.inmobiliariavives.inmobiliariavives.models.UserEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.EstateRepository;
import com.inmobiliariavives.inmobiliariavives.repositories.MasterRepository;
import com.inmobiliariavives.inmobiliariavives.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class EstateService {

    private String filesRoute ="C:/estate/images/";

    @Autowired
    public EstateRepository estateRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private UserRepository userRepository;

    public List<EstateGetDTO> findAll(){
        var estateList = this.estateRepository.findAll();
        return estateList.stream().map(estate -> modelMapper.map(estate, EstateGetDTO.class)).collect(Collectors.toList());
    }

    public EstateGetDTO findById(UUID id){
        return modelMapper.map(this.estateRepository.findById(id).get(), EstateGetDTO.class);

    }

    public List<EstateGetDTO> findByFilters(String title, String department, String province, String district, String modality){
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(EstateEntity.class);
        var root =cq.from(EstateEntity.class);
        var cqCount = cb.createQuery(Long.class);
        var rootCont = cqCount.from(EstateEntity.class);

        cqCount.select(cb.count(rootCont));
        Predicate[] predicatesArray;
        var predicates = new ArrayList<Predicate>();

        if (title != null) {
            predicates.add(cb.like(root.get("title"), "%"+title.toUpperCase()+"%"));
        }

        if (modality != null) {
            predicates.add(cb.like(root.get("modality").get("name"), "%"+modality.toLowerCase()+"%"));
        }

        if(department != null){
            predicates.add(cb.like(root.get("department"), department));
        }

        if(province != null){
            predicates.add(cb.like(root.get("province"), province));
        }

        if (district != null) {
            predicates.add(cb.like(root.get("district"), district));
        }

        predicatesArray = predicates.toArray(new Predicate[0]);
        if (!predicates.isEmpty()) {
            cq.where(predicatesArray);

        }
        cq.select(root).distinct(true);

        var result = em.createQuery(cq);
        var resultCont = em.createQuery(cqCount);
        // result = result.setFirstResult(page);
        //result = result.setMaxResults(size);
        Long all = resultCont.getSingleResult();
        var resultList = result.getResultList();
        var resultListDTO = resultList.stream().map(estate -> modelMapper.map(estate, EstateGetDTO.class))
                .collect(Collectors.toList());
        return new ArrayList<>(resultListDTO);
    }

    public EstateGetDTO createEstate(EstatePostDTO estate, List<MultipartFile> images){

        EstateEntity creationEstate = new EstateEntity();

        creationEstate.setTitle(estate.getTitle());
        creationEstate.setDescription(estate.getDescription());
        creationEstate.setLocation(estate.getLocation());
        creationEstate.setPrice(estate.getPrice());
        creationEstate.setBedrooms(estate.getBedrooms());
        creationEstate.setBathrooms(estate.getBathrooms());
        creationEstate.setArea(estate.getArea());
        UserEntity user = userRepository.findById(estate.getUserId()).orElse(null);
        creationEstate.setUser(user);
        MasterEntity modality = masterRepository.findById(estate.getModalityId()).orElse(null);
        creationEstate.setModality(modality);

        creationEstate.setDepartment(estate.getDepartment());
        creationEstate.setProvince(estate.getProvince());
        creationEstate.setDistrict(estate.getDistrict());
        creationEstate.setImages(estate.getImages());
        creationEstate.setCreationUser(estate.getCreationUser());
        creationEstate.setCreationDate(LocalDateTime.now());

        EstateEntity response = estateRepository.save(creationEstate);

        File directory = new File(filesRoute +creationEstate.getId());
        if(!directory.exists()){
            directory.mkdirs();
        }

        for(MultipartFile image: images){

            String imageName = image.getOriginalFilename();
            Path imagesPath = Paths.get(filesRoute+creationEstate.getId(), imageName);
            try{
                Files.copy(image.getInputStream(),imagesPath, StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        return modelMapper.map(response, EstateGetDTO.class);

    }
}

