package com.jimsirmrodev.apiProductos.domain.model;

import com.jimsirmrodev.apiProductos.adapter.dto.cliente.ActualizarDatosCliente;
import com.jimsirmrodev.apiProductos.adapter.dto.cliente.RegistrarDatosCliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_cliente;
  private String nombre;
  private String telefono;
  private String correo;

  public Cliente(RegistrarDatosCliente registrarDatosCLiente) {
    this.nombre = registrarDatosCLiente.nombre();
    this.telefono = registrarDatosCLiente.telefono();
    this.correo = registrarDatosCLiente.correo();
  }

  public void actualizarDatosCLiente(ActualizarDatosCliente actualizarDatosCliente) {
    if (actualizarDatosCliente.nombre() != null) {
      this.nombre = actualizarDatosCliente.nombre();
    }
    if (actualizarDatosCliente.telefono() != null) {
      this.telefono = actualizarDatosCliente.telefono();
    }
    if (actualizarDatosCliente.correo() != null) {
      this.correo = actualizarDatosCliente.correo();
    }
  }
}
