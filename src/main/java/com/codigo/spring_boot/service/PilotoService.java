package com.codigo.spring_boot.service;

import com.codigo.spring_boot.entity.PilotoEntity;

import java.util.List;

public interface PilotoService {
    PilotoEntity createPiloto(String dni);
    List<PilotoEntity> findAllPilotos();
    PilotoEntity findPilotoById(Long id);
}
