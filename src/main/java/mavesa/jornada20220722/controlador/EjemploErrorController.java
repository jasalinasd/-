package mavesa.jornada20220722.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejemplo")
public class EjemploErrorController {

    // http://localhost:8080/ejemplo/ejemplo1 (get)
    // el numero tiene que ser positivo, o sino se genera un error
    @GetMapping("/ejemplo1")
    public int ejemplo1(int numero) throws Exception {
        if(numero<0) {
            throw new Exception("el numero no puede ser negativo");
        }
        return numero;
    }
    // http://localhost:8080/ejemplo/division (get)
    @GetMapping("/division")
    public int division(int numero1,int numero2) {
        int resultado=0;
        try {
            resultado = numero1 / numero2;
        } catch(Exception ex) {
            resultado=-1;
        }

        return resultado;
    }
}
