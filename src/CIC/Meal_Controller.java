package CIC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bb36 on 2/13/2017.
 */
public class Meal_Controller implements Initializable {
    @FXML
    private Label text_meals, text_bonus, text_misc, text_name;
    Login user;
    @FXML
    private Button btn_home_Meal;

    @FXML
    private void homePress(MouseEvent me) {
        btn_home_Meal.setTextFill(Color.rgb(255,255,255));
        btn_home_Meal.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    @FXML
    private void homeRelease(MouseEvent me) {
        btn_home_Meal.setTextFill(Color.rgb(151,37,43));
        btn_home_Meal.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_home();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = new Login();
        text_name.setText(user.getName());
    }

}
