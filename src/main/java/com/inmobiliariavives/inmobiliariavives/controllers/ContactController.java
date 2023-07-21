package com.inmobiliariavives.inmobiliariavives.controllers;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.inmobiliariavives.inmobiliariavives.dto.ContactGetDTO;
import com.inmobiliariavives.inmobiliariavives.dto.ContactPostDTO;
import com.inmobiliariavives.inmobiliariavives.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContactService contactService;
    @GetMapping
    public ResponseEntity<List<ContactGetDTO>> findAllContacts(){
        try{
            return ResponseEntity.ok().body(contactService.findAllContacts());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<ContactGetDTO> saveContact(
            @RequestBody ContactPostDTO contact
            ){
        try{
            ContactGetDTO response = contactService.saveContact(contact);
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
