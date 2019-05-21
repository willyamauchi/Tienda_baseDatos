package pedido.persistencia;

import java.nio.file.Files;
import java.nio.file.Paths;
import pedido.dominio.Pedido;
import producto.dominio.Producto;

public class PedidoDAO_Imp implements PedidoDAO {

    @Override
    public boolean actualizarPedido(Pedido pedido) {
        String archivoFactura = "Factura.txt";
        try ( var archivo = Files.newBufferedWriter(Paths.get(archivoFactura))) {
            archivo.write("Factura Simplificada");
            System.out.println("Factura Simplificada");
            archivo.newLine();
            archivo.write("---------------------------------------");
            System.out.println("---------------------------------------");
            for (Producto producto : pedido.getCesta()) {
                var codigo = producto.getCodigo();
                var nombre = producto.getNombre();
                var descripcion = producto.getDescripcion();
                var precio = producto.getPrecio();
                
                archivo.newLine();
                archivo.write("Codigo: \t"+codigo);
                archivo.newLine();
                archivo.write("Nombre: \t"+nombre);
                archivo.newLine();
                archivo.write("Descripcion:\t"+descripcion);
                archivo.newLine();
                archivo.write("Costo: \t\t"+String.valueOf(precio));
                archivo.newLine();
                System.out.printf("%-15s %-50d\n%-15s %-50s\n%-15s %-50s\n%-15s %-50.2f \n\n",
                        "Codigo: ",codigo,"Nombre: ",nombre,"Descripcion: ",descripcion,"Costo: ",precio);
            }
             System.out.println("---------------------------------------");
            archivo.newLine();
            archivo.write("Total Factura: "+String.valueOf(pedido.getTotal())+" €");
            System.out.println("Total Factura: "+String.valueOf(pedido.getTotal())+" €\n");
            archivo.newLine();
            archivo.write("Atendido por: "+pedido.getEmpleado());
            System.out.println("Atendido por: "+pedido.getEmpleado()+"\n");
            System.out.println("El archivo se guardo correcto...");
            return true;
        } catch (Exception e) {
        }

        return false;
    }

}
