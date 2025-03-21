package org.example;

import org.example.DAO.personDAO;
import org.example.DAO.productDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        productDAO productDao = new productDAO(); // Instância do DAO de produtos
        personDAO personDao = new personDAO(); // Instância do DAO de pessoas

        int opcaoMenuPrincipal = 0;

        // Menu principal: escolha entre o menu de produtos ou de pessoas
        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Menu de Produtos");
            System.out.println("2. Menu de Pessoas");
            System.out.println("3. Sair");
            System.out.print("Por favor, selecione uma opção válida: ");
            opcaoMenuPrincipal = scanner.nextInt();

            switch (opcaoMenuPrincipal) {
                case 1:
                    // Menu de Produtos
                    exibirMenuProdutos(scanner, productDao);
                    break;
                case 2:
                    // Menu de Pessoas
                    exibirMenuPessoas(scanner, personDao);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoMenuPrincipal != 3);

        scanner.close();
    }

    // Método para exibir o menu de produtos
    public static void exibirMenuProdutos(Scanner scanner, productDAO productDao) {
        int opcaoProdutos = 0;

        do {
            System.out.println("\nMenu de Produtos:");
            System.out.println("1. Inserir um produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Modificar um produto existente");
            System.out.println("4. Deletar um produto");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Por favor, selecione uma opção válida: ");
            opcaoProdutos = scanner.nextInt();

            switch (opcaoProdutos) {
                case 1:
                    try {
                        productDao.insertProduct();  // Chama o método para adicionar produtos
                    } catch (SQLException e) {
                        System.out.println("Erro ao inserir produto: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        productDao.listProducts();  // Chama o método para listar produtos
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar produtos: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        productDao.modifyProduct();  // Chama o método para modificar produtos
                    } catch (SQLException e) {
                        System.out.println("Erro ao modificar produto: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        productDao.removeProduct();  // Chama o método para remover produtos
                    } catch (SQLException e) {
                        System.out.println("Erro ao deletar produto: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoProdutos != 5);
    }

    // Método para exibir o menu de pessoas
    public static void exibirMenuPessoas(Scanner scanner, personDAO personDao) {
        int opcaoPessoas = 0;

        do {
            System.out.println("\nMenu de Pessoas:");
            System.out.println("1. Inserir uma pessoa");
            System.out.println("2. Listar pessoas");
            System.out.println("3. Modificar uma pessoa existente");
            System.out.println("4. Deletar uma pessoa");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Por favor, selecione uma opção válida: ");
            opcaoPessoas = scanner.nextInt();

            switch (opcaoPessoas) {
                case 1:
                    try {
                        personDao.insertperson();  // Chama o método para adicionar pessoas
                    } catch (SQLException e) {
                        System.out.println("Erro ao inserir pessoa: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        personDao.listpersons();  // Chama o método para listar pessoas
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar pessoas: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        personDao.modifyperson();  // Chama o método para modificar pessoas
                    } catch (SQLException e) {
                        System.out.println("Erro ao modificar pessoa: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        personDao.removeperson();  // Chama o método para remover pessoas
                    } catch (SQLException e) {
                        System.out.println("Erro ao deletar pessoa: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoPessoas != 5);
    }
}
