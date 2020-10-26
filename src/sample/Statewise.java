package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Statewise implements Initializable {
    @FXML
    private Button backBtnS;
    public Button refreshBtnS;
    String statename[]=new String[36];
    int confirmcase[]=new int[36];
    int activecase[]=new int[36];
    int recovercases[]=new int[36];
    int deathcase[]=new int[36];
    String x;

    @FXML
    private TableView<stateData> tbl;
    @FXML
    private TableColumn<stateData,String> stateName_col;
    @FXML
    private TableColumn<stateData, Integer> confirmed_col;
    @FXML
    private TableColumn<stateData,Integer> active_col;
    @FXML
    private TableColumn<stateData,Integer> recovered_col;
    @FXML
    private TableColumn<stateData,Integer> deaths_col;

    @FXML
    private void backListenerS(ActionEvent event){
        Stage stage= (Stage) backBtnS.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }
    public void refeshListenerS(ActionEvent event){
        System.out.println("refreshing data");
        Stage stage= (Stage) refreshBtnS.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("statewise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
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
                    //timestamp=response.getLastRefreshed();
                    indiaLatest.latestData.stateWise[] states=response.data.regional;
                    int i=0;
                    for(indiaLatest.latestData.stateWise state: states){
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

                ObservableList list= FXCollections.observableArrayList(
                        new stateData(statename[0],confirmcase[0],activecase[0],recovercases[0],deathcase[0]),
                        new stateData(statename[1],confirmcase[1],activecase[1],recovercases[1],deathcase[1]),
                        new stateData(statename[2],confirmcase[2],activecase[2],recovercases[2],deathcase[2]),
                        new stateData(statename[3],confirmcase[3],activecase[3],recovercases[3],deathcase[3]),
                        new stateData(statename[4],confirmcase[4],activecase[4],recovercases[4],deathcase[4]),
                        new stateData(statename[5],confirmcase[5],activecase[5],recovercases[5],deathcase[5]),
                        new stateData(statename[6],confirmcase[6],activecase[6],recovercases[6],deathcase[6]),
                        new stateData(statename[7],confirmcase[7],activecase[7],recovercases[7],deathcase[7]),
                        new stateData(statename[8],confirmcase[8],activecase[8],recovercases[8],deathcase[8]),
                        new stateData(statename[9],confirmcase[9],activecase[9],recovercases[9],deathcase[9]),
                        new stateData(statename[10],confirmcase[10],activecase[10],recovercases[10],deathcase[10]),
                        new stateData(statename[11],confirmcase[11],activecase[11],recovercases[11],deathcase[11]),
                        new stateData(statename[12],confirmcase[12],activecase[12],recovercases[12],deathcase[12]),
                        new stateData(statename[13],confirmcase[13],activecase[13],recovercases[13],deathcase[13]),
                        new stateData(statename[14],confirmcase[14],activecase[14],recovercases[14],deathcase[14]),
                        new stateData(statename[15],confirmcase[15],activecase[15],recovercases[15],deathcase[15]),
                        new stateData(statename[16],confirmcase[16],activecase[16],recovercases[16],deathcase[16]),
                        new stateData(statename[17],confirmcase[17],activecase[17],recovercases[17],deathcase[17]),
                        new stateData(statename[18],confirmcase[18],activecase[18],recovercases[18],deathcase[18]),
                        new stateData(statename[19],confirmcase[19],activecase[19],recovercases[19],deathcase[19]),
                        new stateData(statename[20],confirmcase[20],activecase[20],recovercases[20],deathcase[20]),
                        new stateData(statename[21],confirmcase[21],activecase[21],recovercases[21],deathcase[21]),
                        new stateData(statename[22],confirmcase[22],activecase[22],recovercases[22],deathcase[22]),
                        new stateData(statename[23],confirmcase[23],activecase[23],recovercases[23],deathcase[23]),
                        new stateData(statename[24],confirmcase[24],activecase[24],recovercases[24],deathcase[24]),
                        new stateData(statename[25],confirmcase[25],activecase[25],recovercases[25],deathcase[25]),
                        new stateData(statename[26],confirmcase[26],activecase[26],recovercases[26],deathcase[26]),
                        new stateData(statename[27],confirmcase[27],activecase[27],recovercases[27],deathcase[27]),
                        new stateData(statename[28],confirmcase[28],activecase[28],recovercases[28],deathcase[28]),
                        new stateData(statename[29],confirmcase[29],activecase[29],recovercases[29],deathcase[29]),
                        new stateData(statename[30],confirmcase[30],activecase[30],recovercases[30],deathcase[30]),
                        new stateData(statename[31],confirmcase[31],activecase[31],recovercases[31],deathcase[31]),
                        new stateData(statename[32],confirmcase[32],activecase[32],recovercases[32],deathcase[32]),
                        new stateData(statename[33],confirmcase[33],activecase[33],recovercases[33],deathcase[33]),
                        new stateData(statename[34],confirmcase[34],activecase[34],recovercases[34],deathcase[34]),
                        new stateData(statename[35],confirmcase[35],activecase[35],recovercases[35],deathcase[35])
                );
                stateName_col.setCellValueFactory(new PropertyValueFactory<>("stateName"));
                confirmed_col.setCellValueFactory(new PropertyValueFactory<>("confirmed"));
                active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
                recovered_col.setCellValueFactory(new PropertyValueFactory<>("recovered"));
                deaths_col.setCellValueFactory(new PropertyValueFactory<>("deaths"));

                tbl.setItems(list);
            }
        }).start();
    }

    public  class stateData{
        SimpleStringProperty stateName;
        SimpleIntegerProperty confirmed;
        SimpleIntegerProperty active;
        SimpleIntegerProperty recovered;
        SimpleIntegerProperty deaths;

        public stateData(String stateName, int confirmed, int active, int recovered, int deaths){
            this.stateName=new SimpleStringProperty(stateName);
            this.confirmed=new SimpleIntegerProperty(confirmed);
            this.active=new SimpleIntegerProperty(active);
            this.recovered=new SimpleIntegerProperty(recovered);
            this.deaths=new SimpleIntegerProperty(deaths);
        }

        public String getStateName() {
            return stateName.get();
        }

        public int getConfirmed() {
            return confirmed.get();
        }

        public int getActive() {
            return active.get();
        }

        public int getRecovered() {
            return recovered.get();
        }

        public int getDeaths() {
            return deaths.get();
        }
    }
}
