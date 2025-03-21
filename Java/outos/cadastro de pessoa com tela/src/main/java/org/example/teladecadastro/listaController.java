package org.example.teladecadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class listaController {

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
    private void removerPessoa() {
        Pessoa selectedPessoa = tableView.getSelectionModel().getSelectedItem();
        if (selectedPessoa != null) {
            data.remove(selectedPessoa);
        } else {
            mostrarAlerta("Erro", "Por favor, selecione uma pessoa para remover.");
        }
    }

}
