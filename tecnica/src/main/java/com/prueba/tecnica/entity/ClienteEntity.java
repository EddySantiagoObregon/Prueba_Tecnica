package com.prueba.tecnica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "clienteId"), name = "Cliente")
public class ClienteEntity extends PersonaEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    private String contraseña;
    private boolean estado;

}
