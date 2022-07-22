package mavesa.jornada20220722.controlador;

import mavesa.jornada20220722.entidad.Producto;
import mavesa.jornada20220722.entidad.Solicitud;
import mavesa.jornada20220722.repo.IProductoRepo;
import mavesa.jornada20220722.repo.ISolicitudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class SolicitudController {
    @Autowired
    private ISolicitudRepo isolrepo;
    @Autowired
    private IProductoRepo iprod;
    @GetMapping("/listasol")
    public List<Solicitud> listasol(){
        return (List<Solicitud>) isolrepo.findAll();
    }

    @PostMapping("/crear")
    public String crear(@RequestBody Solicitud sol) {
        String resultado="";
        // 1) si hay stock?
        Producto prod=iprod.findById(sol.getProducto().getNumProducto()).get();
        // 2) comparar el stock con lo solicitado
        if(prod.getStockProducto()<sol.getCantidad()) {
            return "No hay stock disponible";
        } else {
            // 3) reducir el stock
            prod.setStockProducto(prod.getStockProducto()-sol.getCantidad());
            iprod.save(prod);
            // 4) agregar la solicitud
            isolrepo.save(sol);
            return "Producto con stock, stock reducido";
        }
        // return resultado;
    }
}
