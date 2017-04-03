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

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by bb36 on 2/13/2017.
 */
public class Meal_Controller {
    @FXML
    public Label text_meals, text_bonus, text_name, text_uid, text_update;
    @FXML
    private Button btn_home_Meal;
    String user_info;
    String str_meals, str_bonus, str_name, str_update, str_maxmeals, str_weekly, str_uid, str_name_temp;
    String[] array_name;

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
        user_info = APIController.getUser(PIN_Controller.pin_saved, true);
        try {
            JSONObject info = new JSONObject(user_info);
            str_uid = info.getString("uID");
            str_name_temp = info.getString("name");
            Double num_bonus = info.getDouble("bonusBucks");
            str_bonus = num_bonus.toString();
            str_update = info.getString("updated");
            JSONObject meals = info.getJSONObject("mealPlan");
            Integer num_meals = meals.getInt("count");
            str_meals = num_meals.toString();
            Boolean weekly = meals.getBoolean("isWeekly");
            if (weekly) {
                str_weekly = "this week";
            } else {
                str_weekly = "this semester";
            }
            Integer max_meals = meals.getInt("maxMeals");
            str_maxmeals = max_meals.toString();


        } catch (Exception ex) {
            System.out.println("test");
        }
        array_name = str_name_temp.split(", ");
        str_name = array_name[1]+" "+array_name[0];
        text_name.setText(str_name);
        text_uid.setText(str_uid);
        text_bonus.setText(str_bonus);
        text_meals.setText(str_meals+" of "+str_maxmeals+" left "+str_weekly);
        text_update.setText(str_update);
    }

}
