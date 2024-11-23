package com.jimsirmrodev.apiProductos.infraestructura.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jimsirmrodev.apiProductos.domain.model.Cliente;

/**
 * JpaClienteRepository
 */
@Repository
public interface JpaClienteRepository extends JpaRepository<Cliente, Long> {
  Optional<Cliente> findById(Long id);

  Page<Cliente> findBy(Pageable paginacion);
}
