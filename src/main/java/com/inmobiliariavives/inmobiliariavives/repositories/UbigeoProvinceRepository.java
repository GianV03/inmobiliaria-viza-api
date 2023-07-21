package com.inmobiliariavives.inmobiliariavives.repositories;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoProvinceRepository extends JpaRepository<UbigeoProvinceEntity, String> {
    UbigeoProvinceEntity findByIdIs(String id);
    List<UbigeoProvinceEntity> findByDepartmentIdIs(String department);
}
