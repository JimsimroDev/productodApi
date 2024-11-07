package com.jimsirmrodev.apiProductos.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jimsirmrodev.apiProductos.domain.model.Cliente;

/**
 * JpaClienteRepository
 */
@Repository
public interface JpaClienteRepository extends JpaRepository<Cliente, Long> {

}
