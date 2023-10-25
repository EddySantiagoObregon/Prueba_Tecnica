package com.prueba.tecnica.services;

import com.prueba.tecnica.entity.ClienteEntity;
import com.prueba.tecnica.excepciones.NotFoundException;
import com.prueba.tecnica.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    IClientRepository iClientRepository;

    public ClienteEntity crearCliente(ClienteEntity cliente){
        cliente.setIdentificacion(UUID.randomUUID().toString().substring(0));
        return iClientRepository.save(cliente);
    }

    public ClienteEntity listarCliente(long id) throws NotFoundException {
        ClienteEntity cliente=iClientRepository.searchByClienteId(id);
        if (cliente==null){
            throw new NotFoundException("No se encontro el usuario");
        }
        return cliente;
    }

    public ClienteEntity updateCliente(ClienteEntity cliente) throws NotFoundException {
        ClienteEntity clienteEntity =listarCliente(cliente.getClienteId());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setEdad(cliente.getEdad());
        clienteEntity.setGenero(cliente.getGenero());
        clienteEntity.setEstado(cliente.isEstado());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setIdentificacion(cliente.getIdentificacion());
        clienteEntity.setContraseña(cliente.getContraseña());

        return iClientRepository.save(clienteEntity);
    }

    public void eliminarCliente(long id) throws NotFoundException {
        this.listarCliente(id);
        iClientRepository.deleteClienteById(id);

    }
}
