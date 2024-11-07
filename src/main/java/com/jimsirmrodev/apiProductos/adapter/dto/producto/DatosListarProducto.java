package com.jimsirmrodev.apiProductos.adapter.dto.producto;

import com.jimsirmrodev.apiProductos.adapter.dto.cliente.DatosCliente;
import com.jimsirmrodev.apiProductos.domain.model.Producto;

/**
 * DatosRespuestaProducto
 */
public record DatosListarProducto(
    Long id,
    String nombre,
    Double precio,
    DatosCliente cliente) {

  public DatosListarProducto(Producto producto) {
    this(
        producto.getId(),
        producto.getNombre(),
        producto.getPrecio(),
        producto.getCliente() != null ? new DatosCliente(
            producto.getCliente().getId_cliente(),
            producto.getCliente().getNombre(),
            producto.getCliente().getTelefono()) : null);
  }
}
