package sample;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    Desktop d=Desktop.getDesktop();
    @FXML
    private void whoListener(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI("https://www.who.int"));
    }
    @FXML
    private void indianGovernmentListener(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI("https://www.mygov.in/covid-19"));
    }

    @FXML private Button advisoryBtn;
    @FXML
    private void advisoryListener(ActionEvent event){
        Stage stage= (Stage) advisoryBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("advisory.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));
    }

    @FXML private Button refreshBtnM;
    @FXML
    private void refreshListener(ActionEvent actionEvent){
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

    @FXML private Button stateBtn;
    @FXML
    private void stateListener(ActionEvent actionEvent){
        Stage stage= (Stage) stateBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private Button newsBtn;
    @FXML
    private void newsListener(ActionEvent actionEvent){

        Stage stage= (Stage) newsBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("news.fxml"));
        } catch (IOException e) {
            System.out.println("no");
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private Button symptomBtn;
    @FXML
    private void symanaListener(ActionEvent event){
        Stage stage= (Stage) symptomBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("symanalyzer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));
    }

    @FXML private Button worldBtn;
    @FXML
    private void worldListener(ActionEvent event){
        Stage stage= (Stage) symptomBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("countrywise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private Label comfirmLbl;
    @FXML private Label activeLbl;
    @FXML private Label recoverLbl;
    @FXML private Label deathLbl;
    @FXML private Label timestampLbl;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            fetchIndiaLatest.main(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder().create();
                int confirmed=0,active=0,death=0,recovered=0;
                String timestamp=null;
                try {
                    BufferedReader br = new BufferedReader(new FileReader("indiaLatestJSON.json"));
                    indiaLatest response = gson.fromJson(br, indiaLatest.class);
                    System.out.println("read file successfully : " + response.success);
                    indiaLatest.latestData.officialSummary indiaT = response.data.summary;
                    confirmed = indiaT.total;
                    active = indiaT.getIndiaActive();
                    death= indiaT.deaths;
                    recovered= indiaT.discharged;
                    timestamp=response.getLastRefreshed();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int finalC=confirmed;
                int finalA=active;
                int finalD=death;
                int finalR=recovered;
                String finalT=timestamp;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        comfirmLbl.setText(String.valueOf(finalC));
                        activeLbl.setText(String.valueOf(finalA));
                        recoverLbl.setText(String.valueOf(finalR));
                        deathLbl.setText(String.valueOf(finalD));
                        timestampLbl.setText("Last updated : "+finalT);
                    }
                });
            }
        }).start();
    }
}
