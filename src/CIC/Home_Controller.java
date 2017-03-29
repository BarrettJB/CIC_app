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
    //initialize buttons on home screen
    @FXML
    private Button btn_pin_home, btn_map_home, btn_lost_home;

    //exits program, hide when finished
    @FXML
    private void exitPress(ActionEvent event) {
        System.exit(0);
    }

    //"Lost ID" button pressed
    @FXML
    private void lostPress(MouseEvent me) {
        //change appearance of button
        btn_lost_home.setTextFill(Color.rgb(255,255,255));
        btn_lost_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Lost ID" button released
    @FXML
    private void lostRelease(MouseEvent me) {
        //change appearance of button
        btn_lost_home.setTextFill(Color.rgb(151,37,43));
        btn_lost_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Lost
        Main.goto_scn_Lost();
    }

    //"Campus Map" button pressed
    @FXML
    private void mapPress(MouseEvent me) {
        //change appearance of button
        btn_map_home.setTextFill(Color.rgb(255,255,255));
        btn_map_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Campus Map" button released
    @FXML
    private void mapRelease(MouseEvent me) {
        //change appearance of button
        btn_map_home.setTextFill(Color.rgb(151,37,43));
        btn_map_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Map
        Main.goto_scn_Map();
    }

    //"Log In" button pressed
    @FXML
    private void pinPress(MouseEvent me) {
        //change appearance of button
        btn_pin_home.setTextFill(Color.rgb(255,255,255));
        btn_pin_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Log In" button released
    @FXML
    private void pinRelease(MouseEvent me) {
        //change appearance of button
        btn_pin_home.setTextFill(Color.rgb(151,37,43));
        btn_pin_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to PIN
        Main.goto_scn_PIN();
    }
}
