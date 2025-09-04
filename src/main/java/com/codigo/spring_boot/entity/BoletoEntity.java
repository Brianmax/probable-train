package com.codigo.spring_boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "boletos")
public class BoletoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private int id;
    private int asiento;
    private String clase;
    @Column(name = "puerta_embarque")
    private int puertaEmbarque; // puertaembarque // puerta_embarque
    private Date createdAt;
    private Date updatedAt;

    //relaciones
    @ManyToOne
    @JoinColumn(name = "id_pasajero_fk")
    private PasajeroEntity pasajeroEntity;

    @ManyToOne
    @JoinColumn(name = "id_vuelo_fk")
    private VueloEntity vueloEntity;
}
