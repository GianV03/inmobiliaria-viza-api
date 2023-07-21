package com.inmobiliariavives.inmobiliariavives.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ubigeo_peru_departments", schema="public")
public class UbigeoDepartmentEntity {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;
}
