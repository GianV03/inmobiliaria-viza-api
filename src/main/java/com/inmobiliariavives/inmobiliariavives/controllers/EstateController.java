package com.inmobiliariavives.inmobiliariavives.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.inmobiliariavives.inmobiliariavives.dto.EstateGetDTO;
import com.inmobiliariavives.inmobiliariavives.dto.EstatePostDTO;
import com.inmobiliariavives.inmobiliariavives.dto.EstateUpdatePostDTO;
import com.inmobiliariavives.inmobiliariavives.models.EstateEntity;
import com.inmobiliariavives.inmobiliariavives.services.EstateService;
import com.inmobiliariavives.inmobiliariavives.utils.PaginatedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/estate")
public class EstateController {

    @GetMapping("/obtener-origin")
    public String obtenerOrigin(@RequestHeader(value = "Origin", defaultValue = "no se encontró") String origin) {
        return "Origin enviado por el navegador: " + origin;
    }

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
    public ResponseEntity<PaginatedResponse<EstateGetDTO>> findByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String district,
            @RequestParam(required = false) String modality,
            @RequestParam(required = false) String user,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int pageSize

    ){
        try{
            Pageable pageable = PageRequest.of(page, pageSize);
            return ResponseEntity.ok().body(estateService.findByFilters(title, department, province, district, modality, user, pageable));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<EstateGetDTO> createEstate(
            @RequestParam String jsonEstate,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ){
        try{
            EstatePostDTO estate = new Gson().fromJson(jsonEstate, EstatePostDTO.class);
            return ResponseEntity.ok().body(estateService.createEstate(estate, images));
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    public ResponseEntity<EstateGetDTO> updateEstate(
            @RequestParam String jsonEstate,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ){
        try{
            EstateUpdatePostDTO estate = new Gson().fromJson(jsonEstate, EstateUpdatePostDTO.class);
            EstateGetDTO response = estateService.updateEstate(estate, images);
            return ResponseEntity.ok().body(response);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/hide/{id}")
    public ResponseEntity<EstateGetDTO> hideEstate(
            @PathVariable String id
    ){
       try{
           EstateGetDTO response = estateService.hideEstate(id);
           return ResponseEntity.ok().body(response);
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
    }

}
