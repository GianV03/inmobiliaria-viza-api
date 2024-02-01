package com.inmobiliariavives.inmobiliariavives.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

    public class MasterEntityTest {

        @Test
        public void testMasterEntity() {

            // Creates an instance of the entity
            MasterEntity masterEntity = new MasterEntity();

            // Sets some attributes
            masterEntity.setId(UUID.randomUUID());
            masterEntity.setPrefix("PRE");
            masterEntity.setName("Example");
            masterEntity.setDescription("An example master entity");
            masterEntity.setUserCreation(UUID.randomUUID());
            masterEntity.setUserUpdate(UUID.randomUUID());
            masterEntity.setCreationDate(LocalDateTime.now());
            masterEntity.setUpdateDate(LocalDateTime.now());

            // Verifies all the attributed were set correctly
            assertThat(masterEntity.getId()).isNotNull();
            assertThat(masterEntity.getPrefix()).isEqualTo("PRE");
            assertThat(masterEntity.getName()).isEqualTo("Example");
            assertThat(masterEntity.getDescription()).isEqualTo("An example master entity");

            assertThat(masterEntity.getUserCreation()).isNotNull();
            assertThat(masterEntity.getUserUpdate()).isNotNull();
            assertThat(masterEntity.getCreationDate()).isNotNull();
            assertThat(masterEntity.getUpdateDate()).isNotNull();
        }
    }


