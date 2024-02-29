package galgje.ui.fx;

import galgje.ui.util.GalgjeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultScreenController {

    public Label solutionlbl;
    @FXML private Label secretWordlbl;
    @FXML private Button guessButton;
    @FXML private Label resultLabel;

    public void setResultMessage(boolean result, String secretWord) {
        if (result) {
            resultLabel.setText("Gefeliciteerd!");
        } else {
            resultLabel.setText("Helaas, je hebt verloren");
        }
        secretWordlbl.setText(secretWord);

    }

    public void startNewGame(ActionEvent actionEvent) {
        showStartScreen(event2stage(actionEvent));
    }


    private Stage event2stage(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        node.getScene();
        return (Stage) node.getScene().getWindow();
    }

    private void showStartScreen(Stage stage) throws GalgjeException {
        try {
            // normally you just use this oneliner to create the root, but to pass the service an additional line is needed.
            // Parent root = FXMLLoader.load(getClass().getResource(patientFileUrl));

            // these 4 lines for passing the service.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/StartScreen_Galgje.fxml"));
            Parent root  = loader.load();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new GalgjeException("could not launch patient screen");
        }
    }
}
