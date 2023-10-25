package com.transaccion.transaccion.utils;

import com.transaccion.transaccion.dtos.CuentaDTO;
import com.transaccion.transaccion.dtos.MovimientoDTO;
import com.transaccion.transaccion.entity.CuentaEntity;
import com.transaccion.transaccion.entity.MovimientoEntity;

public class UtilsMapper {

    public CuentaDTO mapCuentasToDTO(CuentaEntity cuenta){
        CuentaDTO cuentaDTO=new CuentaDTO();
        cuentaDTO.setNoCuenta(cuenta.getNoCuenta());
        cuentaDTO.setSaldo(cuenta.getSaldo());
        cuentaDTO.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaDTO.setEstado(cuenta.isEstado());
        return cuentaDTO;
    }

    public MovimientoDTO mapMovimientoToDto(MovimientoEntity movimientoEntity){
        MovimientoDTO movimientoDTO=new MovimientoDTO();
        movimientoDTO.setId(movimientoDTO.getId());
        movimientoDTO.setTipoMovimiento(movimientoEntity.getTipoMovimiento());
        movimientoDTO.setFecha(movimientoEntity.getFecha());
        movimientoDTO.setValor(movimientoDTO.getValor());
        return movimientoDTO;
    }
}
