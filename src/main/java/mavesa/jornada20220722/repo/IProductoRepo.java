package mavesa.jornada20220722.repo;

import mavesa.jornada20220722.entidad.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoRepo extends CrudRepository<Producto,Integer>{

}