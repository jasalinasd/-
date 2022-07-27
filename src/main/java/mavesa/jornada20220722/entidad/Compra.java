package mavesa.jornada20220722.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int numcompra;
    private Date fecha;
    @ManyToOne
    private Producto producto;
    private int cantidad;

}
