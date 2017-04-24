package CIC;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bb36 on 2/13/2017.
 */
public class Home_Controller {
    //initialize buttons on home screen
    @FXML
    private Button btn_pin_home, btn_map_home, btn_lost_home;
    static String studentid;

    //exits program, hide when finished
    @FXML
    private void exitPress(ActionEvent event) {
        System.exit(0);
    }

    //"Lost ID" button pressed
    @FXML
    private void lostPress(MouseEvent me) {
        //change appearance of button
        btn_lost_home.setTextFill(Color.rgb(255, 255, 255));
        btn_lost_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }

    //"Lost ID" button released
    @FXML
    private void lostRelease(MouseEvent me) {
        //change appearance of button
        btn_lost_home.setTextFill(Color.rgb(151, 37, 43));
        btn_lost_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Lost
        Main.goto_scn_Lost();
    }

    //"Campus Map" button pressed
    @FXML
    private void mapPress(MouseEvent me) {
        //change appearance of button
        btn_map_home.setTextFill(Color.rgb(255, 255, 255));
        btn_map_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }

    //"Campus Map" button released
    @FXML
    private void mapRelease(MouseEvent me) {
        //change appearance of button
        btn_map_home.setTextFill(Color.rgb(151, 37, 43));
        btn_map_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Map
        Main.goto_scn_Map();
    }

    //"Log In" button pressed
    @FXML
    private void pinPress(MouseEvent me) {
        //change appearance of button
        btn_pin_home.setTextFill(Color.rgb(255, 255, 255));
        btn_pin_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }

    //"Log In" button released
    @FXML
    private void pinRelease(MouseEvent me) {
        //change appearance of button
        btn_pin_home.setTextFill(Color.rgb(151, 37, 43));
        btn_pin_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to PIN
        Main.goto_scn_PIN();
    }



    static Timeline checkCardReader = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

        @Override
        //handle card swipe
        public void handle(ActionEvent event) {
            //check periodically for info in file
            System.out.println("this is called every second on UI thread");
            //file has info
            if ( CardReader.hasID() ) {
                //save number in static variable to be used in Meal_Controller
                try {
                    studentid = CardReader.getLastID();
                } catch (IOException e) {
                    System.out.println("IO Exception 1");
                }
                //check for valid number
                if ( studentid.length() == 7 ) {
                    System.out.format("studentid is (%s)", studentid);
                    //reset scene to Meal
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Meal.fxml"));
                    try {
                        Parent root = loader.load();
                        Meal_Controller controller = loader.getController();
                        //returns true if valid student id number
                        if (controller.ValidId()) {
                            //set person-specific values
                            controller.setLabelTexts();
                            //change scene
                            Main.scn_Home.setRoot(root);
                        }
                    } catch (IOException e) {
                        System.out.println("IO Exception 2");
                    }
                }

            }

        }
    }));

}
