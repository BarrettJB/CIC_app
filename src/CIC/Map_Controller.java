package CIC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bb36 on 2/13/2017.
 */
public class Map_Controller implements Initializable{
    @FXML
    private Button btn_home_Map, btn_map_academic, btn_map_residence, btn_map_apartments, btn_map_athletics,btn_map_full;
    @FXML
    private Slider scaler;
    @FXML
    private ScrollPane Scroller;
    @FXML
    private ImageView mapImage;
    @FXML
    private Image test;
    String mymap;
    String scale;

    //"Home" button pressed
    @FXML
    private void homePress(MouseEvent me) {
        //change appearance of button
        btn_home_Map.setTextFill(Color.rgb(255,255,255));
        btn_home_Map.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Home" button released
    @FXML
    private void homeRelease(MouseEvent me) {
        //change appearance of button
        btn_home_Map.setTextFill(Color.rgb(151,37,43));
        btn_home_Map.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        //change scene to Home
        Main.goto_scn_home();
    }

    //Map buttons pressed
    @FXML
    private void mapbtnPress(MouseEvent me) {
        //get button
        Button src = (Button) me.getSource();
        //change appearance of button
        src.setTextFill(Color.rgb(255,255,255));
        src.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 4px;");
    }
    //Map buttons released
    @FXML
    public void mapbtnRelease(MouseEvent me) {
        //get button
        Button src = (Button) me.getSource();
        //change appearance of button
        src.setTextFill(Color.rgb(151,37,43));
        src.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 4px;");
        //store and display PIN
        mymap = src.getText();
        if (mymap.equals("Academic Buildings")) {
            //change image
            test = new Image(getClass().getResource("images/CalvinMapAcademic.jpg").toString());
            //change position
        } else if (mymap.equals("Residence Halls")) {
            //change image
            test = new Image(getClass().getResource("images/CalvinMapResidence.jpg").toString());
            //change position
        } else if (mymap.equals("KE Apartments")) {
            //change image
            test = new Image(getClass().getResource("images/CalvinMapKE.jpg").toString());
            //change position
        } else if (mymap.equals("Athletics")) {
            //change image
            test = new Image(getClass().getResource("images/CalvinMapAthletics.jpg").toString());
            //change position
        } else {
            //full image
            test = new Image(getClass().getResource("images/CalvinMapFull.jpg").toString());            //full position
        }
        mapImage.setImage(test);
    }

    @FXML
    private void changeScale(MouseEvent me) {
        scale = Double.toString(scaler.getValue());
        mapImage.setStyle("-fx-scale-x: "+scale+"; -fx-scale-y: "+scale+"; -fx-scale-z: "+scale+";");
        Scroller.setHmax(scaler.getValue());
        Scroller.setVmax(scaler.getValue());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        test = new Image(getClass().getResource("images/CalvinMapFull.jpg").toString());
        mapImage.setImage(test);
    }

}
