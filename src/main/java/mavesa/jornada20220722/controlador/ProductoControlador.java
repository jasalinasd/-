package mavesa.jornada20220722.controlador;

import mavesa.jornada20220722.entidad.Producto;
import mavesa.jornada20220722.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/listar")
public class ProductoControlador {
    @Autowired
    private IProductoRepo iProductoRepo;

    @GetMapping("/listartodo")
    public Iterable<Producto> listarTodo() {
        return iProductoRepo.findAll();
    }
}