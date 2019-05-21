package producto.persistencia;

import java.util.List;
import producto.dominio.Producto;

public interface ProductoDAO {

    List<Producto> leerproducto();
     boolean actualizarProducto(List<Producto> productos);
}
