package com.codigo.spring_boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pilotos")
public class PilotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piloto")
    private int id;
    private String nombre;
    private String apellido;
    private boolean estado;
    private String dni;
}
