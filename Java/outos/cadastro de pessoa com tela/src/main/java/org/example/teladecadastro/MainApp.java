package org.example.teladecadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Certifique-se de que o arquivo FXML esteja no local correto
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("telaPrincipal.fxml"));

            Parent root = loader.load();
            primaryStage.setTitle("Cadastro de Usuários");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            // Tratamento de exceção para erro ao carregar o FXML
            e.printStackTrace();
            System.out.println("Erro ao carregar o arquivo FXML. Verifique o caminho e o nome do arquivo.");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
