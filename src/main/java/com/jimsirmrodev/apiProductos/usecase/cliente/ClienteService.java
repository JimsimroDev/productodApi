package com.jimsirmrodev.apiProductos.usecase.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jimsirmrodev.apiProductos.adapter.dto.cliente.ActualizarDatosCliente;
import com.jimsirmrodev.apiProductos.adapter.dto.cliente.ListarDatosCLiente;
import com.jimsirmrodev.apiProductos.adapter.dto.cliente.RegistrarDatosCliente;

/**
 * ClienteService
 */
public interface ClienteService {

  Page<ListarDatosCLiente> listarcliente(Pageable paginacion);

  void guardarCliente(RegistrarDatosCliente resgistrarDatosCliente);

  void actualizarCliente(Long id, ActualizarDatosCliente actualizarDatosCLiente);

  void eliminarCliente(Long id);
}
