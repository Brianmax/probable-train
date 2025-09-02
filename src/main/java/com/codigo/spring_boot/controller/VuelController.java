package com.codigo.spring_boot.controller;

import com.codigo.spring_boot.entity.VuelosEntity;
import com.codigo.spring_boot.repository.VueloRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vuelo")
public class VuelController {

    private final VueloRepository vueloRepository;

    public VuelController(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @GetMapping("/all")
    public List<VuelosEntity> getAll() {
        return vueloRepository.findAll();
    }

    @GetMapping("/find/rangeFecha")
    public List<VuelosEntity> findRangeFecha(@RequestParam Date fs, @RequestParam Date fll) {
        return vueloRepository.findByFechaSalidaAndFechaLlegada(fs, fll);
    }
}
