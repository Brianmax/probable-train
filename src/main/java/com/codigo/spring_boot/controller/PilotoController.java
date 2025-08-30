package com.codigo.spring_boot.controller;

import com.codigo.spring_boot.entity.PilotoEntity;
import com.codigo.spring_boot.repository.PilotoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/piloto")
public class PilotoController {
    private PilotoRepository pilotoRepository;

    public PilotoController(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    @PostMapping("/save")
    public PilotoEntity save(@RequestBody PilotoEntity piloto) {
        return pilotoRepository.save(piloto);
    }

    @GetMapping("/find/{id}")
    public PilotoEntity findPilotoById(@PathVariable int id) {
        Optional<PilotoEntity> pilotoOptional = pilotoRepository.findById(id);

        if (pilotoOptional.isPresent()) {
            PilotoEntity pilotoBd = pilotoOptional.get();
            return pilotoBd;
        }
        return null;
    }

    @GetMapping("/find2/{id}")
    public PilotoEntity findPilotoById2(@PathVariable int id) {
        PilotoEntity pilotoBd = pilotoRepository.findById(id).orElse(null);

        if (pilotoBd != null) {
            pilotoBd.setApellido("Davis");
            return pilotoBd;
        }
        return null;
    }
}
