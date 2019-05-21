package Tienda.control;

import empleado.control.Empleado_Controlador;
import java.util.Scanner;
import pedido.vista.Vista_pedido;
import producto.vista.Vista_Producto;

public class Tienda_Controlador {

    private final int HACER_PEDIDO = 1;
    private final int MODIFICAR_PRODUCTO = 2;
    private final int CAMBIAR_PASSWD = 3;
    private final int CERRARSECION = 4;

    private Empleado_Controlador empleadoLog;

    public Tienda_Controlador() {

        this.empleadoLog = new Empleado_Controlador();
    }

    public void star() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("== Bienvenido a la Tienda ==");
        System.out.println("============================");
        while (empleadoLog != null) {
            empleadoLog.login();
            System.out.println("--Menú principal -------------------");
            System.out.println("   1. Hacer pedido");
            System.out.println("   2. Modificar producto");
            System.out.println("   3. Cambiar contraseña de empleado");
            System.out.println("   4. Cerrar sesión");
            System.out.println("------------------------------------");
            System.out.print("Ingrese la opcion : ");
            int op = sc.nextInt();
            opcionMenu(op);
            System.out.println("");
        }

    }

    public void opcionMenu(int opcion) {

        switch (opcion) {
            case HACER_PEDIDO:
                new Vista_pedido().vistaPedido();
                break;
            case MODIFICAR_PRODUCTO:
                new Vista_Producto().submenuModificarProducto();
                break;
            case CAMBIAR_PASSWD:
                new Empleado_Controlador().cambiarPasswordEmpleado();
                break;
            case CERRARSECION:
                new Empleado_Controlador().login();
                break;

        }
    }
}
