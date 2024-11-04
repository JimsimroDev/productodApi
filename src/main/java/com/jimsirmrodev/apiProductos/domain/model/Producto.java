package com.jimsirmrodev.apiProductos.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Producto
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
  private double precio;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "compras", joinColumns = @JoinColumn(name = "fk_cliente"), inverseJoinColumns = @JoinColumn(name = "fk_producto"))
  private List<Cliente> clientes;

  public Producto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }
}
