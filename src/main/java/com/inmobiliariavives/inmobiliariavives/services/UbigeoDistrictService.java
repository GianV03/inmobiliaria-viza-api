package com.inmobiliariavives.inmobiliariavives.services;

import com.inmobiliariavives.inmobiliariavives.dto.EstateGetDTO;
import com.inmobiliariavives.inmobiliariavives.models.UbigeoDistrictEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.UbigeoDepartmentRepository;
import com.inmobiliariavives.inmobiliariavives.repositories.UbigeoDistrictRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UbigeoDistrictService {
    @Autowired
    private UbigeoDistrictRepository ubigeoDistrictRepository;
    @Autowired
    private UbigeoDepartmentRepository ubigeoDepartmentRepository;

    @PersistenceContext
    private EntityManager em;


    public List<UbigeoDistrictEntity> findAll(){
        return ubigeoDistrictRepository.findAll();
    }

    public UbigeoDistrictEntity findById(String id){
        return ubigeoDistrictRepository.findByIdIs(id);
    }

    public List<UbigeoDistrictEntity> findByFilters(String department, String province){
         var cb = em.getCriteriaBuilder();
         var cq = cb.createQuery(UbigeoDistrictEntity.class);
         var root = cq.from(UbigeoDistrictEntity.class);
         var cqCount =  cb.createQuery(Long.class);
         var rootCount = cqCount.from(UbigeoDistrictEntity.class);

         cqCount.select(cb.count(rootCount));
         Predicate[] predicatesArray;
         var predicates = new ArrayList<Predicate>();

         if (department != null) {
            predicates.add(cb.like(root.get("departmentId"), department));
         }

        if (province != null) {
            predicates.add(cb.like(root.get("provinceId"), province));
        }

        predicatesArray = predicates.toArray(new Predicate[0]);
        if (!predicates.isEmpty()) {
            cq.where(predicatesArray);

        }
        cq.select(root).distinct(true);

        var result = em.createQuery(cq);
        var resultCont = em.createQuery(cqCount);
        System.out.println("hasta acá todo bien");
        // result = result.setFirstResult(page);
        //result = result.setMaxResults(size);
        Long all = resultCont.getSingleResult();
        var resultList = result.getResultList();
        return new ArrayList<>(resultList);

    }
}
