

package producto.vista;

import java.util.Scanner;
import producto.control.Producto_Control;

public class Vista_Producto {

     private final int MODIFICAR_NOMBRE=1;
     private final int MODIFICAR_PRECIO=2;
     private final int MODIFICAR_CODIGO=3;
    
    public void submenuModificarProducto() {
       
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("-----Menú Productos ---------------");
        System.out.println("   1 Modificar nombre de producto");
        System.out.println("   2 Modificar precio de producto");
        System.out.println("   3 Modificar código de producto");
        System.out.println("-----------------------------------");
        do {
            System.out.println("Ingrese la op :");
            opcion = sc.nextInt();
        } while (opcion > 3);

        elegirOpcionSubMenuProducto(opcion);
    }
    public void elegirOpcionSubMenuProducto(int opcion) {

        switch (opcion) {
            case MODIFICAR_NOMBRE:
               new Producto_Control().modificarNombreProducto();
                
                break;
            case MODIFICAR_PRECIO:
               new Producto_Control().modificarPrecio();
                break;
            case MODIFICAR_CODIGO:
                new Producto_Control().modificarCodigoProducto();
                break;
        }
    }

   
    
}
