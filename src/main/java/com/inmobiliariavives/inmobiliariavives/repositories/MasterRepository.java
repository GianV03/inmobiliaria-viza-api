package com.inmobiliariavives.inmobiliariavives.repositories;

import com.inmobiliariavives.inmobiliariavives.models.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MasterRepository extends JpaRepository<MasterEntity, UUID> {
    List<MasterEntity> findByPrefix(String prefix);
}
