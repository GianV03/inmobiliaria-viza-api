package com.inmobiliariavives.inmobiliariavives.controllers;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoDistrictEntity;
import com.inmobiliariavives.inmobiliariavives.services.UbigeoDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("district")
public class UbigeoDistrictController {

    @Autowired
    private UbigeoDistrictService ubigeoDistrictService;

    @GetMapping
    public ResponseEntity<List<UbigeoDistrictEntity>> findAll(){
        try{
            List<UbigeoDistrictEntity> districts = ubigeoDistrictService.findAll();
            return ResponseEntity.ok().body(districts);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbigeoDistrictEntity> findById(@PathVariable String id){
        try{
            return ResponseEntity.ok().body(ubigeoDistrictService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/by-filters")
    public ResponseEntity<List<UbigeoDistrictEntity>> findByFilters(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String province
    ){
        try{
            return ResponseEntity.ok().body(ubigeoDistrictService.findByFilters(department, province));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
