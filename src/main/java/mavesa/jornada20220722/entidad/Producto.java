package mavesa.jornada20220722.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int numProducto;
   @Column(length=100)
   private String nombreProducto;
   private int stockProducto;
}
