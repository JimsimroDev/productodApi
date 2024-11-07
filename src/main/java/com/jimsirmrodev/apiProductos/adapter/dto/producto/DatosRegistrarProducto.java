
package com.jimsirmrodev.apiProductos.adapter.dto.producto;

import com.jimsirmrodev.apiProductos.domain.model.Cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DatosRegistrarProducto
 */
public record DatosRegistrarProducto(
    @NotBlank(message = "{nombre.obligatorio}") String nombre,
    @NotNull Double precio,
    Long fk_cliente,
    Cliente cliente) {
}
