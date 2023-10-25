package com.transaccion.transaccion.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;
@Data
@JsonPropertyOrder({"noCuenta", "tipoCuenta", "saldo", "estado", "Movimientos"})
public class CuentaDTO {

    private Long NoCuenta;
    private String TipoCuenta;
    private int Saldo;
    private boolean estado;
    private List<MovimientoDTO> Movimientos;
}
