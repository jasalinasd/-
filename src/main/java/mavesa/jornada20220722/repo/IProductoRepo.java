package mavesa.jornada20220722.repo;

import mavesa.jornada20220722.entidad.Producto;
import mavesa.jornada20220722.valueobject.ProductoAgrupadoVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoRepo extends CrudRepository<Producto,Integer>{
    // SUM = SUMAR
    // AVG = Propedio
    // MIN = Minimo
    // MAX = Maximo
    // COUNT = contar (no es sumar), indica la cantidad de elementos.
    @Query("select new mavesa.jornada20220722.valueobject."+
            "ProductoAgrupadoVO(P.catProd.nombre,SUM(P.stockProducto),MIN(P.stockProducto),MAX(P.stockProducto),COUNT(P.stockProducto) )" +
            "from Producto P group by P.catProd.nombre")
    public List<ProductoAgrupadoVO> agrupar();
}