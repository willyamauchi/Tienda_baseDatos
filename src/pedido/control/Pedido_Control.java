package pedido.control;

import Tienda.control.Tienda_Controlador;
import empleado.dominio.Empleado;
import java.util.List;
import java.util.Scanner;
import pedido.dominio.Pedido;
import pedido.persistencia.PedidoDAO_Imp;
import producto.control.Producto_Control;
import producto.dominio.Producto;
import producto.persistencia.ProductoDAO_Imp;

public class Pedido_Control {

    private final int ADD_PRODUCTO_CESTA = 1;
    private final int VISUSALIAR_PRECIO_TOTAL_CESTA = 2;
    private final int IMPRIMIR_FACTURA = 3;
    private final int TERMINAR_PEDIDO = 4;

    private Pedido pedido;
    private Empleado empleado;
    private List<Producto> producto = new ProductoDAO_Imp().leerproducto();

    public Pedido_Control() {
        this.pedido = new Pedido("mario");// falta poner empleado........
    }

    public void submenuPedido() {

        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("--Menú Pedido -------------------");
        System.out.println("   1 Añadir producto a la cesta");
        System.out.println("   2 Visualizar precio total de la cesta");
        System.out.println("   3 Imprimir factura");
        System.out.println("   4 Terminar pedido");
        System.out.println("---------------------------------");
        do {
            System.out.println("Ingrese la op :");
            opcion = sc.nextInt();
        } while (opcion > 4 && opcion < 1);

        elegirOpcionSubMenuPedido(opcion);
    }

    public void elegirOpcionSubMenuPedido(int opcion) {

        switch (opcion) {
            case ADD_PRODUCTO_CESTA:
                addPedidoCesta();
                submenuPedido();
                break;
            case VISUSALIAR_PRECIO_TOTAL_CESTA:
                visualizarPrecioTotalCesta();
                submenuPedido();
                break;
            case IMPRIMIR_FACTURA:
                new PedidoDAO_Imp().actualizarPedido(pedido);
                break;
            case TERMINAR_PEDIDO:
                new Tienda_Controlador().star();
                break;
        }
    }

    public void addPedidoCesta() {
        Scanner sc = new Scanner(System.in);
        int codigo, cantidadProducto;
        String opcion;
        System.out.println("Ingrese la catidad de producto a añadir: ");
        cantidadProducto=sc.nextInt();
        new Producto_Control().mostarProductos();
        int i = 0;
        while (i < cantidadProducto) {
            System.out.println("Ingrese el codigo de producto a añadir:");
            codigo = sc.nextInt();

            for (Producto producto1 : producto) {
                if (codigo == producto1.getCodigo()) {
                    pedido.addProducto(producto1);
                    System.out.println("Se anadio a la cesta: " + producto1.getNombre());

                } else {
                    //  System.out.println("Producto no existe!!!");
                }
            }
            i++;
        }
        
    }

    public void visualizarPrecioTotalCesta() {
        System.out.println("El precio de la cesta es: " + pedido.getTotal());

    }

}
