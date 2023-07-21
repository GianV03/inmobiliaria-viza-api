package com.inmobiliariavives.inmobiliariavives.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="contact")
public class ContactEntity {
    @Id
    @GeneratedValue
    @Column(name="id_contact")
    private UUID id;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="contact_lastname")
    private String contactLastname;

    @Column(name="contact_email")
    private String contactEmail;

    @Column(name="contact_phone")
    private String contactPhone;

    @Column(name="contact_message")
    private String contactMessage;

    @Column(name="contact_interest_property")
    private  UUID contactInterestProperty;
}
