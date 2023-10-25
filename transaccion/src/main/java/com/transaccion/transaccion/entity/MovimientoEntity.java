package com.transaccion.transaccion.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "movimiento")
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date fecha;
    private String tipoMovimiento;
    private int valor;
    private int saldo;
    @ManyToOne
    @JoinColumn(name = "noCuenta")
    private CuentaEntity cuenta;
}
