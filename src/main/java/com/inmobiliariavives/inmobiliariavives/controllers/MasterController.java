package com.inmobiliariavives.inmobiliariavives.controllers;

import com.inmobiliariavives.inmobiliariavives.dto.MasterGetDTO;
import com.inmobiliariavives.inmobiliariavives.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;
    @GetMapping("/{prefix}")
    public ResponseEntity<List<MasterGetDTO>> getMasterByPrefix(@PathVariable("prefix") String prefix){
        try{
            return ResponseEntity.ok().body(masterService.getMaster(prefix));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
