package CIC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bb36 on 2/13/2017.
 */
public class Meal_Controller {
    @FXML
    public Label text_meals, text_bonus, text_misc, text_name;
    @FXML
    private Button btn_home_Meal;
    String user_info;

    //"Home" button pressed
    @FXML
    private void homePress(MouseEvent me) {
        //change appearance of button
        btn_home_Meal.setTextFill(Color.rgb(255,255,255));
        btn_home_Meal.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Home" button released
    @FXML
    private void homeRelease(MouseEvent me) throws IOException {
        //change appearance of button
        btn_home_Meal.setTextFill(Color.rgb(151,37,43));
        btn_home_Meal.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //reset scene to PIN
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PIN.fxml"));
        Parent root = loader.load();
        btn_home_Meal.getScene().setRoot(root);
        //change scene to Home
        Main.goto_scn_home();
    }

    //gets info about who just logged in and displays appropriately
    public void setLabelTexts() {
        user_info = (String)PIN_Controller.students.get(PIN_Controller.pin_saved);
        String[] parts = user_info.split(",");
        text_name.setText(parts[0]);
        text_meals.setText(parts[1]);
        text_bonus.setText(parts[2]);
        text_misc.setText(parts[3]);
    }

}
