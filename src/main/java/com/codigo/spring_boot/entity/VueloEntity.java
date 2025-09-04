package com.codigo.spring_boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Table(name = "vuelos")
@Getter
@Setter
public class VueloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vuelo")
    private int id;
    @Column(name = "fecha_salida")
    private Date fechaSalida;
    @Column(name = "fecha_llegada")
    private Date fechaLLegada;
    private String origen;
    private String destino;

    @ManyToOne
    @JoinColumn(name = "id_avion_fk")
    private AvionEntity avion;
}
