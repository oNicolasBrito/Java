
package sistema;

import entidade.Item;
import entidade.pedido;
import java.util.ArrayList;
import java.util.List;

public class sistema {
    private List<pedido> pedidos;
    private int proximoIdPedido;

    public sistema() {
        this.pedidos = new ArrayList<>();
        this.proximoIdPedido = 1;
    }

    public pedido criarPedido() {
        pedido pedido = new pedido(proximoIdPedido++);
        pedidos.add(pedido);
        return pedido;
    }

    public void exibirPedidos() {
        for (pedido pedido : pedidos) {
            pedido.exibirPedido();
        }
    }

    public static void main(String[] args) {

        sistema sistemaPedidos = new sistema();


        pedido pedido1 = sistemaPedidos.criarPedido();
        pedido1.adicionar(new Item("Hambúrguer", 20.0, "Comida"));
        pedido1.adicionar(new Item("Batata Frita", 10.0, "Comida"));
        pedido1.adicionar(new Item("Refrigerante", 5.0, "Bebida"));


        pedido pedido2 = sistemaPedidos.criarPedido();
        pedido2.adicionar(new Item("Hambúrguer", 20.0, "Comida"));
        pedido2.adicionar(new Item("Refrigerante", 5.0, "Bebida"));

     
        sistemaPedidos.exibirPedidos();
    }
}
