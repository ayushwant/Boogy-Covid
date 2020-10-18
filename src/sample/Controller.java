package sample;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {
    @FXML
    public Button advisorybtn;
    public Button refreshBtnM;
    public Button stateBtn;
    public Label comfirmL;
    public Label activeL;
    public Label recoverL;
    public Label deathL;
    public Label timestampL;
    public Button click;
    public Button newsbtn;
    public Button symanabtn;


    Desktop d=Desktop.getDesktop();
    public void clickListener(ActionEvent e){
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
                    timestamp=response.lastRefreshed;
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
                            comfirmL.setText(String.valueOf(finalC));
                            activeL.setText(String.valueOf(finalA));
                            recoverL.setText(String.valueOf(finalR));
                            deathL.setText(String.valueOf(finalD));
                            timestampL.setText(finalT);
                        }
                    });

                }

        }).start();
    }

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
    void advisoryListener(ActionEvent event){
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
        Stage stage= (Stage) newsbtn.getScene().getWindow();
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
        Stage stage= (Stage) symanabtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("symanalyzer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 700, 700));
    }

}
