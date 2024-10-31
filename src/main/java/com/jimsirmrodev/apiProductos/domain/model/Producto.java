package com.jimsirmrodev.apiProductos.domain.model;

/**
 * Producto
 */
public class Producto {
  private static Long contador = 1L;
  private Long id;
  private String nombre;
  private double precio;

  public Producto(String nombre, double precio) {
    this.id = contador++;
    this.nombre = nombre;
    this.precio = precio;
  }

  public Long getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return this.precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

}
