package com.transaccion.transaccion.controller;

import com.transaccion.transaccion.entity.MovimientoEntity;
import com.transaccion.transaccion.exception.BadRequestException;
import com.transaccion.transaccion.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoService service;
    @GetMapping("/obtenerMovimiento/{id}")
    public ResponseEntity<MovimientoEntity> getMovimiento(@PathVariable long id) throws BadRequestException {
        return new ResponseEntity<>(service.obtenerMovimiento(id), HttpStatus.OK);
    }

    @PostMapping("/crearMovimiento")
    public ResponseEntity<MovimientoEntity> crearMovimiento(@RequestBody MovimientoEntity movimiento) throws BadRequestException {
        return new ResponseEntity<>(service.registrarMovimiento(movimiento, movimiento.getCuenta().getNoCuenta()), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/modificarMovimiento")
    public ResponseEntity<String> modificarMovimiento(){
        return new ResponseEntity<>("asdad", HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/eliminarMovimiento")
    public ResponseEntity<String> eliminarMovimiento(){
        return new ResponseEntity<>("asdad", HttpStatus.ACCEPTED);
    }
}
