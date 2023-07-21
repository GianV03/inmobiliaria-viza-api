package com.inmobiliariavives.inmobiliariavives.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="master", schema = "public")
public class MasterEntity {
    @Id
    @GenericGenerator(name="UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Column(name="prefix")
    private String prefix;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="creation_user")
    private UUID userCreation;


    @Column(name="update_user")
    private UUID userUpdate;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    @Column(name="update_date")
    private LocalDateTime updateDate;
}
