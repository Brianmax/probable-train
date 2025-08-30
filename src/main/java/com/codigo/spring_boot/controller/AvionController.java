package com.codigo.spring_boot.controller;

import com.codigo.spring_boot.entity.AvionEntity;
import com.codigo.spring_boot.repository.AvionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
