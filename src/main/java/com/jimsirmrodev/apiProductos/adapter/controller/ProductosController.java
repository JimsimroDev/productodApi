package com.jimsirmrodev.apiProductos.adapter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jimsirmrodev.apiProductos.domain.model.Producto;
import com.jimsirmrodev.apiProductos.usecase.productos.ProductoServiceImpl;

/**
 * ProductosController
 */
@RestController
@RequestMapping("/api/producto")
public class ProductosController {

  @Autowired
  private ProductoServiceImpl productoServiceImpl;

  /**
   * Edpoint Retorna la lista de los productos que hay en la lista y los muestra
   * en json
   */
  @GetMapping
  public List<Producto> getProdutos() {
    return productoServiceImpl.listarProductos();
  }

  /**
   * Edpoint Realiza la busqueda por id y si no existe retorna un mensaje
   */
  @GetMapping("/{id}")
  public Producto buscarPorId(@PathVariable Long id) {
    var producto = productoServiceImpl.buscarPorId(id);
    return producto;
  }

  /**
   * Edpoint Realiza la busqueda por nombre y si no existe retorna un mensaje
   */
  @GetMapping("/buscar")
  public List<Producto> buscarPorNombre(@RequestParam String nombre) {
    return productoServiceImpl.buscarPorNombre(nombre);
  }

  /**
   * Edpoint Recibe los datos en formato json y los guarda en memoria
   */
  @PostMapping
  public Producto agregarProductos(@RequestBody Producto producto) {
    productoServiceImpl.guardarProducto(producto);
    return producto;
  }

  @PutMapping("/{id}")
  public void actualizarProducto(
      @PathVariable Long id, @RequestBody Producto producto) {
    productoServiceImpl.actualizarProducto(id, producto);
  }

  /**
   * Edpoint para eliminar prodcto por id
   */
  @DeleteMapping("/{id}")
  public void eleminarProducto(@PathVariable Long id) {
    productoServiceImpl.eliminarProducto(id);
  }
}
