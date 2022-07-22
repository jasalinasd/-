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
public class Solicitud {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int numsolicitud;
    @ManyToOne
    private Cliente cliente;
    private Date fecha;
    @ManyToOne
    private Producto producto;
    private int cantidad;
    @Column(length=50)
    private String estado;

}
