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
    //this class is the welcome screen of the kiosk
    //initialize buttons on home screen
    @FXML
    private Button btn_home_map, btn_home_plan, btn_home_about;
    static String studentid;

    //exits program, hide when finished
//    @FXML
//    private void exitPress(ActionEvent event) {System.exit(0);}

    //"About the Project" button pressed
    @FXML
    private void aboutPress(MouseEvent me) {
        //change appearance of button
        btn_home_about.setTextFill(Color.rgb(255, 255, 255));
        btn_home_about.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"About the Project" button released
    @FXML
    private void aboutRelease(MouseEvent me) {
        //change appearance of button
        btn_home_about.setTextFill(Color.rgb(151, 37, 43));
        btn_home_about.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to About Us
        Main.goto_scn_About();
    }

    //"Meal Plan Information" button pressed
    @FXML
    private void planPress(MouseEvent me) {
        //change appearance of button
        btn_home_plan.setTextFill(Color.rgb(255, 255, 255));
        btn_home_plan.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Meal Plan Information" button released
    @FXML
    private void planRelease(MouseEvent me) {
        //change appearance of button
        btn_home_plan.setTextFill(Color.rgb(151, 37, 43));
        btn_home_plan.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Meal Plans
        Main.goto_scn_Plan();
    }

    //"Campus Map" button pressed
    @FXML
    private void mapPress(MouseEvent me) {
        //change appearance of button
        btn_home_map.setTextFill(Color.rgb(255, 255, 255));
        btn_home_map.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Campus Map" button released
    @FXML
    private void mapRelease(MouseEvent me) {
        //change appearance of button
        btn_home_map.setTextFill(Color.rgb(151, 37, 43));
        btn_home_map.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Map
        Main.goto_scn_Map();
    }

    //uncomment to use PIN screen
//    //"Log In" button pressed
//    @FXML
//    private void pinPress(MouseEvent me) {
//        //change appearance of button
//        btn_home_pin.setTextFill(Color.rgb(255, 255, 255));
//        btn_home_pin.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
//    }
//
//    //"Log In" button released
//    @FXML
//    private void pinRelease(MouseEvent me) {
//        //change appearance of button
//        btn_home_pin.setTextFill(Color.rgb(151, 37, 43));
//        btn_home_pin.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
//        //change scene to PIN
//        Main.goto_scn_PIN();
//    }



    static Timeline checkCardReader = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

        @Override
        //handle card swipe
        public void handle(ActionEvent event) {
            //check periodically for info in file
            //System.out.println("this is called every second on UI thread");
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
                        //sets person-specific values
                        if (controller.setLabelTexts()) {
                            //set person-specific values
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
