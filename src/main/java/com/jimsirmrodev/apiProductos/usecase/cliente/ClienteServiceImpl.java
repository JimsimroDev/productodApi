package com.jimsirmrodev.apiProductos.usecase.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jimsirmrodev.apiProductos.adapter.dto.cliente.ActualizarDatosCliente;
import com.jimsirmrodev.apiProductos.adapter.dto.cliente.ListarDatosCLiente;
import com.jimsirmrodev.apiProductos.adapter.dto.cliente.RegistrarDatosCliente;
import com.jimsirmrodev.apiProductos.domain.model.Cliente;
import com.jimsirmrodev.apiProductos.infraestructura.repository.JpaClienteRepository;

/**
 * ClienteServiceImpl
 */
@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private JpaClienteRepository JpaClienteRepository;

  @Override
  public Page<ListarDatosCLiente> listarcliente(Pageable paginacion) {
    return JpaClienteRepository.findBy(paginacion).map(ListarDatosCLiente::new);
  }

  @Override
  public void guardarCliente(RegistrarDatosCliente resgistrarDatosCliente) {
    resgistrarDatosCliente = new RegistrarDatosCliente(
        resgistrarDatosCliente.nombre(),
        resgistrarDatosCliente.telefono(),
        resgistrarDatosCliente.correo());
    JpaClienteRepository.save(new Cliente(resgistrarDatosCliente));
  }

  @Override
  public void actualizarCliente(Long id, ActualizarDatosCliente actualizarDatosCLiente) {
    Cliente clientExiste = JpaClienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cleinte no encontrado " + id));

    clientExiste.setNombre(actualizarDatosCLiente.nombre());
    clientExiste.setCorreo(actualizarDatosCLiente.correo());
    clientExiste.setTelefono(actualizarDatosCLiente.telefono());

    JpaClienteRepository.save(clientExiste);
  }

  @Override
  public void eliminarCliente(Long id) {
    Cliente cliente = JpaClienteRepository.getReferenceById(id);
    JpaClienteRepository.delete(cliente);
  }
}
