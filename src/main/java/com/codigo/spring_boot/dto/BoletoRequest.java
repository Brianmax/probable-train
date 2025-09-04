package com.codigo.spring_boot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletoRequest {
    private int asiento;
    private String clase;
    private int puertaEmbarque;
    private int pasajeroId;
    private int vueloId;
}
