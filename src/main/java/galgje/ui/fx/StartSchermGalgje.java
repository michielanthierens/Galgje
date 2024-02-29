package galgje.ui.fx;

import galgje.domain.Game;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartSchermGalgje {

    private static final Logger LOGGER = Logger.getLogger(StartSchermGalgje.class.getName());
    private static final String RULES_TEXT = "Regels van Galgje:\n" +
            "1. Een speler kiest een woord en de andere speler moet dat woord raden.\n" +
            "2. De speler heeft een beperkt aantal pogingen om het woord correct te raden.\n" +
            "3. Voor elke foutieve poging wordt een deel van de galg getekend.\n" +
            "4. Als de galg compleet is getekend voordat het woord is geraden, verliest de speler.\n" +
            "5. De speler wint als het woord correct wordt geraden voordat de galg compleet is.";

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
    @FXML
    private Label error;

    private boolean rulesAreVisible;

    @FXML
    public void toggleRules() {
        rulesAreVisible = !rulesAreVisible;

        show_rules_btn.setVisible(!rulesAreVisible);
        rules_box.setVisible(rulesAreVisible);
        hide_rules_btn.setVisible(rulesAreVisible);

    }

    @FXML
    void startGame(ActionEvent event) {
        if (input_txt.toString().length() > 4) {
            showGameScreen(event2stage(event));
        } else {
            error.setText("try a longer word");
        }
    }

    private Stage event2stage(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        node.getScene();
        return (Stage) node.getScene().getWindow();
    }

    private void showGameScreen(Stage stage) throws GalgjeException {
        try {
            // normally you just use this oneliner to create the root, but to pass the service an additional line is needed.
            // Parent root = FXMLLoader.load(getClass().getResource(patientFileUrl));

            // these 4 lines for passing the service.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameScreenGalgje.fxml"));
            Parent root  = loader.load();

            Game game = new Game(input_txt.toString());
            GalgjeService service = new GalgjeService(game);

            GameScreenController controller = loader.getController();
            controller.setService(service);

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to open main screen", e);
            error.setText("Failed to open main screen");
            throw new GalgjeException("could not launch patient screen");
        }
    }

    @FXML
    void initialize() {
        rules_lbl.setText(RULES_TEXT);
        rulesAreVisible = false;
    }
}
