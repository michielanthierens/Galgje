package galgje.ui.fx;

import galgje.service.GalgjeService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameScreenController {

    @FXML private Label wordLabel;
    @FXML private TextField letterField;
    @FXML private Button guessButton;
    @FXML private Label resultLabel;
    @FXML private Label attemptsLabel;
    @FXML private GalgjeService service;

    public void setService(GalgjeService service) {
        this.service = service;
        // init methods
        // show currentWord
        // show errors
        // show attempts left

    }
}
