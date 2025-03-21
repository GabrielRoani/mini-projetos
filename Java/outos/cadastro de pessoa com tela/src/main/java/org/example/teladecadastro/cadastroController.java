package org.example.teladecadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class cadastroController {

    @FXML
    private TableView<Pessoa> tableView;

    @FXML
    private TableColumn<Pessoa, String> listaNomes;

    @FXML
    private TableColumn<Pessoa, String> listaEmail;

    @FXML
    private TableColumn<Pessoa, Integer> listaIdades;

    @FXML
    private TextField NomeTextField;

    @FXML
    private TextField EmailTextField;

    @FXML
    private TextField IdadeTextField;

    private ObservableList<Pessoa> data;

    @FXML
    private void initialize() {
        // Inicializa a lista de dados
        data = FXCollections.observableArrayList();

        // Configura as colunas da tabela
        listaNomes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        listaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        listaIdades.setCellValueFactory(new PropertyValueFactory<>("idade"));

        // Define os dados da tabela
        tableView.setItems(data);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    @FXML
    private void adicionarPessoa() {
        try {
            String nome = NomeTextField.getText();
            String email = EmailTextField.getText();
            int idade = Integer.parseInt(IdadeTextField.getText());

            if (nome.isEmpty() || email.isEmpty() || String.valueOf(idade).isEmpty()) {
                mostrarAlerta("Erro", "Por favor, preencha todos os campos.");
                return;
            }

            data.add(new Pessoa(nome, email, idade));
            NomeTextField.clear();
            EmailTextField.clear();
            IdadeTextField.clear();
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Por favor, insira uma idade correta.");
        }
    }

}
