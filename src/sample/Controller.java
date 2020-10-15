package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    @FXML
    public Button advisorybtn;
    public Button refreshBtnM;
    Desktop d=Desktop.getDesktop();

    @FXML
    private ResourceBundle resources;


    @FXML
    void whobtn(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI("https://www.who.int"));
    }
    @FXML
    void indbtn(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI("https://www.mygov.in/covid-19"));
    }
    @FXML
    public void advisoryListener(ActionEvent event){
        Stage stage= (Stage) advisorybtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("advisory.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));
    }
    @FXML
    public void refreshListener(ActionEvent actionEvent){
        System.out.println("refreshing data");
        Stage stage= (Stage) refreshBtnM.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML
    void initialize() {

    }


}
