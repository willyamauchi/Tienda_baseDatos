

package producto.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import producto.dominio.Producto;


public class ProductoDAO_Imp implements ProductoDAO{

    @Override
    public List<Producto> leerproducto() {
         List<Producto> productos = new ArrayList<>();
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRENCH);
        Number numero;
        String LineaConDatos;
        String archivosProductos = "productos.txt";
        System.out.println();
        try ( BufferedReader archivo = Files.newBufferedReader(Paths.get(archivosProductos))) {
            while (archivo.readLine() != null) {
                //codigo
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(LineaConDatos);
                int codigo = numero.intValue();
                //nombre
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                String nombre = LineaConDatos;
                //descrip
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                String descripcion = LineaConDatos;
                //precio
                archivo.readLine();
                LineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(LineaConDatos);
                double precio = numero.doubleValue();

                productos.add(new Producto(codigo, nombre, descripcion, precio));

            }
        } catch (ParseException e) {
            System.out.println("Error de formato de numero");

        } catch (IOException e) {
            System.out.println("Error de formato de Archivo");
        }

        return productos;

    }

    @Override
    public boolean actualizarProducto(List<Producto> productos) {
        boolean escribeProductoOk;
        String nombreFile="productos.txt";
        try ( var fw = new FileWriter(nombreFile);  var br = new BufferedWriter(fw)) {
            for (Producto producto : productos) {
                var codigo1 = producto.getCodigo();
                var nombre = producto.getNombre();
                var descripcion = producto.getDescripcion();
                var precio = producto.getPrecio();
                br.write("[producto] ");
                br.newLine();
                br.write("   [codigo]");
                br.newLine();
                br.write("   " + codigo1);
                br.newLine();
                br.write("   [nombre]");
                br.newLine();
                br.write("   " + nombre);
                br.newLine();
                br.write("   [descripcion]");
                br.newLine();
                br.write("   " + descripcion);
                br.newLine();
                br.write("   [precio]");
                br.newLine();
                br.write("   " + precio);
                br.newLine();
            }
            escribeProductoOk = true;
        } catch (Exception e) {
            escribeProductoOk = false;
        }
        return escribeProductoOk; //To change body of generated methods, choose Tools | Templates.
    }

}
