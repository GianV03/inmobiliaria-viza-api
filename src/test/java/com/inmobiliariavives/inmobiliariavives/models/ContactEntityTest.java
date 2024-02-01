package com.inmobiliariavives.inmobiliariavives.models;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactEntityTest {

    @Test
    public void testContactEntity() {

        // Creates an instance of the entity
        ContactEntity contactEntity = new ContactEntity();

        // Set all the attributes
        contactEntity.setId(UUID.randomUUID());
        contactEntity.setContactName("John");
        contactEntity.setContactLastname("Doe");
        contactEntity.setContactEmail("john.doe@gmail.com");
        contactEntity.setContactPhone("123456789");
        contactEntity.setContactMessage("Hola, estoy interesado en su propiedad");
        contactEntity.setContactInterestProperty(UUID.randomUUID());

        // Verifivy assigned attributes
        assertThat(contactEntity.getId()).isNotNull();
        assertThat(contactEntity.getContactName()).isEqualTo("John");
        assertThat(contactEntity.getContactLastname()).isEqualTo("Doe");
        assertThat(contactEntity.getContactEmail()).isEqualTo("john.doe@gmail.com");
        assertThat(contactEntity.getContactPhone()).isEqualTo("123456789");
        assertThat(contactEntity.getContactMessage()).isEqualTo("Hola, estoy interesado en su propiedad");
        assertThat(contactEntity.getContactInterestProperty()).isNotNull();
    }
}