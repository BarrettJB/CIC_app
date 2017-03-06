package CIC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Created by bb36 on 2/13/2017.
 */
public class Home_Controller {
    @FXML
    private Button btn_pin_home, btn_map_home, btn_lost_home;

    @FXML
    private void exitPress(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void lostPress(MouseEvent me) {
        btn_lost_home.setTextFill(Color.rgb(255,255,255));
        btn_lost_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    @FXML
    private void lostRelease(MouseEvent me) {
        btn_lost_home.setTextFill(Color.rgb(151,37,43));
        btn_lost_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_Lost();
    }

    @FXML
    private void mapPress(MouseEvent me) {
        btn_map_home.setTextFill(Color.rgb(255,255,255));
        btn_map_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    @FXML
    private void mapRelease(MouseEvent me) {
        btn_map_home.setTextFill(Color.rgb(151,37,43));
        btn_map_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_Map();
    }

    @FXML
    private void pinPress(MouseEvent me) {
        btn_pin_home.setTextFill(Color.rgb(255,255,255));
        btn_pin_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    @FXML
    private void pinRelease(MouseEvent me) {
        btn_pin_home.setTextFill(Color.rgb(151,37,43));
        btn_pin_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_PIN();
    }
}
