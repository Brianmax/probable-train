package com.codigo.spring_boot.controller;

import com.codigo.spring_boot.entity.AvionEntity;
import com.codigo.spring_boot.repository.AvionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/avion")
public class AvionController {
    private final AvionRepository avionRepository;

    public AvionController(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    @GetMapping("/find/{id}")
    public AvionEntity findById(@PathVariable Integer id) {
        AvionEntity avionEntity = avionRepository.findById(id).orElse(null);
        return avionEntity;
    }

    // query params
    @GetMapping("/find/betweenCapacity")
    public List<AvionEntity> findBetweenCapacity(@RequestParam(required = true) int min, @RequestParam(required = true) int max) {
        List<AvionEntity> aviones = avionRepository.findByMinMaxCapacity(min, max);
        return aviones;
    }
}
