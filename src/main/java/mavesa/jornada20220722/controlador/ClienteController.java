package mavesa.jornada20220722.controlador;

import mavesa.jornada20220722.entidad.Cliente;
import mavesa.jornada20220722.repo.IClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private IClienteRepo iClienteRepo;

    // Listar los clientes (GET)
    @GetMapping("/listar") // http://localhost:8080/cliente/listar
    public List<Cliente> listar() {
        List<Cliente> cliente = (List<Cliente>) iClienteRepo.findAll();
        return cliente;
    }
}
