package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.covid_data.india_latest.fetchIndiaLatest;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TRACK A COV");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
<<<<<<< HEAD
        fetchIndiaLatest ref = new fetchIndiaLatest();
        ref.main(null);
=======

        new fetchIndiaLatest().main(null);

>>>>>>> 45d8729338b071d80a8380a81b353b489117f494
    }



    public static void main(String[] args) {
        launch(args);
    }
}
