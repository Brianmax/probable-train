package com.codigo.spring_boot.service;

import com.codigo.spring_boot.entity.PilotoEntity;
import com.codigo.spring_boot.response.ResponseBase;

import java.util.List;

public interface PilotoService {
    ResponseBase createPiloto(String dni);
    List<PilotoEntity> findAllPilotos();
    PilotoEntity findPilotoById(Long id);
}
