package CIC;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bb36 on 2/20/2017.
 */
public class Lost_Controller implements Initializable {
    //initialize buttons on Lost screen
    @FXML
    private Button btn_home_Lost, btn_report;
    @FXML
    Label text_inst1, text_inst2;

    //"Home" button pressed
    @FXML
    private void homePress(MouseEvent me) {
        //change appearance of button
        btn_home_Lost.setTextFill(Color.rgb(255,255,255));
        btn_home_Lost.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Home" button released
    @FXML
    private void homeRelease(MouseEvent me) {
        //change appearance of button
        btn_home_Lost.setTextFill(Color.rgb(151,37,43));
        btn_home_Lost.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Home
        Main.goto_scn_home();
    }

    //"Report Lost ID" button pressed
    @FXML
    private void reportPress(MouseEvent me){
        //change appearance of button
        btn_report.setTextFill(Color.rgb(255,255,255));
        btn_report.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Report Lost ID" button released
    @FXML
    private void reportRelease(MouseEvent me) {
        //reset appearance of button
        btn_report.setTextFill(Color.rgb(151,37,43));
        btn_report.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //send email to ID owner
        //display instructions 2
        text_inst2.setText("An email has been sent to the owner of the ID card. Please give the card to an employee in Johnny's for safekeeping.");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set instructions
        text_inst1.setText("If you have found a Student ID card, please swipe the card and press 'Report Lost ID'. An email will be sent to the owner of the ID card." +
                " If you have received an email about a lost Student ID card, please see a Johnny's employee or Campus Safety to have it returned to you.");
        text_inst2.setText("");
    }

}
