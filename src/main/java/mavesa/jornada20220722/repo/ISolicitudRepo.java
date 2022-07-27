package mavesa.jornada20220722.repo;

import mavesa.jornada20220722.entidad.Solicitud;
import mavesa.jornada20220722.valueobject.AgruparClienteVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISolicitudRepo extends CrudRepository<Solicitud,Integer> {
    @Query("select new mavesa.jornada20220722.valueobject.AgruparClienteVO(S.cliente.nombre,SUM(S.cantidad)) "+
            "from Solicitud S group by S.cliente.nombre order by SUM(S.cantidad) desc")
    public List<AgruparClienteVO> listarAgrupado();
}
