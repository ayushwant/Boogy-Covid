package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.fetchClasses.fetchIndiaHistory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        new Thread(new Runnable() {
            @Override
            public void run() {
                fetchIndiaHistory.main(null);
            }
        }).start();

        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/sample.fxml"));
        primaryStage.setTitle("TRACK A COV");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
