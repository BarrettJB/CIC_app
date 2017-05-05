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
    //this class displays an interactive map of campus
    @FXML
    private Button btn_map_home;
    @FXML
    private Slider zoom;
    @FXML
    private ScrollPane sp;
    @FXML
    private ImageView mapImage;
    @FXML
    private Image display_image;
    String mymap;
    Double scale;

    //"Home" button pressed
    @FXML
    private void homePress(MouseEvent me) {
        //change appearance of button
        btn_map_home.setTextFill(Color.rgb(255,255,255));
        btn_map_home.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    //"Home" button released
    @FXML
    private void homeRelease(MouseEvent me) {
        //change appearance of button
        btn_map_home.setTextFill(Color.rgb(151,37,43));
        btn_map_home.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        display_image = new Image(getClass().getResource("images/CalvinMapFull.jpg").toString());
        mapImage.setImage(display_image);
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
            display_image = new Image(getClass().getResource("images/CalvinMapAcademic.jpg").toString());
            //change position
            zoom.setValue(1.5);
            mapImage.setFitWidth(1000*1.5);
            mapImage.setFitHeight(636*1.5);
            sp.setVvalue(.6);
            sp.setHvalue(.2);
        } else if (mymap.equals("Residence Halls")) {
            //change image
            display_image = new Image(getClass().getResource("images/CalvinMapResidence.jpg").toString());
            //change position
            zoom.setValue(1.5);
            mapImage.setFitWidth(1000*1.5);
            mapImage.setFitHeight(636*1.5);
            sp.setVvalue(.4);
            sp.setHvalue(.2);
        } else if (mymap.equals("KE Apartments")) {
            //change image
            display_image = new Image(getClass().getResource("images/CalvinMapKE.jpg").toString());
            //change position
            zoom.setValue(2);
            mapImage.setFitWidth(1000*2);
            mapImage.setFitHeight(636*2);
            sp.setVvalue(1);
            sp.setHvalue(.4);
        } else if (mymap.equals("Athletics")) {
            //change image
            display_image = new Image(getClass().getResource("images/CalvinMapAthletics.jpg").toString());
            //change position
            zoom.setValue(1.5);
            mapImage.setFitWidth(1000*1.5);
            mapImage.setFitHeight(636*1.5);
            sp.setVvalue(.2);
            sp.setHvalue(.1);
        } else {
            //full image
            display_image = new Image(getClass().getResource("images/CalvinMapFull.jpg").toString());
            //full position
            zoom.setValue(1);
            mapImage.setFitWidth(1000);
            mapImage.setFitHeight(636);
            sp.setVvalue(0);
            sp.setHvalue(0);
        }
        mapImage.setImage(display_image);
    }

    @FXML
    private void changeScale(MouseEvent me) {
        //get scale from slider
        scale = zoom.getValue();
        //zoom in on map image
        mapImage.setFitWidth(1000*scale);
        mapImage.setFitHeight(636*scale);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialize map image
        display_image = new Image(getClass().getResource("images/CalvinMapFull.jpg").toString());
        mapImage.setImage(display_image);
    }

}
