package com.codigo.spring_boot.service.impl;

import com.codigo.spring_boot.dto.ReniecResponse;
import com.codigo.spring_boot.entity.PilotoEntity;
import com.codigo.spring_boot.feingClient.ReniecClient;
import com.codigo.spring_boot.repository.PilotoRepository;
import com.codigo.spring_boot.service.PilotoService;

import java.util.List;

public class PilotoServiceImpl implements PilotoService {
    private final PilotoRepository pilotoRepository;
    private final ReniecClient reniecClient;

    public PilotoServiceImpl(PilotoRepository pilotoRepository, ReniecClient reniecClient) {
        this.pilotoRepository = pilotoRepository;
        this.reniecClient = reniecClient;
    }
    @Override
    public PilotoEntity createPiloto(String dni) {
        // traer la informacion del piloto de reniec usando su dni
        // hacemos la consulta hacia la api externa
        ReniecResponse pilotoInfo = reniecClient.getPersona(dni);
        // mapeamos la info que llego de reniec a un entity
        PilotoEntity pilotoEntity = new PilotoEntity();
        pilotoEntity.setNombre(pilotoInfo.getFirstName());
        pilotoEntity.setApellido(pilotoInfo.getFirstLastName());
        pilotoEntity.setDni(dni);
        pilotoEntity.setEstado(true);
        pilotoRepository.save(pilotoEntity);
        // guardar esa informacion en la base de datos
        return pilotoEntity;
    }

    @Override
    public List<PilotoEntity> findAllPilotos() {
        return List.of();
    }

    @Override
    public PilotoEntity findPilotoById(Long id) {
        return null;
    }
}
