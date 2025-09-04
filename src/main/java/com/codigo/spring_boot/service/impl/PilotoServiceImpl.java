package com.codigo.spring_boot.service.impl;

import com.codigo.spring_boot.dto.ReniecResponse;
import com.codigo.spring_boot.entity.PilotoEntity;
import com.codigo.spring_boot.feingClient.ReniecClient;
import com.codigo.spring_boot.repository.PilotoRepository;
import com.codigo.spring_boot.response.ResponseBase;
import com.codigo.spring_boot.service.PilotoService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class PilotoServiceImpl implements PilotoService {
    private final PilotoRepository pilotoRepository;
    private final ReniecClient reniecClient;
    @Value("${reniec.api.token}")
    private String token;

    public PilotoServiceImpl(PilotoRepository pilotoRepository, ReniecClient reniecClient) {
        this.pilotoRepository = pilotoRepository;
        this.reniecClient = reniecClient;
    }
    @Override
    public ResponseBase createPiloto(String dni) {
        // traer la informacion del piloto de reniec usando su dni
        // hacemos la consulta hacia la api externa
        try {
            ReniecResponse pilotoInfo = reniecClient.getPersona(dni, token);
            PilotoEntity pilotoEntity = new PilotoEntity();
            // mapeamos la info que llego de reniec a un entity
            pilotoEntity.setNombre(pilotoInfo.getFirstName());
            pilotoEntity.setApellido(pilotoInfo.getFirstLastName());
            pilotoEntity.setDni(dni);
            pilotoEntity.setEstado(true);
            pilotoRepository.save(pilotoEntity);
            // guardar esa informacion en la base de datos
            return new ResponseBase(200, "Exito", Optional.of(pilotoEntity));
        } catch (FeignException e) {
            int status = e.status();
            if (status == 404) {
                return new ResponseBase(status, "DNI no encontrado", Optional.empty());
            } else if (status == 422) {
                return new ResponseBase(status, "DNI Invallido", Optional.empty());
            } else if (status == 401){
                return new ResponseBase(status, "Token invalido", Optional.empty());
            } else {
                return new ResponseBase(status, "Time out", Optional.empty());
            }
        }
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
