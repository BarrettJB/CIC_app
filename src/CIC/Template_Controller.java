package CIC;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * Created by bb36 on 3/17/2017.
 */
public class Template_Controller {
    //This class and the associated .fxml file can be used to quickly and easily create new screens
    @FXML
    Button btn_template_home;

    //change appearance of "Home" button when pressed
    @FXML
    private void homePress(MouseEvent me) {
        btn_template_home.setTextFill(Color.rgb(255,255,255));
        btn_template_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //reset appearance of "Home" button when released, go to Home scene
    @FXML
    private void homeRelease(MouseEvent me) {
        btn_template_home.setTextFill(Color.rgb(151, 37, 43));
        btn_template_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_home();
    }
}
