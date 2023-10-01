package com.inmobiliariavives.inmobiliariavives.controllers;

import com.inmobiliariavives.inmobiliariavives.dto.UserGetDTO;
import com.inmobiliariavives.inmobiliariavives.models.UserEntity;
import com.inmobiliariavives.inmobiliariavives.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserEntity>> findAllUsers(){
        var response = userService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDTO> findUserById(
            @PathVariable String id
    ){
        try{
            UserGetDTO response = userService.findUserById(UUID.fromString(id));
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
