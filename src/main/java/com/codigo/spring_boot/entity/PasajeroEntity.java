package com.codigo.spring_boot.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pasajeros")
public class PasajeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasajero")
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
}
