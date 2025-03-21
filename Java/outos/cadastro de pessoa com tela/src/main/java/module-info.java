module org.example.teladecadastro {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.teladecadastro to javafx.fxml;
    exports org.example.teladecadastro;
}