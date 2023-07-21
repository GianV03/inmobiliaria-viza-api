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
@Table(name="user_person", schema="public")
public class UserEntity {
    @Id
    @GenericGenerator(name="UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name="id_user")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="id_person", referencedColumnName ="id_person")
    private PersonEntity person;

    @Column(name="user_type")
    private UUID userType;

    @Column(name="user_state")
    private Integer state;

    @Column(name="user_details")
    private String details;

    @Column(name="creation_user")
    private UUID creationUser;

    @Column(name="update_user")
    private UUID updateUser;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="update_date")
    private Date updateDate;
}
