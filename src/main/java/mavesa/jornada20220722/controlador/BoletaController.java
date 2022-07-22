package mavesa.jornada20220722.controlador;

import mavesa.jornada20220722.entidad.Boleta;
import mavesa.jornada20220722.entidad.Solicitud;
import mavesa.jornada20220722.repo.IBoletaRepo;
import mavesa.jornada20220722.repo.ISolicitudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class BoletaController {
    @Autowired
    private IBoletaRepo ibolrepo;
    @GetMapping("/listabol")
    public List<Boleta> boletasol(){
        return (List<Boleta>) ibolrepo.findAll();
    }
}
