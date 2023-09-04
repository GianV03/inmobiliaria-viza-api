package com.inmobiliariavives.inmobiliariavives.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EstatePostDTO {
    private String title;
    private String description;
    private String location;
    private Double price;
    private Integer bedrooms;
    private Integer bathrooms;
    private UUID userId;
    private Integer area;
    private UUID modalityId;
    private String imageSource;
    private String images;
    private String department;
    private String province;
    private String district;
    private UUID creationUser;
}
