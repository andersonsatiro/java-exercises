package br.com.anderson.app;

import br.com.anderson.utils.ScannerUtil;

import java.util.Scanner;

public class Main {

    public static void exibirMenu() {
        System.out.println("=====================================");
        System.out.println("          Navegue pelo MENU          ");
        System.out.println("=====================================");
        System.out.println("1 - Clientes");
        System.out.println("2 - Funcionários");
        System.out.println("3 - Produtos");
        System.out.println("4 - Categorias de produtos");
        System.out.println("5 - Pedidos");
        System.out.println("6 - Relatórios de clientes");
        System.out.println("7 - Relatórios de funcionários");
        System.out.println("8 - Relatórios de vendas");
        System.out.println("0 - Sair\n");
    }

    public static void menuCliente() {
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Buscar cliente");
        System.out.println("3 - Alterar dados do cliente"); /* Escolher o dado */
        System.out.println("4 - Remover cliente");
        System.out.println("5 - Voltar");
    }

    public static void menuFuncionario() {
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Buscar funcionário");
        System.out.println("3 - Alterar dados do funcionário"); /* Escolher dado */
        System.out.println("4 - Remover funcionário");
        System.out.println("5 - Voltar");
    }

    public static void menuProduto() {
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Buscar produto");
        System.out.println("3 - Alterar dados do produto"); /* Escolher dado */
        System.out.println("4 - Remover produto");
        System.out.println("5 - Voltar");
    }

    public static void menuCategoriaProduto() {
        System.out.println("1 - Cadastrar categoria de produto");
        System.out.println("2 - Buscar categoria de produto");
        System.out.println("3 - Alterar dados da categoria de produto"); /* Escolher dado */
        System.out.println("4 - Remover categoria de produto");
        System.out.println("5 - Voltar");
    }

    public static void menuPedido() {
        System.out.println("1 - Criar novo pedido");
        System.out.println("2 - Buscar pedido por ID");
        System.out.println("3 - Listar todos os pedidos");
        System.out.println("4 - Alterar status do pedido");
        System.out.println("5 - Remover produto");
        System.out.println("6 - Voltar");
    }

    public static void menuRelatorioClientes() {
        System.out.println("1 - Clientes com mais pedidos feitos");
        System.out.println("2 - Listagem de clientes por ordem alfabética");
        System.out.println("3 - Listagem de clientes por valor gasto");
        System.out.println("4 - Voltar");
    }

    public static void menuRelatorioFuncionarios() {
        System.out.println("1 - Funcionários com mais pedidos processados");
        System.out.println("2 - Listagem de funcionários por ganho");
        System.out.println("3 - Funcionário do mês");
        System.out.println("4 - Voltar");
    }

    public static void menuRelatorioVendas() {
        System.out.println("1 - Produto mais vendido");
        System.out.println("2 - Listagem de produtos por número de vendas");
        System.out.println("3 - Categoria de produtos mais vendida");
        System.out.println("4 - Listagem de categorias de produtos por número de vendas");
        System.out.println("5 - Voltar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScannerUtil scannerUtil = new ScannerUtil(sc);

        exibirMenu();
        int option = scannerUtil.requestInteger("Digite aqui");

        switch(option) {
            case 1:
                menuCliente();
                break;
            case 2:
                menuFuncionario();
                break;
            case 3:
                menuProduto();
                break;
            case 4:
                menuCategoriaProduto();
                break;
            case 5:
                menuPedido();
                break;
            case 6:
                menuRelatorioClientes();
                break;
            case 7:
                menuRelatorioFuncionarios();
                break;
            case 8:
                menuRelatorioVendas();
                break;
            default:
                System.out.println("valor default");
        }
    }
}
