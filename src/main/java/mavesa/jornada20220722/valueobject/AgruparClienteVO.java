package mavesa.jornada20220722.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgruparClienteVO {
    private String nombre;
    private long cantidad;
}
