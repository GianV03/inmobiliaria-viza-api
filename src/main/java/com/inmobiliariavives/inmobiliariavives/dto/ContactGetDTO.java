package com.inmobiliariavives.inmobiliariavives.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContactGetDTO {
    private UUID id;

    private String contactName;

    private String contactLastname;

    private String contactEmail;

    private String contactPhone;

    private String contactMessage;

    private  UUID contactInterestProperty;
}
