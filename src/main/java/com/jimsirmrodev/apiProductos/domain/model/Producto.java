package com.jimsirmrodev.apiProductos.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jimsirmrodev.apiProductos.adapter.dto.producto.DatosRegistrarProducto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Product
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Producto")
@Table(name = "productos")
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private Double precio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_cliente")
  // @JoinTable(name = "compras", joinColumns = @JoinColumn(name = "fk_cliente"),
  // inverseJoinColumns = @JoinColumn(name = "fk_producto"))
  private Cliente cliente;

  public Producto(DatosRegistrarProducto datosRegistrarProducto) {
    this.nombre = datosRegistrarProducto.nombre();
    this.precio = datosRegistrarProducto.precio();
    this.cliente = datosRegistrarProducto.cliente();
  }
}
