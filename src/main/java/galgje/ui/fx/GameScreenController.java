package galgje.ui.fx;

import galgje.service.GalgjeService;
import galgje.ui.util.GalgjeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static java.lang.String.valueOf;

public class GameScreenController {

    @FXML private Label wordLabel;
    @FXML private TextField letterField;
    @FXML private Button guessButton;
    @FXML private Label resultLabel;
    @FXML private ImageView hangmanImage;
    @FXML private Label attemptsLabel;
    @FXML private Label error;


    private GalgjeService service;

    public void guess(ActionEvent actionEvent) {
        setError("");
        checkGameStatus(actionEvent);
        String guess = letterField.getText();
        if (letterField.getText().length() > 1) {
            service.checkGuess(guess);
        } else if (letterField.getText().length() == 1){
            service.checkLetter(guess);
        } else {
            setError("vul een letter in, of een woord als je het durft te raden");
        }
        checkGameStatus(actionEvent);
        updateFields();
        letterField.setText("");
    }

    private void checkGameStatus(ActionEvent event) {
        if (service.getAttempts() <= 0) {
            showResultScreen(event2stage(event), false);
        } else if (service.checkWin()) {
            showResultScreen(event2stage(event), true);
        }
    }

    public void setService(GalgjeService service) {
        this.service = service;
        updateFields();
    }

    private void updateFields () {
        wordLabel.setText(service.getCurrentWord());
        setHangmanImage(valueOf(service.getAttempts()));
        attemptsLabel.setText(valueOf(service.getAttempts()));
    }

    public void setHangmanImage(String imagePath) {
        Image image = new Image("galgje/media/" + imagePath);
        hangmanImage.setImage(image);
    }

    private void setError(String errorInput) {
        error.setText(errorInput);
    }

    private Stage event2stage(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        node.getScene();
        return (Stage) node.getScene().getWindow();
    }

    public void showResultScreen(Stage stage, boolean result) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ResultScreen.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Set result message
            ResultScreenController resultScreenController = fxmlLoader.getController();
            resultScreenController.setResultMessage(result, service.getSolution());

            stage.setTitle("Result");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            throw new GalgjeException("could not launch result screen");
        }
    }
}
