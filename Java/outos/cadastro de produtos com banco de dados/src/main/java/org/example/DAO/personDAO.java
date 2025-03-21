package org.example.DAO;

import org.example.model.person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class personDAO {

    //Cadastrar, modificar, remover, e listar

    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    private Scanner scanner = new Scanner(System.in);
    private List<person> persons = new ArrayList<>();

    // Método para conectar ao banco de dados
    public Connection connection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Insere uma pessoa na lista e no banco de dados
    public void insertperson() throws SQLException {
        // Captura as informações da pessoa
        System.out.println("Diga seu nome:");
        String nome = scanner.next();
        System.out.println("Diga seu cpf:");
        double cpf = scanner.nextDouble();
        System.out.println("Diga sua idade:");
        int idade = scanner.nextInt();

        // Adiciona à lista de pessoas
        person person = new person(nome, cpf, idade);
        persons.add(person);

        // Adiciona ao banco de dados
        Connection conn = connection();
        String insertSql = "INSERT INTO persons (cpf, nome, idade) VALUES (?, ?, ?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
        insertStmt.setDouble(1, cpf);
        insertStmt.setString(2, nome);
        insertStmt.setInt(3, idade);
        insertStmt.executeUpdate();

        System.out.println("Pessoa inserida com sucesso!");
        insertStmt.close();
        conn.close();
    }

    // Modifica uma pessoa existente no banco de dados
    public void modifyperson() throws SQLException {
        System.out.println("Digite o ID da pessoa que deseja modificar:");
        int id = scanner.nextInt();

        System.out.println("Digite o novo nome:");
        String newNome = scanner.next();
        System.out.println("Digite o novo cpf:");
        double newCpf = scanner.nextDouble();
        System.out.println("Digite a nova idade:");
        int newIdade = scanner.nextInt();

        Connection conn = connection();
        String updateSql = "UPDATE persons SET nome = ?, cpf = ?, idade = ? WHERE id = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateSql);
        updateStmt.setString(1, newNome);
        updateStmt.setDouble(2, newCpf);
        updateStmt.setInt(3, newIdade);
        updateStmt.setInt(4, id);
        updateStmt.executeUpdate();

        System.out.println("Pessoa atualizada com sucesso!");
        updateStmt.close();
        conn.close();
    }

    // Remove uma pessoa do banco de dados
    public void removeperson() throws SQLException {
        System.out.println("Digite o ID da pessoa que deseja remover:");
        int id = scanner.nextInt();

        Connection conn = connection();
        String deleteSql = "DELETE FROM persons WHERE id = ?";
        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
        deleteStmt.setInt(1, id);
        deleteStmt.executeUpdate();

        System.out.println("Pessoa removida com sucesso!");
        deleteStmt.close();
        conn.close();
    }

    // Procura uma pessoa pelo nome
    public person searchperson() throws SQLException {
        System.out.println("Digite o nome da pessoa que deseja procurar:");
        String nome = scanner.next();

        Connection conn = connection();
        String searchSql = "SELECT * FROM persons WHERE nome = ?";
        PreparedStatement searchStmt = conn.prepareStatement(searchSql);
        searchStmt.setString(1, nome);
        ResultSet resultSet = searchStmt.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            double cpf = resultSet.getDouble("cpf");
            int idade = resultSet.getInt("idade");
            person person = new person(nome, cpf, idade);
            System.out.println("Pessoa encontrada: ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + ", Idade: " + idade);
            return person;
        } else {
            System.out.println("Pessoa não encontrada.");
            return null;
        }
    }

    // Método para listar pessoas
    public void listpersons() throws SQLException {
        // Lista as pessoas armazenadas localmente (na lista)
        System.out.println("Listando pessoas locais:");
        for (person person : persons) {
            System.out.println(person);
        }

        // Consulta o banco de dados e lista as pessoas lá armazenadas
        Connection conn = connection();
        String selectSql = "SELECT * FROM persons";
        PreparedStatement selectStmt = conn.prepareStatement(selectSql);
        ResultSet resultSet = selectStmt.executeQuery();

        System.out.println("Listando pessoas do banco de dados:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String dbNome = resultSet.getString("nome");
            double dbCpf = resultSet.getDouble("cpf");
            int dbIdade = resultSet.getInt("idade");

            System.out.println("ID: " + id + ", Nome: " + dbNome + ", CPF: " + dbCpf + ", Idade: " + dbIdade);
        }

        resultSet.close();
        selectStmt.close();
        conn.close();
    }
}
