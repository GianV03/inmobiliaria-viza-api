package com.inmobiliariavives.inmobiliariavives.repositories;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoDistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoDistrictRepository extends JpaRepository<UbigeoDistrictEntity, String> {

    UbigeoDistrictEntity findByIdIs(String id);
    List<UbigeoDistrictEntity> findByDepartmentIdIs(String department);

}
