package com.inmobiliariavives.inmobiliariavives.controllers;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoProvinceEntity;
import com.inmobiliariavives.inmobiliariavives.services.UbigeoProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("province")
public class UbigeoProvinceController {

    @Autowired
    private UbigeoProvinceService ubigeoProvinceService;

    @GetMapping
    public ResponseEntity<List<UbigeoProvinceEntity>> findAll(){
        try{
            return ResponseEntity.ok().body(ubigeoProvinceService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbigeoProvinceEntity> findById(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(ubigeoProvinceService.findById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/by-department/{department}")
    public ResponseEntity<List<UbigeoProvinceEntity>> findByDepartment(@PathVariable String department){
        try{
            List<UbigeoProvinceEntity> provinces = ubigeoProvinceService.findByDepartment(department);
            return ResponseEntity.ok().body(provinces);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
