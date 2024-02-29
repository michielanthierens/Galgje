package galgje.ui.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class StartSchermGalgje {

    @FXML
    private Label title_lbl;
    @FXML
    private VBox rules_box;
    @FXML
    private Label ask_input_lbl;
    @FXML
    private Button hide_rules_btn;
    @FXML
    private TextField input_txt;
    @FXML
    private Label rules_lbl;
    @FXML
    private Button show_rules_btn;
    @FXML
    private Button start_game_btn;

    private final String rulesText = "Regels van Galgje:\n" +
            "1. Een speler kiest een woord en de andere speler moet dat woord raden.\n" +
            "2. De speler heeft een beperkt aantal pogingen om het woord correct te raden.\n" +
            "3. Voor elke foutieve poging wordt een deel van de galg getekend.\n" +
            "4. Als de galg compleet is getekend voordat het woord is geraden, verliest de speler.\n" +
            "5. De speler wint als het woord correct wordt geraden voordat de galg compleet is.";

    private boolean rulesAreVisible;

    @FXML
    public void toggleRules() {
        rulesAreVisible = !rulesAreVisible;

        show_rules_btn.setVisible(!rulesAreVisible);
        rules_box.setVisible(rulesAreVisible);
        hide_rules_btn.setVisible(rulesAreVisible);

    }

    @FXML
    void start_game(ActionEvent event) {
        // Add logic for starting the game here
    }

    @FXML
    void initialize() {
        rules_lbl.setText(rulesText);
        rulesAreVisible = false;
    }
}
