package com.transaccion.transaccion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noCuenta;
    @Column(name = "TipoCuenta")
    private String tipoCuenta;
    private int saldo;
    private boolean estado;
    @Column(name = "cliente_Id")
    private long clienteId;

}
