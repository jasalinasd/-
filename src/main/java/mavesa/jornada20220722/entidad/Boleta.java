package mavesa.jornada20220722.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Boleta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int numBoleta;
    @ManyToOne
    private Solicitud solicitud;
}
