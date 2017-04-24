package CIC;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javax.swing.*;
import java.util.Random;

import static java.awt.SystemColor.text;

/**
 *
 * @author ljs34
 */
public class PIN_Controller implements Initializable {
    //this screen is not used once card reader is implemented

    public String pin_answer;  //stores the user's PIN
    public String pin_entered;
    public static String pin_saved = "";
    private final int MAX_PIN = 10000;
    @FXML
    private Label text_output;
    @FXML
    private Label instructions;
    private Random rand;
    public static Hashtable students;

    //initialize button ids
    //@FXML private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    @FXML private Button btn_home_PIN, btn_enter, btn_clear;

    //PIN buttons pressed
    @FXML
    private void pinPress(MouseEvent me) {
        //get button
        Button src = (Button) me.getSource();
        //change appearance of button
        src.setTextFill(Color.rgb(255,255,255));
        src.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 4px;");
    }
    //PIN buttons released
    @FXML
    public void pinRelease(MouseEvent mouseEvent) {
        //get button
        Button src = (Button) mouseEvent.getSource();
        //change appearance of button
        src.setTextFill(Color.rgb(151,37,43));
        src.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 4px;");
        //store and display PIN
        pin_entered += src.getText();
        text_output.setText(pin_entered);
    }

    //"Clear" button pressed
    @FXML
    private void clearPress(MouseEvent me) {
        System.out.println("Clearing the entered PIN");
        //change appearance of button
        btn_clear.setTextFill(Color.rgb(255,255,255));
        btn_clear.setStyle("-fx-background-color: #71b1c8; -fx-border-color: #71b1c8; -fx-border-width: 4px");
    }
    //"Clear" button released
    @FXML
    private void clearRelease(MouseEvent me) {
        //clear stored pin
        pin_entered = "";
        //reset text display
        text_output.setText("PIN Cleared");
        instructions.setText("Enter your PIN");
        //change appearance of button
        btn_clear.setTextFill(Color.rgb(113,177,200));
        btn_clear.setStyle("-fx-background-color: #ffffff; -fx-border-color: #71b1c8; -fx-border-width: 4px");

    }

    //can probably delete now?
//    @FXML
//    private void generatePIN(ActionEvent event) {
//        System.out.println("Randomly generating a new PIN");
//        pin_answer = Integer.toString(rand.nextInt(MAX_PIN));
//        while (pin_answer.length() < 4){
//            pin_answer = "0" + pin_answer;
//        }
//        instructions.setText("Enter PIN: " + pin_answer);
//        System.out.println("New PIN: " + pin_answer);
//        pin_entered = "";           //Clears entered pin to prevent confusion
//        text_output.setText("");
//    }

    //"Enter" button pressed
    @FXML
    private void checkPress(MouseEvent me) {
        //change appearance of button
        btn_enter.setTextFill(Color.rgb(255,255,255));
        btn_enter.setStyle("-fx-background-color: #71b1c8; -fx-border-color: #71b1c8; -fx-border-width: 4px");
    }
    //"Enter" button released
    @FXML
    private void checkRelease(MouseEvent me) throws IOException {
        System.out.format("Checking the entered PIN (%s) against the master (%s)\n", pin_entered, pin_answer);
        //Reset appearance of "Enter" button
        btn_enter.setTextFill(Color.rgb(113,177,200));
        btn_enter.setStyle("-fx-background-color: #ffffff; -fx-border-color: #71b1c8; -fx-border-width: 4px");
        //check that PIN is valid
        if(true) {
        //if (students.containsKey(pin_entered)){
            // PIN is good
            //reset instruction text
            text_output.setText("Correct PIN");
            instructions.setText("Enter your PIN");

            //pin_saved = pin_entered;
            CardReader.init();
            pin_saved = CardReader.getLastID();
            System.out.format("pin_entered is (%s)", pin_saved);
            //reset scene to Meal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Meal.fxml"));
            Parent root = loader.load();
            Meal_Controller controller = loader.getController();
            //set person-specific values
            controller.setLabelTexts();
            btn_enter.getScene().setRoot(root);
        }
        else {
            // PIN rejeceted
            //reset instruction text
            text_output.setText("Incorrect PIN");
            instructions.setText("Enter your PIN");
        }
        //clear PIN
        pin_entered = "";
    }

    //"Home" button pressed
    @FXML
    private void homePress(MouseEvent me) {
        System.out.println("Clearing the entered PIN");
        //change appearance of button
        btn_home_PIN.setTextFill(Color.rgb(255,255,255));
        btn_home_PIN.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Home" button released
    @FXML
    private void homeRelease(MouseEvent me) {
        //clear stored PIN
        pin_entered = "";
        //reset text display
        text_output.setText("");
        instructions.setText("Enter your PIN");
        //change appearance of button
        btn_home_PIN.setTextFill(Color.rgb(151,37,43));
        btn_home_PIN.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Home
        Main.goto_scn_home();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Initializing the system");
        //rand = new Random();
        pin_answer = "invalid";
        pin_entered = "";
        text_output.setText("");
        instructions.setText("Enter your PIN");
        //replace with info from server
//        students = new Hashtable();
//        students.put("1234","Emily Floch, 13, 21, $75.00");
//        students.put("5678","Barrett Bryson, 20, 0, $5.00");
//        students.put("2468","Landon Sterk, 5, 60, $0.00");

    }


}