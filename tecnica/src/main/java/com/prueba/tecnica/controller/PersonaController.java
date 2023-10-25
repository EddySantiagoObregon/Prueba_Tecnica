package com.prueba.tecnica.controller;

import com.prueba.tecnica.entity.ClienteEntity;
import com.prueba.tecnica.excepciones.NotFoundException;
import com.prueba.tecnica.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class PersonaController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/obtenercliente/{id}")
    public ResponseEntity<ClienteEntity> getCliente(@PathVariable long id) throws NotFoundException {
        return new ResponseEntity<>(clienteService.listarCliente(id), HttpStatus.OK);
    }

    @PostMapping("/crearcliente")
    public ResponseEntity<ClienteEntity> crearCliente(@RequestBody ClienteEntity cliente){
        return new ResponseEntity<>(clienteService.crearCliente(cliente), HttpStatus.OK);
    }

    @PutMapping("/modificarcliente")
    public ResponseEntity<ClienteEntity> modificarCliente(@RequestBody ClienteEntity cliente) throws NotFoundException {
        return new ResponseEntity<>(clienteService.updateCliente(cliente), HttpStatus.OK);
    }


    @DeleteMapping("/eliminarcliente/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable(value = "id") long id) throws NotFoundException {
        clienteService.eliminarCliente(id);
        return new ResponseEntity<>("Usuario Eliminado", HttpStatus.OK);
    }
}
