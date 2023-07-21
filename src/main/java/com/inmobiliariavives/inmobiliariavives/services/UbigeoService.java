package com.inmobiliariavives.inmobiliariavives.services;
import com.inmobiliariavives.inmobiliariavives.models.UbigeoEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.UbigeoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UbigeoService {
    @Autowired
    UbigeoRepository ubigeoRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ModelMapper modelMapper;

    public List<UbigeoEntity> findAll(){
        return ubigeoRepository.findAll();
    }

    public List<UbigeoEntity> findDistrictByDepartament(String departament){
        return ubigeoRepository.findByDepartament(departament);
    }
}





  /**  var cb = em.getCriteriaBuilder();
  var cq = cb.createQuery(UbigeoEntity.class);
    var root =cq.from(UbigeoEntity.class);
    var cqCount = cb.createQuery(Long.class);
    var rootCont = cqCount.from(UbigeoEntity.class);

        cqCount.select(cb.count(rootCont));
                Predicate[] predicatesArray;
                var predicates = new ArrayList<Predicate>();

        if (departament != null) {
        predicates.add(cb.like(root.get("departament"), departament));
        System.out.println(departament);
        }

        predicatesArray = predicates.toArray(new Predicate[0]);
        if (!predicates.isEmpty()) {
        cq.where(predicatesArray);
        cqCount.where(predicatesArray);
        }
        cq.select(root).distinct(true);

        var result = em.createQuery(cq);
        var resultCont = em.createQuery(cqCount);
        System.out.println("hasta acá todo bien");
        // result = result.setFirstResult(page);
        //result = result.setMaxResults(size);
        Long all = resultCont.getSingleResult();
        var resultList = result.getResultList();
        return new ArrayList<>(resultList);**/