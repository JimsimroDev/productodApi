
package com.jimsirmrodev.apiProductos.infraestructura.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jimsirmrodev.apiProductos.domain.model.Producto;

/**
 * JpaProductoRepository
 */
@Repository
public interface JpaProductoRepository extends JpaRepository<Producto, Long> {
  Page<Producto> findBy(Pageable paginacion);
  // Método para encontrar todos los productos
  // List<Producto> findAll();

  // Método para encontrar un producto por su ID
  // Producto findByIdProducto(Long id);

  // Método para buscar productos por nombre
  Optional<Producto> findByNombreIgnoreCaseContaining(String nombre);
}
