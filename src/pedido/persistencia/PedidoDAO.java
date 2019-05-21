package pedido.persistencia;

import pedido.dominio.Pedido;

public interface PedidoDAO {

    boolean actualizarPedido(Pedido pedido);

}
