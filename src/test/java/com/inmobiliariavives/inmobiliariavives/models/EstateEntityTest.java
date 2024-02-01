package com.inmobiliariavives.inmobiliariavives.models;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
public class EstateEntityTest {

        @Test
        public void testEstateEntity() {

            // Creates an instance of the entity
            EstateEntity estateEntity = new EstateEntity();

            // Set some attributes
            estateEntity.setId(UUID.randomUUID());
            estateEntity.setTitle("Casa en venta");
            estateEntity.setDescription("Una hermosa casa en venta");
            estateEntity.setPrice(200000.00);
            estateEntity.setUser(new UserEntity());
            estateEntity.setModality(new MasterEntity());

            // Verify assigned attributes
            assertThat(estateEntity.getId()).isNotNull();
            assertThat(estateEntity.getTitle()).isEqualTo("Casa en venta");
            assertThat(estateEntity.getDescription()).isEqualTo("Una hermosa casa en venta");
            assertThat(estateEntity.getPrice()).isEqualTo(200000.00);
            assertThat(estateEntity.getUser()).isNotNull();
            assertThat(estateEntity.getModality()).isNotNull();
        }
}
