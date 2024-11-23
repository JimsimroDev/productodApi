package com.jimsirmrodev.apiProductos.adapter.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * RegistrarDatosCliente
 */
public record RegistrarDatosCliente(
    @NotNull String nombre,
    @NotBlank String telefono,
    String correo) {
}
