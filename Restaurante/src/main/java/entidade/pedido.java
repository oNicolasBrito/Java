package entidade;

import java.util.ArrayList;
import java.util.List;

public class pedido {
    private int id;
    private List<Item> itens;

    public pedido(int id) {
        this.id = id;
        this.itens = new ArrayList<>();
    }

    public void adicionar(Item item) {
        itens.add(item);
    }

    public double calculo() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void exibirPedido() {
        System.out.println("Pedido ID: " + id);
        for (Item item : itens) {
            System.out.println(item);
        }
        System.out.println("Total: R$" + calculo());
        System.out.println("--------------------");
    }

    public int getId() {
        return id;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }
}
