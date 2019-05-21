package pedido.dominio;

import java.util.ArrayList;
import java.util.List;
import producto.dominio.Producto;

public class Pedido {

    private List<Producto> cesta;
    private String empleado;
    private double total;

    public Pedido(String empleado) {
        this.cesta = new ArrayList<Producto>();
        this.empleado = empleado;
        this.total = 0;
    }

   
    public void addProducto(Producto producto){
        cesta.add(producto);
        total+=producto.getPrecio();
    }

    public List<Producto> getCesta() {
        return cesta;
    }

    public void setCesta(List<Producto> cesta) {
        this.cesta = cesta;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
