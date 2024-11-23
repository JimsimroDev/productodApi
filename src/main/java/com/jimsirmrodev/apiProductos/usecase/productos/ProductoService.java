package com.jimsirmrodev.apiProductos.usecase.productos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.jimsirmrodev.apiProductos.adapter.dto.producto.ActualizarDatosProducto;
import com.jimsirmrodev.apiProductos.adapter.dto.producto.DatosListarProducto;
import com.jimsirmrodev.apiProductos.adapter.dto.producto.DatosRegistrarProducto;

/**
 * ProductoService
 */
public interface ProductoService {

  Page<DatosListarProducto> listarProductos(Pageable paginacion);

  ResponseEntity<?> buscarPorId(Long id);

  ResponseEntity<?> buscarPorNombre(String nombre);

  void guardarProducto(DatosRegistrarProducto datosResgistroProducto);

  void actualizarProducto(ActualizarDatosProducto actualizarDatosProducto);

  void eliminarProducto(Long id);
}
