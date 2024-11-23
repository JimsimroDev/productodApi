package com.jimsirmrodev.apiProductos.adapter.dto.cliente;

import com.jimsirmrodev.apiProductos.domain.model.Cliente;

/**
 * ListarDatosCLiente
 */
public record ListarDatosCLiente(Long id_cliente,
    String nombre,
    String telefono,
    String correo) {

  public ListarDatosCLiente(Cliente cliente) {
    this(
        cliente.getId_cliente(),
        cliente.getNombre(),
        cliente.getTelefono(),
        cliente.getCorreo());
  }
}
