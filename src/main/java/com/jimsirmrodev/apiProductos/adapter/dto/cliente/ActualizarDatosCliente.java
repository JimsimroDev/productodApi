package com.jimsirmrodev.apiProductos.adapter.dto.cliente;

/**
 * ActualizarDatosCliente
 */
public record ActualizarDatosCliente(
    Long id_cliente,
    String nombre,
    String telefono,
    String correo) {

}
