package com.transaccion.transaccion.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
public class MovimientoDTO {

    private Long id;
    private Date fecha;
    private String tipoMovimiento;
    private int valor;
}
