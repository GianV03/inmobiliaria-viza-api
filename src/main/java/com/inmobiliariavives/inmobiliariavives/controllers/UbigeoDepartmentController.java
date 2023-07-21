package com.inmobiliariavives.inmobiliariavives.controllers;

import com.inmobiliariavives.inmobiliariavives.models.UbigeoDepartmentEntity;
import com.inmobiliariavives.inmobiliariavives.services.UbigeoDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("department")
public class UbigeoDepartmentController {

    @Autowired
    private UbigeoDepartmentService ubigeoDepartmentService;

    @GetMapping
    public ResponseEntity<List<UbigeoDepartmentEntity>> findAllDepartment(){
        try{
            List<UbigeoDepartmentEntity> departments = ubigeoDepartmentService.findAll();
            return ResponseEntity.ok().body(departments);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbigeoDepartmentEntity> findDepartmentById(@PathVariable String id) {
        try{
            return ResponseEntity.ok().body(ubigeoDepartmentService.findById(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
