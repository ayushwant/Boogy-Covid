package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TRACK A COV");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fetchIndiaLatest.main(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                fetchNews.main(null);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    fetchIndiaLatest indiaData = new fetchIndiaLatest();
                    indiaData.main(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
