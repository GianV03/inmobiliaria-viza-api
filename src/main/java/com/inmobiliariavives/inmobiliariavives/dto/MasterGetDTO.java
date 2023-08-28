package com.inmobiliariavives.inmobiliariavives.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MasterGetDTO {
    private UUID id;

    private String prefix;

    private String name;

    private String description;

    private UUID userCreation;

    private UUID userUpdate;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
