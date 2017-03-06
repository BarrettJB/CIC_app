package CIC;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

/**
 * Created by bb36 on 2/20/2017.
 */
public class Lost_Controller {
    @FXML
    private Button btn_home_Lost;
    @FXML
    private void homePress(MouseEvent me) {
        btn_home_Lost.setTextFill(Color.rgb(255,255,255));
        btn_home_Lost.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    @FXML
    private void homeRelease(MouseEvent me) {
        btn_home_Lost.setTextFill(Color.rgb(151,37,43));
        btn_home_Lost.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_home();
    }

}
