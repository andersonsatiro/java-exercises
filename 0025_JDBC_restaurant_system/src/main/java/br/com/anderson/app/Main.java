package br.com.anderson.app;

public class Main {

    public static void exibirMenu() {
        System.out.println("=====================================");
        System.out.println("        MENU DE GERENCIAMENTO        ");
        System.out.println("=====================================");

        System.out.println("\n------ CLIENTES ------");
        System.out.println("1  - Cadastrar cliente");
        System.out.println("2  - Buscar cliente");
        System.out.println("3  - Alterar dados do cliente");
        System.out.println("4  - Remover cliente");

        System.out.println("\n------ FUNCIONÁRIOS ------");
        System.out.println("5  - Cadastrar funcionário");
        System.out.println("6  - Buscar funcionário");
        System.out.println("7  - Alterar dados do funcionário");
        System.out.println("8  - Remover funcionário");

        System.out.println("\n------ PRODUTOS ------");
        System.out.println("9  - Cadastrar produto");
        System.out.println("10 - Buscar produto");
        System.out.println("11 - Alterar dados do produto");
        System.out.println("12 - Remover produto");

        System.out.println("\n------ CATEGORIAS DE PRODUTOS ------");
        System.out.println("13 - Cadastrar categoria de produto");
        System.out.println("14 - Buscar categoria de produto");
        System.out.println("15 - Alterar dados da categoria de produto");
        System.out.println("16 - Remover categoria de produtos");

        System.out.println("\n------ PEDIDOS ------");
        System.out.println("17 - Criar novo pedido");
        System.out.println("18 - Buscar pedido por ID");
        System.out.println("19 - Listar todos os pedidos");
        System.out.println("20 - Alterar status do pedido");
        System.out.println("21 - Remover pedido");

        System.out.println("\n------ RELATÓRIOS DE CLIENTES ------");
        System.out.println("22 - Clientes com mais pedidos feitos");
        System.out.println("23 - Listagem de clientes por ordem alfabética");
        System.out.println("24 - Listagem de clientes por valor gasto");

        System.out.println("\n------ RELATÓRIOS DE FUNCIONÁRIOS ------");
        System.out.println("25 - Funcionário com mais pedidos processados");
        System.out.println("26 - Listagem de funcionários por ganho");
        System.out.println("27 - Funcionário do mês");

        System.out.println("\n------ RELATÓRIOS DE VENDAS ------");
        System.out.println("28 - Produto mais vendido");
        System.out.println("29 - Listagem de produtos por número de vendas");
        System.out.println("30 - Categoria de produtos mais vendida");
        System.out.println("31 - Listagem de categorias de produtos por número de vendas");

        System.out.println("\n0 - Sair");
        System.out.println("=====================================");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema de gerenciamento de pedidos do restaurante!");

        while(true){

        }
    }
}