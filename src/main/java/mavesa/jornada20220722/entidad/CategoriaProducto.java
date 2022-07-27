package mavesa.jornada20220722.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProducto {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int numCategoria;
    private String nombre;

}
