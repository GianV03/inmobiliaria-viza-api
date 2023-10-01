package com.inmobiliariavives.inmobiliariavives.dto;

import com.inmobiliariavives.inmobiliariavives.models.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UserGetDTO {

    private String personName;

    private Integer state;

    private String details;

    private UUID creationUser;

    private UUID updateUser;

    private Date creationDate;

    private Date updateDate;

}
