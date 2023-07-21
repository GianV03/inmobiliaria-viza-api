package com.inmobiliariavives.inmobiliariavives.services;

import com.inmobiliariavives.inmobiliariavives.dto.ContactGetDTO;
import com.inmobiliariavives.inmobiliariavives.dto.ContactPostDTO;
import com.inmobiliariavives.inmobiliariavives.models.ContactEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ContactGetDTO> findAllContacts(){
        List<ContactEntity> contactList = contactRepository.findAll();
        List<ContactGetDTO> response = contactList.stream()
                .map(estate -> modelMapper.map(estate, ContactGetDTO.class))
                .collect(Collectors.toList());
        return response;
    }

    public ContactGetDTO saveContact(
            ContactPostDTO contact
    ){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactName(contact.getContactName());
        contactEntity.setContactLastname(contact.getContactLastname());
        contactEntity.setContactPhone(contact.getContactPhone());
        contactEntity.setContactEmail(contact.getContactEmail());
        contactEntity.setContactMessage(contact.getContactMessage());
        contactEntity.setContactInterestProperty(contact.getContactInterestProperty());
        ContactEntity response = contactRepository.save(contactEntity);
        return modelMapper.map(response, ContactGetDTO.class);
    }
}
