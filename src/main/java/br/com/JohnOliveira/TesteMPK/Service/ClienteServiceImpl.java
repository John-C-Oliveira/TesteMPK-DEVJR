package br.com.JohnOliveira.TesteMPK.Service;

import br.com.JohnOliveira.TesteMPK.Models.Cliente;
import br.com.JohnOliveira.TesteMPK.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<?> saveCliente(Cliente cliente) {
        Optional<Cliente> novoCliente = clienteRepository.findByCnpj(cliente.getCnpj());


        if(!novoCliente.isEmpty()){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ já cadastrado no banco de dados");
        }

    clienteRepository.save(cliente);
    return  ResponseEntity.status(HttpStatus.OK).body("Cliente Cadastrado com sucesso no banco de dados");
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente get(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
    public ResponseEntity<?> updateCliente(Cliente cliente) {
        Optional<Cliente> updatecliente = clienteRepository.findByCnpj(cliente.getCnpj());


        if(!updatecliente.isEmpty()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ já cadastrado no banco de dados");
        }

        clienteRepository.save(cliente);
        return  ResponseEntity.status(HttpStatus.OK).body("Cliente Atualizado com Sucesso");
    }
}
