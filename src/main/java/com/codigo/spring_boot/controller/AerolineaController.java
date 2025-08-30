package com.codigo.spring_boot.controller;


import com.codigo.spring_boot.entity.AerolineaEntity;
import com.codigo.spring_boot.entity.PilotoEntity;
import com.codigo.spring_boot.repository.AerolineaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aerolinea")
public class AerolineaController {
    private AerolineaRepository aerolineaRepository;


    public AerolineaController(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    @PostMapping("/save")
    public AerolineaEntity save(@RequestBody AerolineaEntity aerolineaEntity) {
        return aerolineaRepository.save(aerolineaEntity);
    }

    @GetMapping("/getAll")
    public List<AerolineaEntity> getAll() {
        List<AerolineaEntity> aerolineas = aerolineaRepository.findAll();
        return aerolineas;
    }

}


