package com.inmobiliariavives.inmobiliariavives.repositories;

import com.inmobiliariavives.inmobiliariavives.models.EstateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstateRepository extends JpaRepository<EstateEntity, UUID> {
}
