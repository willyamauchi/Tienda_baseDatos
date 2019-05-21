package producto.control;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import producto.dominio.Producto;
import producto.persistencia.ProductoDAO_Imp;

public class Producto_Control {

    private List<Producto> productos;

    public Producto_Control() {
        this.productos = new ProductoDAO_Imp().leerproducto();
    }

    public void modificarCodigoProducto() {
        Scanner sc = new Scanner(System.in);
        int codigo, codigoNuevo, indice = 0;
        String nombreFile = "productos.txt";
        boolean productoOK, archivoOK = true;
        mostarProductos();
        while (archivoOK) {
            try {
                System.out.println("Ingrese el codigo...");
                codigo = sc.nextInt();
                for (Producto producto1 : productos) {
                    if (codigo == producto1.getCodigo()) {
                        System.out.println("Ingrese el nuevo codigo a cambiar...");
                        codigoNuevo = sc.nextInt();
                        for (Producto producto2 : productos) {
                            if (!(codigoNuevo == producto2.getCodigo())) {
                                productos.get(indice).setCodigo(codigoNuevo);
                                productoOK = new ProductoDAO_Imp().actualizarProducto(productos);
                                if (productoOK) {
                                    System.out.println("Se guardo satisfactoriamente el archivo productos.txt ");
                                    archivoOK = false;
                                } else {
                                    System.out.println("NO se ha guardo archivo productos.txt ");

                                }

                            } else {
                                System.out.println("El codigo Ingresdo ya esxite!!!");
                                break;
                            }
                        }
                    }
                    indice++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo se adminten numeros");
                sc.next();
            }
        }

    }

    public void mostarProductos() {
        // List<Producto> producto = new Producto().leerProductos();
        System.out.println("Codigo  \tNombre \t\t\tDescripcion \t\t\t\t\t\t   Precio");
        for (Producto producto1 : productos) {
            var codigo1 = producto1.getCodigo();
            var nombre = producto1.getNombre();
            var descripcion = producto1.getDescripcion();
            var precio = producto1.getPrecio();
            System.out.printf("%-10d %-25s %-60s %.2f \n", codigo1, nombre, descripcion, precio);

        }
        System.out.println("");

    }

    public void modificarPrecio() {
        Scanner sc = new Scanner(System.in);
        // List<Producto> producto = new Producto().leerProductos();
        int codigo, indice = 0;
        String nombreFile = "productos.txt";
        boolean productoOK;
        double precioModificar;
        mostarProductos();
        System.out.println("Ingrese codigo del producto a modificar");
        codigo = sc.nextInt();
        if (codigo > 0) {
            for (Producto producto1 : productos) {
                if (codigo == producto1.getCodigo()) {
                    System.out.println("Ingrese el nuevo precio.... Formato(00,00)...");
                    precioModificar = sc.nextDouble();
                    if (!(precioModificar == producto1.getPrecio())) {
                        productos.get(indice).setPrecio(precioModificar);
                        productoOK = new ProductoDAO_Imp().actualizarProducto(productos);
                        if (productoOK) {
                            System.out.println("Se guardo satisfactoriamente el archivo productos.txt ");
                        } else {
                            System.out.println("NO se ha guardo archivo productos.txt ");

                        }

                    }
                }
                indice++;
            }

        }

    }

    public void modificarNombreProducto() {
        Scanner sc = new Scanner(System.in);
        //    List<Producto> producto = new Producto().leerProductos();
        int codigo, indice = 0;
        String nombreFile = "productos.txt";
        boolean productoOK;
        String nombreNuevo;
        mostarProductos();
        System.out.println("Ingrese codigo del producto a modificar");
        codigo = sc.nextInt();
        if (codigo > 0) {
            for (Producto producto1 : productos) {
                if (codigo == producto1.getCodigo()) {
                    System.out.println("Ingrese el nuevo nombre....");
                    nombreNuevo = sc.next();
                    if (!(nombreNuevo.equalsIgnoreCase(producto1.getNombre()))) {
                        productos.get(indice).setNombre(nombreNuevo);
                        productoOK = new ProductoDAO_Imp().actualizarProducto(productos);
                        if (productoOK) {
                            System.out.println("Se guardo satisfactoriamente el archivo productos.txt ");
                        } else {
                            System.out.println("NO se ha guardo archivo productos.txt ");

                        }

                    } else {
                        System.out.println("No se ha guardado el archivo..... \n El nombre ingresado es igual al anterior");
                    }
                }
                indice++;
            }

        }

    }

}
