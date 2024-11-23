package com.jimsirmrodev.apiProductos.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimsirmrodev.apiProductos.adapter.dto.cliente.ActualizarDatosCliente;
import com.jimsirmrodev.apiProductos.adapter.dto.cliente.ListarDatosCLiente;
import com.jimsirmrodev.apiProductos.adapter.dto.cliente.RegistrarDatosCliente;
import com.jimsirmrodev.apiProductos.infraestructura.repository.JpaClienteRepository;
import com.jimsirmrodev.apiProductos.usecase.cliente.ClienteServiceImpl;

import jakarta.transaction.Transactional;

/**
 * ClienteController
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
  @Autowired
  JpaClienteRepository jpaClienteRepository;

  @Autowired
  private ClienteServiceImpl clienteServiceImpl;

  @GetMapping
  public ResponseEntity<Page<ListarDatosCLiente>> listarCliente(@PageableDefault(size = 6) Pageable paginacion) {
    return ResponseEntity.ok(clienteServiceImpl.listarcliente(paginacion));

  }

  @PostMapping
  @Transactional
  public ResponseEntity<RegistrarDatosCliente> crearCliente(@RequestBody RegistrarDatosCliente registrarDatosCliente) {
    // Verificar que los datos recibidos no sean nulos
    // Imprimir valores recibidos

    if (registrarDatosCliente == null || registrarDatosCliente.nombre() == null
        || registrarDatosCliente.telefono() == null || registrarDatosCliente.correo() == null) {
      return ResponseEntity.badRequest().body(registrarDatosCliente); // Devuelve error si los datos son inválidos
    }

    clienteServiceImpl.guardarCliente(registrarDatosCliente);
    return ResponseEntity.ok(registrarDatosCliente);
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<?> actualizarCliente(
      @RequestBody ActualizarDatosCliente actualizarDatosCliente) {
    Long id = actualizarDatosCliente.id_cliente();
    clienteServiceImpl.actualizarCliente(id,
        actualizarDatosCliente);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
    clienteServiceImpl.eliminarCliente(id);
    return ResponseEntity.ok().build();

  }
}
