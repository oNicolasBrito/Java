package main;

import entidade.Item;
import sistema.sistema;
import entidade.pedido;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sistema sistemaPedidos = new sistema();

        pedido pedido = sistemaPedidos.criarPedido();

        String[] itensComida = {"Hambúrguer", "Batata Frita", "Pizza", "Sopa"};
        double[] precosComida = {20.0, 10.0, 30.0, 15.0};

        String[] itensBebida = {"Refrigerante", "Suco", "Água", "Cerveja"};
        double[] precosBebida = {5.0, 7.0, 3.0, 12.0};

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:"); 
            System.out.println("1 - Adicionar Comida");
            System.out.println("2 - Adicionar Bebida");
            System.out.println("3 - Finalizar Pedido");
            System.out.print("Digite o número da opção: ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nMenu de Comidas:");
                    
                    for (int i = 0; i < itensComida.length; i++) {
                        
                        System.out.println((i + 1) + " - " + itensComida[i] + " - R$" + precosComida[i]);
                    }
                    
                    System.out.print("Escolha o número da comida que deseja adicionar: ");
                    int escolhaComida = sc.nextInt() - 1;
                    
                    if (escolhaComida >= 0 && escolhaComida < itensComida.length) {
                        
                        System.out.print("Digite a quantidade de " + itensComida[escolhaComida] + ": ");
                        int quantidadeComida = sc.nextInt();
                        
                        for (int i = 0; i < quantidadeComida; i++) {
                            
                            pedido.adicionarItem(new Item(itensComida[escolhaComida], precosComida[escolhaComida], "Comida"));
                        }
                        
                        System.out.println(quantidadeComida + " " + itensComida[escolhaComida] + "(s) adicionados ao seu pedido.");
                    
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("\nMenu de Bebidas:");
                    
                    for (int i = 0; i < itensBebida.length; i++) {    
                        System.out.println((i + 1) + " - " + itensBebida[i] + " - R$" + precosBebida[i]);
                    }
                    
                    System.out.print("Escolha o número da bebida que deseja adicionar: ");
                    int escolhaBebida = sc.nextInt() - 1;
                    
                    if (escolhaBebida >= 0 && escolhaBebida < itensBebida.length) {
                        
                        System.out.print("Digite a quantidade de " + itensBebida[escolhaBebida] + ": ");
                        int quantidadeBebida = sc.nextInt();
                        
                        for (int i = 0; i < quantidadeBebida; i++) {
                            pedido.adicionarItem(new Item(itensBebida[escolhaBebida], precosBebida[escolhaBebida], "Bebida"));
                        }
                        
                        System.out.println(quantidadeBebida + " " + itensBebida[escolhaBebida] + "(s) adicionados ao seu pedido.");
                    
                    } else {
                        
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    continuar = false;
                    
                    System.out.println("\nPedido Finalizado!");
                    pedido.exibirPedido();
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}