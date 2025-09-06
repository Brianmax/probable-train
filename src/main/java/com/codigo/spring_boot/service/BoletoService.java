package com.codigo.spring_boot.service;

import com.codigo.spring_boot.dto.BoletoRequest;
import com.codigo.spring_boot.entity.BoletoEntity;

public interface BoletoService {
    BoletoEntity createBoleto(BoletoRequest boletoEntity);
}
