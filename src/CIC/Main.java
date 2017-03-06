package CIC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage stg_Main;
    static Scene scn_PIN, scn_Home, scn_Meal, scn_Map, scn_Lost;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg_Main = primaryStage;
        Parent par_PIN = FXMLLoader.load(getClass().getResource("PIN.fxml"));
        scn_PIN = new Scene(par_PIN, 1024, 768);
        Parent par_Home = FXMLLoader.load(getClass().getResource("Home.fxml"));
        scn_Home = new Scene(par_Home, 1024, 768);
        Parent par_Meal = FXMLLoader.load(getClass().getResource("Meal.fxml"));
        scn_Meal = new Scene(par_Meal, 1024, 768);
        Parent par_Map = FXMLLoader.load(getClass().getResource("Map.fxml"));
        scn_Map = new Scene(par_Map, 1024,768);
        Parent par_Lost = FXMLLoader.load(getClass().getResource("Lost.fxml"));
        scn_Lost = new Scene(par_Lost, 1024, 768);
        stg_Main.setTitle("CIC Application");
        stg_Main.setScene(scn_Home);
        stg_Main.show();
    }

    public static void goto_scn_home() {
        stg_Main.setScene(scn_Home);
    }
    public static void goto_scn_PIN() { stg_Main.setScene(scn_PIN); }
    public static void goto_scn_Meal() { stg_Main.setScene(scn_Meal); }
    public static void goto_scn_Map() { stg_Main.setScene(scn_Map); }
    public static void goto_scn_Lost() { stg_Main.setScene(scn_Lost); }


    public static void main(String[] args) {
        launch(args);
    }
}
