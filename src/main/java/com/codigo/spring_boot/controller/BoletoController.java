package com.codigo.spring_boot.controller;

import com.codigo.spring_boot.dto.BoletoRequest;
import com.codigo.spring_boot.entity.BoletoEntity;
import com.codigo.spring_boot.service.BoletoService;
import com.codigo.spring_boot.service.impl.BoletoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/boleto")
public class BoletoController {

    private final BoletoService boletoService;

    public BoletoController(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @PostMapping("/save")
    public BoletoEntity saveBoleto(@RequestBody BoletoRequest request) {
        return boletoService.createBoleto(request);
    }
}
