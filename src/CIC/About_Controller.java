package CIC;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Created by bb36 on 3/17/2017.
 */
public class About_Controller {

    @FXML
    Button btn_home_About;

    //change appearance of "Home" button when pressed
    @FXML
    private void homePress(MouseEvent me) {
        btn_home_About.setTextFill(Color.rgb(255,255,255));
        btn_home_About.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //reset appearance of "Home" button when released, go to Home scene
    @FXML
    private void homeRelease(MouseEvent me) {
        btn_home_About.setTextFill(Color.rgb(151, 37, 43));
        btn_home_About.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_home();
    }
}
