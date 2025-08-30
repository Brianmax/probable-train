package com.codigo.spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/hello-server")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/adios-server")
    public String adios() {
        return "Adios";
    }

//    @PostMapping("/save/aerolinea")
//    public AerolineaEntity saveAerolinea(@RequestBody AerolineaEntity aerolineaEntity) {
//        // guardar aerolinea
//        aerolineaRepository.save(aerolineaEntity);
//        return aerolineaEntity;
//    }

    // crear un endpoint que me permitar crear un nuevo registro de pilotos
}
