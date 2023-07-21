package com.inmobiliariavives.inmobiliariavives.controllers;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoEntity;
import com.inmobiliariavives.inmobiliariavives.services.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class UbigeoController {

    @Autowired
    private UbigeoService service;
    @GetMapping
    public ResponseEntity<List<UbigeoEntity>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/districts")
    public ResponseEntity<List<UbigeoEntity>> disctrictByDepartament(
            @RequestParam(name = "departament", required = false) String departament
    ){
        try {
            List<UbigeoEntity> districts = service.findDistrictByDepartament(departament);
            return ResponseEntity.ok().body(districts);
        }catch(Exception e){
            System.out.println("--------------------------------");
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
