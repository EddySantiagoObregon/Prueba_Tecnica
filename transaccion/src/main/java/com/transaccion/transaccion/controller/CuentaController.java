package com.transaccion.transaccion.controller;

import com.transaccion.transaccion.dtos.ClienteDTO;
import com.transaccion.transaccion.entity.CuentaEntity;
import com.transaccion.transaccion.exception.BadRequestException;
import com.transaccion.transaccion.exception.NotFoundException;
import com.transaccion.transaccion.service.ApiService;
import com.transaccion.transaccion.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    CuentaService service;

    @Autowired
    ApiService apiService;

    @GetMapping("/obtenerCuenta/{id}")
    public ResponseEntity<CuentaEntity> getCuenta(@PathVariable long id) throws BadRequestException {
        return new ResponseEntity<>(service.obtenerCuenta(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/crearCuenta")
    public ResponseEntity<CuentaEntity> crearCuenta(@RequestBody CuentaEntity cuenta){
        return new ResponseEntity<>(service.crearCuenta(cuenta), HttpStatus.OK);
    }

    @GetMapping("/reportesUsuario")
    public ResponseEntity<ClienteDTO> reporteCuentasUsuario(@RequestParam(value = "fechaInicio") String fechaInicio, @RequestParam(value = "fechaFinal") String fechaFinal, @RequestHeader(value = "cliente_Id") long clienteId) throws BadRequestException, NotFoundException {

        return new ResponseEntity<>(service.clienteReporte(stringToDate(fechaInicio), stringToDate(fechaFinal), clienteId), HttpStatus.OK);

    }

    @PatchMapping("/modificarCuenta/{id}")
    public ResponseEntity<String> modificarCuenta(@RequestParam(value = "id") long cuentaid, @RequestBody CuentaEntity cuenta){
        service.modificarCuenta(cuentaid, cuenta);
        return new ResponseEntity<>("Cuenta Modificada", HttpStatus.OK);
    }


    @DeleteMapping("/eliminarCuenta/")
    public ResponseEntity<String> eliminarCuenta(){
        return new ResponseEntity<>("asdad", HttpStatus.ACCEPTED);
    }

    protected Date stringToDate(String fecha){
        String pattern="yyyy-MM-dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);

        try {
            return dateFormat.parse(fecha);
        } catch (ParseException e) {
            System.out.println("ParseException: " + e.getMessage());
            return null;
        }
    }
}
