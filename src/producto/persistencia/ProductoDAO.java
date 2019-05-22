package producto.persistencia;

import java.util.List;
import producto.dominio.Producto;

public interface ProductoDAO {

    List<Producto> leerproducto();

    boolean actualizarPrecio(int codigo, double precio);

    boolean actualizarCodigo(int codigo, int nuevoCodigo);

    boolean actualizarProducto(int codigo, String nombre);
}
