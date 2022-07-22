package mavesa.jornada20220722.repo;

import mavesa.jornada20220722.entidad.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepo extends CrudRepository<Cliente,Integer> {
}
