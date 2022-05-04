package br.com.JohnOliveira.TesteMPK.Service;

import br.com.JohnOliveira.TesteMPK.Models.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ClienteService {
    ResponseEntity saveCliente (Cliente cliente);
    List<Cliente> getClientes();
    Cliente get(Integer id);
    void delete(Integer id);
    ResponseEntity updateCliente(Cliente cliente);
}
