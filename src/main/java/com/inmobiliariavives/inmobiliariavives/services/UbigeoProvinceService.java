package com.inmobiliariavives.inmobiliariavives.services;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoProvinceEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.UbigeoProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoProvinceService {

    @Autowired
    private UbigeoProvinceRepository ubigeoProvinceRepository;

    public List<UbigeoProvinceEntity> findAll() {
        return ubigeoProvinceRepository.findAll();
    }

    public UbigeoProvinceEntity findById(String id){
        return ubigeoProvinceRepository.findByIdIs(id);
    }

    public List<UbigeoProvinceEntity> findByDepartment(String department){
        return ubigeoProvinceRepository.findByDepartmentIdIs(department);
    }

}
