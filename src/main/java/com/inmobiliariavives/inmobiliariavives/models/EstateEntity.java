package com.inmobiliariavives.inmobiliariavives.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "estate", schema = "public")
public class EstateEntity {

    @Id
    @Column(name="id_estate")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;

    @Column(name="estate_title")
    private String title;

    @Column(name="estate_description")
    private String description;

    @Column(name="estate_location")
    private String location;

    @Column(name="estate_price")
    private Double price;

    @Column(name="estate_bedrooms")
    private Integer bedrooms;

    @Column(name="estate_bathrooms")
    private Integer bathrooms;

    @Column(name="estate_area")
    private Integer area;
    @ManyToOne
    @JoinColumn(name="estate_user", referencedColumnName = "id_user")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name="estate_modality", referencedColumnName = "id")
    private MasterEntity modality;
    @Column(name="estate_image_source")
    private String imageSource;
    @Column(name="estate_images")
    private String images;
    @Column(name="ubigeo_department")
    private String department;
    @Column(name="ubigeo_province")
    private String province;
    @Column(name="ubigeo_district")
    private String district;
    @Column(name="creation_user")
    private UUID creationUser;
    @Column(name="update_user")
    private UUID updateUser;
    @Column(name="creation_date")
    private LocalDateTime creationDate;
    @Column(name="update_date")
    private LocalDateTime updateDate;

}
