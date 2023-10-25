package com.prueba.tecnica.repository;

import com.prueba.tecnica.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClienteEntity, String> {

    ClienteEntity searchByClienteId(Long cliente_Id);
    void deleteClienteById(long cliente_Id);
}
