package com.inmobiliariavives.inmobiliariavives.controllers;

import com.inmobiliariavives.inmobiliariavives.dto.EstateGetDTO;
import com.inmobiliariavives.inmobiliariavives.models.EstateEntity;
import com.inmobiliariavives.inmobiliariavives.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/estate")
public class EstateController {

    @Autowired
    private EstateService estateService;

    @GetMapping
    public ResponseEntity<List<EstateGetDTO>> findAll(){
        var response = estateService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/id")
    public ResponseEntity<EstateGetDTO> findById(
            @RequestParam String id
    ){
        try{
            return ResponseEntity.ok().body(this.estateService.findById(UUID.fromString(id)));
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/by-filters")
    public ResponseEntity<List<EstateGetDTO>> findByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String district,
            @RequestParam(required = false) String modality
    ){
        return ResponseEntity.ok().body(estateService.findByFilters(title, department, province, district, modality));
    }

}
