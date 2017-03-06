package CIC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bb36 on 2/13/2017.
 */
public class Map_Controller{
    @FXML
    private Button btn_home_Map;
    @FXML
    private TabPane tabEdit;

    @FXML
    private void homePress(MouseEvent me) {
        btn_home_Map.setTextFill(Color.rgb(255,255,255));
        btn_home_Map.setStyle("-fx-background-color: #97252b; -fx-border-color: #97252b; -fx-border-width: 6px;");
    }
    @FXML
    private void homeRelease(MouseEvent me) {
        btn_home_Map.setTextFill(Color.rgb(151,37,43));
        btn_home_Map.setStyle("-fx-background-color: #ffffff; -fx-border-color: #97252b; -fx-border-width: 6px;");
        Main.goto_scn_home();
    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        tabEdit.lookup(".tab-pane:top>*.tab-header-area").setStyle("-fx-padding: 0.416667em 5px 0em 0.416667em;");
//    }
}
