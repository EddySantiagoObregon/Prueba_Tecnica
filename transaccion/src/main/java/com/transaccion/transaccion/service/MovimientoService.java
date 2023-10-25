package com.transaccion.transaccion.service;

import com.transaccion.transaccion.entity.CuentaEntity;
import com.transaccion.transaccion.entity.MovimientoEntity;
import com.transaccion.transaccion.exception.BadRequestException;
import com.transaccion.transaccion.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaService cuentaService;

    public MovimientoEntity registrarMovimiento (MovimientoEntity movimiento, long numeroCuenta) throws BadRequestException {
        CuentaEntity cuenta=cuentaService.obtenerCuenta(numeroCuenta);
        switch (movimiento.getTipoMovimiento()) {
            case "Deposito":
                if (movimiento.getValor() >= 100) {
                    cuenta.setSaldo(cuenta.getSaldo() + movimiento.getValor());
                    movimiento.setTipoMovimiento("Deposito de $" + movimiento.getValor());
                } else {
                    throw new BadRequestException("El deposito tiene que ser mayor a $100");
                }
                break;
            case "Retiro":
                if (cuenta.getSaldo()>=movimiento.getValor()){
                    cuenta.setSaldo(cuenta.getSaldo() - movimiento.getValor());
                    movimiento.setTipoMovimiento("Retiro de $" + movimiento.getValor());
                }else {
                    throw new BadRequestException("Saldo no disponible");
                }
                break;
            default:
                throw new BadRequestException("Bad Request");
        }

        movimiento.setSaldo(cuenta.getSaldo());
        movimiento.setFecha(new Timestamp(new Date().getTime()));
        movimiento.setCuenta(cuenta);


        return movimientoRepository.save(movimiento);
    }

    public MovimientoEntity obtenerMovimiento(long id) throws BadRequestException {
        Optional<MovimientoEntity> movimiento=movimientoRepository.findById(id);
        if (movimiento.isEmpty()){
            throw new BadRequestException("No existe un movimiento con ese ID");
        }
        return movimiento.get();
    }
}
