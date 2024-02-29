package galgje.ui.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Program extends Application {

    private static final String START_SCREEN = "/fxml/StartScreen_Galgje.fxml";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(START_SCREEN)));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("startscherm");
        primaryStage.show();
    }
}
