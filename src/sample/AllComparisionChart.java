package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllComparisionChart implements Initializable {

    @FXML
    private Button backBtnL;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private LineChart lineChart;

    @FXML private String statename[]=new String[36];
    @FXML private int confirmcase[]=new int[36];
    @FXML private int activecase[]=new int[36];
    @FXML private int recovercases[]=new int[36];
    @FXML private int deathcase[]=new int[36];

    @FXML
    private void backListenerL(ActionEvent event){
        Stage stage= (Stage) backBtnL.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        XYChart.Series confirmSeries = new XYChart.Series();
        confirmSeries.setName("CONFIRM CASES");

        XYChart.Series activeSeries = new XYChart.Series();
        activeSeries.setName("ACTIVE CASES");

        XYChart.Series recoverSeries = new XYChart.Series();
        recoverSeries.setName("RECOVER CASES");

        XYChart.Series deathSeries = new XYChart.Series();
        deathSeries.setName("DEATH CASES");

        try {
            fetchIndiaLatest.main(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        int confirmed = 0, active = 0, death = 0, recovered = 0;
        String timestamp = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("indiaLatestJSON.json"));
            indiaLatest response = gson.fromJson(br, indiaLatest.class);
            System.out.println("read file successfully : " + response.success);
            indiaLatest.latestData.officialSummary indiaT = response.data.summary;
            //timestamp=response.getLastRefreshed();
            indiaLatest.latestData.stateWise[] states = response.data.regional;
            int i = 0;
            for (indiaLatest.latestData.stateWise state : states) {
                statename[i]=state.loc;
                confirmcase[i]=state.totalConfirmed;
                activecase[i]=state.getActive();
                recovercases[i]=state.discharged;
                deathcase[i]=state.deaths;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 36; i++) {
            activeSeries.getData().add(new XYChart.Data(statename[i], activecase[i]));
        }

        for (int i = 0; i < 36; i++) {
            confirmSeries.getData().add(new XYChart.Data(statename[i], confirmcase[i]));
        }

        for (int i = 0; i < 36; i++) {
            recoverSeries.getData().add(new XYChart.Data(statename[i], recovercases[i]));
        }

        for (int i = 0; i < 36; i++) {
            deathSeries.getData().add(new XYChart.Data(statename[i], deathcase[i]));
        }

        lineChart.getData().addAll(confirmSeries,deathSeries,recoverSeries,activeSeries);
    }
}
