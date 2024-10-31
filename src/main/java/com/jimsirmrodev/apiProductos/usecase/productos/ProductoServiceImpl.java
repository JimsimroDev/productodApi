package com.jimsirmrodev.apiProductos.usecase.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jimsirmrodev.apiProductos.domain.model.Producto;

/**
 * ProductoServiceImpl
 */
@Service
public class ProductoServiceImpl implements ProductoService {

  private List<Producto> listaProductos = new ArrayList<>() {
    {
      add(new Producto("Cafe", 1.2344));
      add(new Producto("Azucar", 1.2344));
      add(new Producto("Arroz", 1.2344));

    }
  };

  @Override
  public List<Producto> listarProductos() {
    return listaProductos;
  }

  @Override
  public Producto buscarPorId(Long id) {
    for (Producto producto : listaProductos) {
      if (producto.getId() == id) {
        return producto;
      }
    }
    throw new RuntimeException("el producto con ese id no existe");
  }

  @Override
  public void eliminarProducto(Long id) {
    listaProductos.removeIf(producto -> producto.getId().equals(id));// Con este predicado se elimina el producto de
  }

  @Override
  public List<Producto> buscarPorNombre(String nombre) {
    return listaProductos.stream().filter(producto -> producto.getNombre().toLowerCase().contains(nombre.toLowerCase()))
        .collect(Collectors.toList());
  }

  @Override
  public void guardarProducto(Producto producto) {
    listaProductos.add(producto);
  }

  @Override
  public void actualizarProducto(Long id, Producto producto) {
    for (int i = 0; i < listaProductos.size(); i++) {
      Producto productoEncontrado = listaProductos.get(i);
      if (productoEncontrado.getId().equals(id)) {
        // Actualiza los campos del producto
        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setPrecio(producto.getPrecio());
        listaProductos.set(i, productoEncontrado); // Reemplaza el producto actualizado
        return; // Sale del método después de actualizar
      }
    }
  }
}
