package com.inmobiliariavives.inmobiliariavives.dto;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoDepartmentEntity;
import com.inmobiliariavives.inmobiliariavives.models.UbigeoDistrictEntity;
import com.inmobiliariavives.inmobiliariavives.models.UbigeoEntity;
import com.inmobiliariavives.inmobiliariavives.models.UbigeoProvinceEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EstateGetDTO {
    private UUID id;
    private String title;
    private String description;
    private String location;
    private Double price;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer area;
    private UUID userId;
    private String modalityName;
    private UUID modalityId;
    private String imageSource;
    private String images;
    private String department;
    private String province;
    private String district;

}
