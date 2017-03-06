package CIC;

import javafx.scene.input.MouseEvent;
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

    @FXML
    private void pinPress(MouseEvent me) {
        Button src = (Button) me.getSource();
        src.setTextFill(Color.rgb(255,255,255));
        src.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 4px;");
    }
    @FXML
    public void pinRelease(MouseEvent mouseEvent) {
        Button src = (Button) mouseEvent.getSource();
        src.setTextFill(Color.rgb(151,37,43));
        src.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 4px;");
        pin_entered += src.getText();
        text_output.setText(pin_entered);
    }

    @FXML
    private void clearPress(MouseEvent me) {
        System.out.println("Clearing the entered PIN");
        btn_clear.setTextFill(Color.rgb(255,255,255));
        btn_clear.setStyle("-fx-background-color: #71b1c8; -fx-border-color: #71b1c8; -fx-border-width: 4px");
    }
    @FXML
    private void clearRelease(MouseEvent me) {
        pin_entered = "";
        text_output.setText("");
        instructions.setText("Click \"New PIN\"");
        btn_clear.setTextFill(Color.rgb(113,177,200));
        btn_clear.setStyle("-fx-background-color: #ffffff; -fx-border-color: #71b1c8; -fx-border-width: 4px");

    }

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

    @FXML
    private void checkPress(MouseEvent me) {
        btn_enter.setTextFill(Color.rgb(255,255,255));
        btn_enter.setStyle("-fx-background-color: #71b1c8; -fx-border-color: #71b1c8; -fx-border-width: 4px");
    }
    @FXML
    private void checkRelease(MouseEvent me) {
        System.out.format("Checking the entered PIN (%s) against the master (%s)\n", pin_entered, pin_answer);
        btn_enter.setTextFill(Color.rgb(113,177,200));
        btn_enter.setStyle("-fx-background-color: #ffffff; -fx-border-color: #71b1c8; -fx-border-width: 4px");
        if (students.containsKey(pin_entered)){
            // PIN is good
            text_output.setText("Click \"New PIN\" to begin!");
            instructions.setText("Click \"New PIN\"");
            pin_saved = pin_entered;
            System.out.format("pin_entered is (%s)", pin_saved);
            Main.goto_scn_Meal();
        }
        else {
            // PIN rejeceted
            text_output.setText("Incorrect PIN");
            //instructions.setText("Try again, or generate a new PIN");
        }
        pin_entered = "";
    }

    @FXML
    private void homePress(MouseEvent me) {
        System.out.println("Clearing the entered PIN");
        btn_home_PIN.setTextFill(Color.rgb(255,255,255));
        btn_home_PIN.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    @FXML
    private void homeRelease(MouseEvent me) {
        pin_entered = "";
        text_output.setText("");
        instructions.setText("Click \"New PIN\"");
        btn_home_PIN.setTextFill(Color.rgb(151,37,43));
        btn_home_PIN.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_home();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Initializing the system");
        rand = new Random();
        pin_answer = "invalid";
        pin_entered = "";
        text_output.setText("Click \"New PIN\" to begin!");
        students = new Hashtable();
        students.put("1234","Emily Floch");

    }


}