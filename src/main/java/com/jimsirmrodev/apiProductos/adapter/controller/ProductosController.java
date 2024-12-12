package com.jimsirmrodev.apiProductos.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jimsirmrodev.apiProductos.adapter.dto.producto.ActualizarDatosProducto;
import com.jimsirmrodev.apiProductos.adapter.dto.producto.DatosListarProducto;
import com.jimsirmrodev.apiProductos.adapter.dto.producto.DatosRegistrarProducto;
import com.jimsirmrodev.apiProductos.domain.model.Producto;
import com.jimsirmrodev.apiProductos.usecase.productos.ProductoServiceImpl;

import jakarta.transaction.Transactional;

/**
 * ProductosController
 */
@RestController
@RequestMapping("/producto")
public class ProductosController {

  @Autowired
  private ProductoServiceImpl productoServiceImpl;

  /**
   * Edpoint Retorna la lista de los productos que hay en la base de datos y los
   * muestra
   * en json
   */
  @GetMapping
  public ResponseEntity<Page<DatosListarProducto>> getProdutos(@PageableDefault(size = 5) Pageable paginacion) {
    return ResponseEntity.ok(productoServiceImpl.listarProductos(paginacion));
  }

  /**
   * Edpoint Realiza la busqueda por id y si no existe retorna un mensaje
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
    return productoServiceImpl.buscarPorId(id);
  }

  /**
   * Edpoint Realiza la busqueda por nombre y si no existe retorna un mensaje
   */
  @GetMapping("/buscar")
  public ResponseEntity<?> buscarPorNombre(@RequestParam String nombre) {
    return productoServiceImpl.buscarPorNombre(nombre);
  }

  /**
   * Edpoint Recibe los datos en formato json y los guarda en memoria
   */
  @PostMapping
  @Transactional
  public ResponseEntity<Producto> agregarProductos(@RequestBody DatosRegistrarProducto datosresgistrarProducto) {
    productoServiceImpl.guardarProducto(datosresgistrarProducto);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  @Transactional
  public void actualizarProducto(@RequestBody ActualizarDatosProducto actualizarProducto) {
    productoServiceImpl.actualizarProducto(actualizarProducto);
  }

  /**
   * Edpoint para eliminar prodcto por id
   */
  @DeleteMapping("/{id}")
  @Transactional
  public void eleminarProducto(@PathVariable Long id) {
    productoServiceImpl.eliminarProducto(id);
  }
}
