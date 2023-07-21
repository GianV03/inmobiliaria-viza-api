package com.inmobiliariavives.inmobiliariavives.services;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoDepartmentEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.UbigeoDepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Transactional
public class UbigeoDepartmentService {

    @Autowired
    UbigeoDepartmentRepository ubigeoDepartmentRepository;

    public List<UbigeoDepartmentEntity> findAll(){
        return ubigeoDepartmentRepository.findAll();
    }
    public UbigeoDepartmentEntity findById(String id){
        return ubigeoDepartmentRepository.findByIdIs(id);
    }
}
