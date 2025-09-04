package com.codigo.spring_boot.service.impl;

import com.codigo.spring_boot.entity.BoletoEntity;
import com.codigo.spring_boot.entity.PasajeroEntity;
import com.codigo.spring_boot.entity.VueloEntity;
import com.codigo.spring_boot.repository.BoletoRepository;
import com.codigo.spring_boot.repository.PasajeroRepository;
import com.codigo.spring_boot.repository.VueloRepository;
import com.codigo.spring_boot.service.BoletoService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BoletoServiceImpl implements BoletoService {
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;
    private final BoletoRepository boletoRepository;

    public BoletoServiceImpl(PasajeroRepository pasajeroRepository, VueloRepository vueloRepository, BoletoRepository boletoRepository) {
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
        this.boletoRepository = boletoRepository;
    }

    @Override
    public BoletoEntity createBoleto(BoletoEntity request) {
        // asegurarme de que el pasajero exista en la base de datos
        // asegurarnos de que el vuelo exista

        // obtenemos el pasajero y el vuelo que llegaron en la request
        PasajeroEntity pasajeroRequest = request.getPasajeroEntity();
        VueloEntity vueloRequest = request.getVueloEntity();
        if (pasajeroRequest == null || vueloRequest == null){
            // todo: retornar un mensaje de error
            return null; // todo: retornar mensaje de error y terminar la ejecucion del metodo
        }
        // obtenemos los id's de pasajero y vuelo
        int pasajeroId = pasajeroRequest.getId();
        int vueloId = vueloRequest.getId();

        // consultamos con la bd para asegurarnos de su existencia

        java.util.Optional<PasajeroEntity> optionalPasajeroBd = pasajeroRepository.findById(pasajeroId);
        Optional<VueloEntity> optionalVueloBd = vueloRepository.findById(vueloId);

        // validamos la existencia de los registros

        if (optionalPasajeroBd.isEmpty() || optionalVueloBd.isEmpty()) {
            // todo: retornar mensaje de error
            return null; // todo: retornar response con mensaje de error y terminar la ejecucion
        }

        // creacion del boleto

        // todo: asegurarnos de la disponibilidad del asiento en el vuelo

        BoletoEntity boletoBdSave = new BoletoEntity();

        boletoBdSave.setAsiento(request.getAsiento());
        boletoBdSave.setClase(request.getClase());
        boletoBdSave.setPuertaEmbarque(boletoBdSave.getPuertaEmbarque());

        VueloEntity vueloBd = optionalVueloBd.get();
        PasajeroEntity pasajeroBd = optionalPasajeroBd.get();

        boletoBdSave.setVueloEntity(vueloBd);
        boletoBdSave.setPasajeroEntity(pasajeroBd);

        boletoRepository.save(boletoBdSave);
        return boletoBdSave;
    }
}
