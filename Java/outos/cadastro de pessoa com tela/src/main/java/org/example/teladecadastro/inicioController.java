package org.example.teladecadastro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class inicioController {

    @FXML
    private Button btnTelaCadastro;

    @FXML
    private Button btnTelaLista;

    @FXML
    private void telaCadastro() throws Exception {
        carregarTela("/org/example/teladecadastro/telaCadastro.fxml");
    }

    @FXML
    private void telaLista() throws Exception {
        carregarTela("/org/example/teladecadastro/telaLista.fxml");
    }

    private void carregarTela(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();

        Stage stage = (Stage) btnTelaCadastro.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
