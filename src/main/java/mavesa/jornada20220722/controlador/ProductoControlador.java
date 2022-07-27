package mavesa.jornada20220722.controlador;

import mavesa.jornada20220722.entidad.Producto;
import mavesa.jornada20220722.repo.IProductoRepo;
import mavesa.jornada20220722.valueobject.ProductoAgrupadoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {
    @Autowired
    private IProductoRepo iProductoRepo;

    // http://localhost:8080/producto/listartodo
    @GetMapping("/listartodo")
    public Iterable<Producto> listarTodo() {
        Iterable<Producto> resultado=iProductoRepo.findAll();
        return resultado;
    }
    // http://localhost:8080/producto/agrupadoporcategoria
    @GetMapping("/agrupadoporcategoria")
    public List<ProductoAgrupadoVO> agrupadoporcategoria() {
        return iProductoRepo.agrupar();
    }



}