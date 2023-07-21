package com.inmobiliariavives.inmobiliariavives.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="person", schema="public")
public class PersonEntity {
    @Id
    @GenericGenerator(name="UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name="id_person")
    private UUID id;

    @Column(name="person_name")
    private String name;

    @Column(name="person_middle_name")
    private String middleName;

    @Column(name="person_last_name")
    private String lastName;

    @Column(name="person_phone_number")
    private String personPhoneNumber;

    @Column(name="person_email")
    private String email;

    @Column(name="person_nationality")
    private String nationality;

    @Column(name="person_birthdate")
    private Date birthdate;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="update_date")
    private Date updateDate;

}
