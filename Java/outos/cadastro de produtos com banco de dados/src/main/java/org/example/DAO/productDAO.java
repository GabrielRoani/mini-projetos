package org.example.DAO;

import org.example.model.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class productDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    private Scanner scanner = new Scanner(System.in);
    private List<product> products = new ArrayList<>();

    public Connection connection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertProduct() throws SQLException {
        // Captura as informações do produto
        System.out.println("Diga o nome do seu produto:");
        String nome = scanner.nextLine();
        System.out.println("Escreva o preço unitário desse produto:");
        double preco = scanner.nextDouble();
        System.out.println("Diga a quantidade de estoque deste item:");
        int estoque = scanner.nextInt();

        // Adiciona à lista de produtos
        product product = new product(preco, nome, estoque);
        products.add(product);

        // Adiciona ao banco de dados
        Connection conn = connection();
        String insertSql = "INSERT INTO products (preco, nome, estoque) VALUES (?, ?, ?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
        insertStmt.setDouble(1, preco);
        insertStmt.setString(2, nome);
        insertStmt.setInt(3, estoque);
        insertStmt.executeUpdate();

        System.out.println("Produto inserido com sucesso!");
        insertStmt.close();
        conn.close();
    }

    public void modifyProduct() throws SQLException {
        System.out.println("Digite o ID do produto que deseja modificar:");
        int id = scanner.nextInt();

        System.out.println("Digite o novo nome do produto:");
        String newName = scanner.nextLine();
        System.out.println("Digite o novo preço:");
        double newPrice = scanner.nextDouble();
        System.out.println("Digite a nova quantidade:");
        int newAmount = scanner.nextInt();

        Connection conn = connection();
        String updateSql = "UPDATE products SET nome = ?, preco = ?, estoque = ? WHERE id = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateSql);
        updateStmt.setString(1, newName);
        updateStmt.setDouble(2, newPrice);
        updateStmt.setInt(3, newAmount);
        updateStmt.setInt(4, id);
        updateStmt.executeUpdate();

        System.out.println("Produto atualizado com sucesso!");
        updateStmt.close();
        conn.close();
    }

    public void modifyStock() throws SQLException {
        System.out.println("Digite o ID do produto que deseja modificar:");
        int id = scanner.nextInt();
        System.out.println("Qual será a operação no estoque? 1. Adicionar | 2. Retirar:");
        int escolha = scanner.nextInt();

        Connection conn = connection();
        String selectSql = "SELECT estoque FROM products WHERE id = ?";
        PreparedStatement selectStmt = conn.prepareStatement(selectSql);
        selectStmt.setInt(1, id);
        ResultSet resultSet = selectStmt.executeQuery();

        if (resultSet.next()) {
            int currentStock = resultSet.getInt("estoque");

            switch (escolha) {
                case 1:
                    System.out.println("Quantos itens deseja adicionar ao seu estoque?");
                    int addAmount = scanner.nextInt();
                    currentStock += addAmount;
                    break;
                case 2:
                    System.out.println("Quantos itens deseja retirar do estoque atual?");
                    int removeAmount = scanner.nextInt();
                    currentStock -= removeAmount;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    return;
            }

            String updateSql = "UPDATE products SET estoque = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setInt(1, currentStock);
            updateStmt.setInt(2, id);
            updateStmt.executeUpdate();

            System.out.println("Estoque atualizado com sucesso!");
            updateStmt.close();
        } else {
            System.out.println("Produto não encontrado.");
        }
        resultSet.close();
        selectStmt.close();
        conn.close();
    }

    public void removeProduct() throws SQLException {
        System.out.println("Digite o ID do produto que deseja remover:");
        int id = scanner.nextInt();

        Connection conn = connection();
        String deleteSql = "DELETE FROM products WHERE id = ?";
        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
        deleteStmt.setInt(1, id);
        deleteStmt.executeUpdate();

        System.out.println("Produto removido com sucesso!");
        deleteStmt.close();
        conn.close();
    }

    public product searchProduct() throws SQLException {
        System.out.println("Digite o nome do produto que deseja procurar:");
        String nome = scanner.next();

        Connection conn = connection();
        String searchSql = "SELECT * FROM products WHERE nome = ?";
        PreparedStatement searchStmt = conn.prepareStatement(searchSql);
        searchStmt.setString(1, nome);
        ResultSet resultSet = searchStmt.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            double preco = resultSet.getDouble("preco");
            int estoque = resultSet.getInt("estoque");
            product product = new product(preco, nome, estoque);
            System.out.println("Produto encontrado: ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Quantidade: " + estoque);
            return product;
        } else {
            System.out.println("Produto não encontrado.");
            return null;
        }
    }

    public void listProducts() throws SQLException {

        System.out.println("Listando produtos locais:");
        for (org.example.model.product product : products) {
            System.out.println(product);
        }

        Connection conn = connection();
        String selectSql = "SELECT * from products";
        PreparedStatement selectStmt = conn.prepareStatement(selectSql);
        ResultSet resultSet = selectStmt.executeQuery();

        System.out.println("Listando produtos do banco de dados:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String dbName = resultSet.getString("nome");
            double dbPrice = resultSet.getDouble("preco");
            int dbAmount = resultSet.getInt("estoque");

            System.out.println("ID: " + id + ", Name: " + dbName + ", Price: " + dbPrice + ", Amount: " + dbAmount);
        }

        resultSet.close();
        selectStmt.close();
        conn.close();
    }

}
