package pedido.vista;

import empleado.dominio.Empleado;
import pedido.control.Pedido_Control;

public class Vista_pedido {

    private Empleado empleado;
    
    public void vistaPedido(){
        
        new Pedido_Control().submenuPedido();
    }
}
