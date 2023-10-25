package com.transaccion.transaccion.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonPropertyOrder
public class ClienteDTO {
    private Long clienteId;
    private String nombre;
    private int telefono;
    List<CuentaDTO> cuentas;
}
