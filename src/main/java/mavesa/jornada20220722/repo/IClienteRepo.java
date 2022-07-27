package mavesa.jornada20220722.repo;

import mavesa.jornada20220722.entidad.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IClienteRepo extends CrudRepository<Cliente,Integer> {

    @Query("select C from Cliente C where rut=:rut")
    public Cliente buscarPorRut(@Param("rut") String rut);

}
