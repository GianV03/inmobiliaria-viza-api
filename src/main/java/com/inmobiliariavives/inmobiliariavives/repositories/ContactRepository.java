package com.inmobiliariavives.inmobiliariavives.repositories;

import com.inmobiliariavives.inmobiliariavives.models.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<ContactEntity, UUID> {
}
