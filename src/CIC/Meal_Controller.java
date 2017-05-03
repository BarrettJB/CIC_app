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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.Instant;
import java.time.Duration;
/**
 * Created by bb36 on 2/13/2017.
 */
public class Meal_Controller {
    //this class parses and displays meal information after the student id card is swiped
    @FXML
    public Label text_meals, text_bonus, text_name, text_uid, text_update;
    @FXML
    private Button btn_meal_home;
    String user_info;
    String str_meals, str_bonus, str_name, str_update, str_maxmeals, str_weekly, str_uid, str_name_temp;
    String[] array_name;

    //"Home" button pressed
    @FXML
    private void homePress(MouseEvent me) {
        //change appearance of button
        btn_meal_home.setTextFill(Color.rgb(255,255,255));
        btn_meal_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Home" button released
    @FXML
    private void homeRelease(MouseEvent me) throws IOException {
        //change appearance of button
        btn_meal_home.setTextFill(Color.rgb(151,37,43));
        btn_meal_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //reset scene to PIN
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        btn_meal_home.getScene().setRoot(root);
        //btn_meal_home.getScene().setRoot(Main.par_Home);
        //change scene to Home
        Main.goto_scn_home();
    }

    //gets info about who just logged in and displays appropriately
    public boolean setLabelTexts() {
        //if valid id number, set labels and return true
        //if not, return false
        user_info = APIController.getUser(Home_Controller.studentid, true);
        if (user_info.equals("error")) {
            return false;
        } else {
            try {
                //parse user data
                JSONObject info = new JSONObject(user_info);
                str_uid = info.getString("uID");
                str_name_temp = info.getString("name");
                Double num_bonus = info.getDouble("bonusBucks");
                str_bonus = num_bonus.toString();
                str_update = info.getString("updated");
                //format date into readable time
                long diff = Duration.between(Instant.parse(str_update), Instant.now()).getSeconds();
                if (diff < 60) str_update = (diff + " seconds ago");
                else if ((diff = (diff / 60)) < 60) str_update = (diff + " minutes ago");
                else if ((diff = (diff / 60)) < 24) str_update = (diff + " hours ago");
                else str_update = ((diff = (diff / 24)) + " days ago");
                Integer num_meals = 0;
                Boolean weekly = false;
                Integer max_meals = 0;
                try {
                    JSONObject meals = info.getJSONObject("mealPlan");
                    num_meals = meals.getInt("count");
                    weekly = meals.getBoolean("isWeekly");
                    max_meals = meals.getInt("max");
                } catch (JSONException j) {
                    System.out.println("Warning: JSON Exception when parsing meal plan!\n" + j);
                }

                str_meals = num_meals.toString();
                if (weekly) {
                    str_weekly = "this week";
                } else {
                    str_weekly = "this semester";
                }

                str_maxmeals = max_meals.toString();


            } catch (Exception ex) {
                System.out.println("test");
                System.out.println(ex);
            }
            //set labels with user data
            array_name = str_name_temp.split(",");
            str_name = array_name[1] + " " + array_name[0];
            text_name.setText(str_name);
            text_uid.setText(str_uid);
            text_bonus.setText(str_bonus);
            text_meals.setText(str_meals + " of " + str_maxmeals + " left " + str_weekly);
            text_update.setText(str_update);

            //record id and time to log
            try {
                File f = new File("cardlog.txt");
                FileWriter fw = new FileWriter(f,true);
                fw.write(Instant.now().toString()+" "+str_uid+"\n");
                fw.flush();
                fw.close();
            } catch (IOException e) {
                System.out.println("log entry failed");
            }

            return true;
        }
    }
}
