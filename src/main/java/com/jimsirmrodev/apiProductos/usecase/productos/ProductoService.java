package com.jimsirmrodev.apiProductos.usecase.productos;

import java.util.List;

import com.jimsirmrodev.apiProductos.domain.model.Producto;

/**
 * ProductoService
 */
public interface ProductoService {

  List<Producto> listarProductos();

  Producto buscarPorId(Long id);

  List<Producto> buscarPorNombre(String nombre);

  void guardarProducto(Producto producto);

  void actualizarProducto(Long id, Producto producto);

  void eliminarProducto(Long id);
}
