package br.com.JohnOliveira.TesteMPK.Controller;


import br.com.JohnOliveira.TesteMPK.Models.Cliente;
import br.com.JohnOliveira.TesteMPK.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> add(@Valid @RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    @GetMapping
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Integer id){
        try{
            Cliente cliente = clienteService.get(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente, @PathVariable Integer id){
        try{
            Cliente existingCliente=clienteService.get(id);
            cliente.setId(existingCliente.getId());
            return  clienteService.updateCliente(cliente);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        clienteService.delete(id);
        return  "Excluido com Sucesso";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
