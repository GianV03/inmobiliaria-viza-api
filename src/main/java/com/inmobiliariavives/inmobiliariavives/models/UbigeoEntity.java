package com.inmobiliariavives.inmobiliariavives.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ubigeo", schema = "dbo")
public class UbigeoEntity {
    @Id
    @Column(name="ubigeo1", length = 6)
    private String ubigeo;

    @Column(name="dpto")
    private String departament;

    @Column(name="prov")
    private String province;

    @Column(name="distrito")
    private String district;

    @Column(name="ubigeo2", length = 6)
    private String ubigeo2;

    @Column(name="orden")
    private String order;

}
