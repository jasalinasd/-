package mavesa.jornada20220722.controlador;

import mavesa.jornada20220722.entidad.Compra;
import mavesa.jornada20220722.entidad.Producto;
import mavesa.jornada20220722.repo.ICompraRepo;
import mavesa.jornada20220722.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/compra")
public class CompraControlador {
    @Autowired
    private IProductoRepo iProductoRepo;

    @Autowired
    private ICompraRepo iCompraRepo;

    // http://localhost:8080/compra/comprar?numProducto=1&cantidad=10
    @GetMapping("/comprar")
    public Producto comprar(int numProducto, int cantidad) throws Exception  {
        if(iProductoRepo.findById(numProducto).isPresent()==false) {
            // genero un error (finaliza la funcion)
            throw new Exception("El producto no existe");
        }
        // aumentamos el stock y lo guardamos en la base de datos
        Producto pro= iProductoRepo.findById(numProducto).get();
        pro.setStockProducto(pro.getStockProducto()+cantidad);
        iProductoRepo.save(pro);
        // registrar la compra
        Compra compra=new Compra();
        compra.setCantidad(cantidad);
        compra.setFecha(new Date());
        compra.setProducto(pro);
        iCompraRepo.save(compra);

        return pro;
    }

    // http://localhost:8080/compra/comprar/1/10
    @GetMapping("/comprar2/{numProducto}/{cantidad}")
    public Producto comprar2(@PathVariable("numProducto") int numProducto, @PathVariable("cantidad") int cantidad) throws Exception  {
        if(iProductoRepo.findById(numProducto).isPresent()==false) {
            // genero un error (finaliza la funcion)
            throw new Exception("El producto no existe");
        }
        // aumentamos el stock y lo guardamos en la base de datos
        Producto pro= iProductoRepo.findById(numProducto).get();
        pro.setStockProducto(pro.getStockProducto()+cantidad);
        iProductoRepo.save(pro);

        // registrar la compra
        Compra compra=new Compra();
        compra.setCantidad(cantidad);
        compra.setFecha(new Date());
        compra.setProducto(pro);
        iCompraRepo.save(compra);

        return pro;
    }
}
