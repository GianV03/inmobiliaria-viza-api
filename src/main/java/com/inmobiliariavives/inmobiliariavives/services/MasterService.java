package com.inmobiliariavives.inmobiliariavives.services;

import com.inmobiliariavives.inmobiliariavives.dto.MasterGetDTO;
import com.inmobiliariavives.inmobiliariavives.models.MasterEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.MasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterService {

    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<MasterGetDTO> getMaster(String prefix){
        List<MasterEntity> response = masterRepository.findByPrefix(prefix);
        return response.stream()
                .map(master -> modelMapper.map(master, MasterGetDTO.class))
                .collect(Collectors.toList());
    }
}
