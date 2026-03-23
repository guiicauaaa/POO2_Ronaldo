package calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Carrega o arquivo FXML
        // Como estão no mesmo pacote, usamos o getResource relativo
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        
        primaryStage.setTitle("Calculadora de IMC - POO2");
        
        // Cria a cena com o tamanho definido
        primaryStage.setScene(new Scene(root, 350, 450));
        
        // Mostra a janela
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch(args);
    }
}