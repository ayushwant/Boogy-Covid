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
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller implements Initializable {
    @FXML
    public Button advisoryBtn;
    public Button refreshBtnM;
    public Button stateBtn;
    public Label comfirmLbl;
    public Label activeLbl;
    public Label recoverLbl;
    public Label deathLbl;
    public Label timestampLbl;
    public Button newsBtn;
    public Button symptomBtn;
    public Button indiaHistoricalButton;
    public Button graphBtn;

    Desktop d=Desktop.getDesktop();

    @FXML
    private ResourceBundle resources;

    @FXML
    void graphListener(ActionEvent event)
    {
        Stage stage = (Stage) graphBtn.getScene().getWindow();
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("BarGraph.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));

    }

    @FXML
    void indiaHistoricalListener(ActionEvent event)
    {
        Stage stage= (Stage) indiaHistoricalButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("indiaHistoricalFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));
    }

    @FXML
    void whoListener(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI("https://www.who.int"));
    }
    @FXML
    void indianGovernmentListener(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI("https://www.mygov.in/covid-19"));
    }
    @FXML
    void advisoryListener(ActionEvent event){
        Stage stage= (Stage) advisoryBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("advisory.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));
    }
    @FXML
    void refreshListener(ActionEvent actionEvent){
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
    void stateListener(ActionEvent actionEvent){
        Stage stage= (Stage) stateBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML
    void newsListener(ActionEvent actionEvent){

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
    @FXML
    public void symanaListener(ActionEvent event){
        Stage stage= (Stage) symptomBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("symanalyzer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));
    }

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
