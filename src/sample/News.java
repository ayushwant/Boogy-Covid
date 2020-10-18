package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class News {
    @FXML
    public Button refreshBtnN;
    public Button backBtnN;

    @FXML
    void refreshListenerN(ActionEvent event){
        System.out.println("refreshing news");
        Stage stage= (Stage) refreshBtnN.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("news.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,700));
    }

    @FXML
    void backListenerN(ActionEvent event){
        Stage stage= (Stage) backBtnN.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

}
