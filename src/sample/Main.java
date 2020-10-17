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
        fetchIndiaLatest ref = new fetchIndiaLatest();
        ref.main(null);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
