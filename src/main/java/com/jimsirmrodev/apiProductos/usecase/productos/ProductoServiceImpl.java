package com.jimsirmrodev.apiProductos.usecase.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jimsirmrodev.apiProductos.adapter.dto.producto.ActualizarDatosProducto;
import com.jimsirmrodev.apiProductos.adapter.dto.producto.DatosListarProducto;
import com.jimsirmrodev.apiProductos.adapter.dto.producto.DatosRegistrarProducto;
import com.jimsirmrodev.apiProductos.domain.model.Cliente;
import com.jimsirmrodev.apiProductos.domain.model.Producto;
import com.jimsirmrodev.apiProductos.infraestructura.repository.JpaClienteRepository;
import com.jimsirmrodev.apiProductos.infraestructura.repository.JpaProductoRepository;

/**
 * ProductoServiceImpl
 */
@Service
public class ProductoServiceImpl implements ProductoService {

  @Autowired
  private JpaProductoRepository jpaProductoRepository;
  @Autowired
  private JpaClienteRepository jpaClienteRepository;

  @Override
  public Page<DatosListarProducto> listarProductos(Pageable paginacion) {
    return jpaProductoRepository.findBy(paginacion)
        .map(DatosListarProducto::new);
  }

  @Override
  public ResponseEntity<?> buscarPorId(Long id) {
    var productoEncontrado = jpaProductoRepository.findById(id);

    if (productoEncontrado.isPresent()) {
      // Devuelve el DTO con el cliente
      DatosListarProducto datosListarProducto = new DatosListarProducto(productoEncontrado.get());
      return ResponseEntity.ok(datosListarProducto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado con el id " + id);
    }
  }

  @Override
  public void eliminarProducto(Long id) {
    Producto producto = jpaProductoRepository.getReferenceById(id);
    jpaProductoRepository.delete(producto);
  }

  @Override
  public ResponseEntity<?> buscarPorNombre(String nombre) {
    var productoEncontradoNombre = jpaProductoRepository.findByNombreIgnoreCaseContaining(nombre);

    if (productoEncontradoNombre.isPresent()) {
      // Devuelve el DTO con el cliente
      DatosListarProducto datosListarProducto = new DatosListarProducto(productoEncontradoNombre.get());
      return ResponseEntity.ok(datosListarProducto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado con el nombre " + nombre);
    }
  }

  @Override
  public void guardarProducto(DatosRegistrarProducto datosRegistrarProducto) {
    Cliente cliente = jpaClienteRepository.findById(datosRegistrarProducto.fk_cliente()).orElseThrow();
    datosRegistrarProducto = new DatosRegistrarProducto(
        datosRegistrarProducto.nombre(),
        datosRegistrarProducto.precio(),
        datosRegistrarProducto.fk_cliente(),
        cliente);

    jpaProductoRepository.save(new Producto(datosRegistrarProducto));
  }

  @Override
  public void actualizarProducto(ActualizarDatosProducto actualizarDatosProducto) {
    Producto productoExistenete = jpaProductoRepository
        .getReferenceById(actualizarDatosProducto.id());

    productoExistenete.setNombre(actualizarDatosProducto.nombre());
    productoExistenete.setPrecio(actualizarDatosProducto.precio());
  }

}
