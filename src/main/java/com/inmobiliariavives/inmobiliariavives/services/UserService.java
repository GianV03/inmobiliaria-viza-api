package com.inmobiliariavives.inmobiliariavives.services;

import com.inmobiliariavives.inmobiliariavives.dto.UserGetDTO;
import com.inmobiliariavives.inmobiliariavives.models.UserEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserGetDTO findUserById(UUID id) {
        UserEntity response = userRepository.findById(id).get();
        return modelMapper.map(response, UserGetDTO.class);
    }
}
