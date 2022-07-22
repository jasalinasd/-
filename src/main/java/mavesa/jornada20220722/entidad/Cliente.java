package mavesa.jornada20220722.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Setter @Getter
public class Cliente {
    @Id
    private String rut;
    @Column(length = 100)
    private String nombre;
}
