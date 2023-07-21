package com.inmobiliariavives.inmobiliariavives.repositories;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UbigeoDepartmentRepository extends JpaRepository<UbigeoDepartmentEntity, String> {
    UbigeoDepartmentEntity findByIdIs(String id);
}
