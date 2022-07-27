package mavesa.jornada20220722.valueobject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// ValueObject (VO) Objeto valioso?
// En una clase de modelo, que se usa para transportar informacion.
// No existe en la base de datos


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoAgrupadoVO {
    private String categoria;
    private Long cantidad;
    private int min;
    private int max;
    private Long conteo;


}
