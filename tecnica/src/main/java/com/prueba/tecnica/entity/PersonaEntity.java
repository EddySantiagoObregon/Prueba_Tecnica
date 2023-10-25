package com.prueba.tecnica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private int telefono;


}
