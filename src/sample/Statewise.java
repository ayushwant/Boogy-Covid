package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.fetchClasses.fetchIndiaLatest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Statewise implements Initializable {
    @FXML private String statename[]=new String[36];
    @FXML private int confirmcase[]=new int[36];
    @FXML private int activecase[]=new int[36];
    @FXML private int recovercases[]=new int[36];
    @FXML private int deathcase[]=new int[36];
    @FXML private Button confirmCaseGraphBtn;
    @FXML private Button activeCaseGraphBtn;
    @FXML private Button recoverCaseGraphBtn;
    @FXML private Button deathCaseGraphBtn;

    @FXML
    private void confirmGraphListener(ActionEvent event){
        Stage stage= (Stage) confirmCaseGraphBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/confirmGraph.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML
    private void activeGraphListener(ActionEvent event){
        Stage stage= (Stage) activeCaseGraphBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/activeGraph.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML
    private void recoverGraphListener(ActionEvent event){
        Stage stage= (Stage) recoverCaseGraphBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/recoverGraph.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML
    private void deathGraphListener(ActionEvent event){
        Stage stage= (Stage) deathCaseGraphBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/deathGraph.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private Button lineChartBtn;
    @FXML
    private void lineChartListener(ActionEvent event){
        Stage stage= (Stage) lineChartBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/allComparisionChart.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

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

    @FXML private Button backBtnS;
    @FXML
    private void backListenerS(ActionEvent event){
        Stage stage= (Stage) backBtnS.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private Button refreshBtnS;
    @FXML private void refeshListenerS(ActionEvent event){
        System.out.println("refreshing data");
        Stage stage= (Stage) refreshBtnS.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/statewise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private ObservableList statesList = FXCollections.observableArrayList();
    @FXML private FilteredList filter=new FilteredList(statesList,e->true);

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
                try {
                    BufferedReader br = new BufferedReader(new FileReader("indiaLatestJSON.json"));
                    indiaLatest response = gson.fromJson(br, indiaLatest.class);
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

                int i=0;
                for(String states : statename)
                {
                    if(statename[i]!=null) {
                        statesList.add(new stateData(statename[i],
                                confirmcase[i], activecase[i], recovercases[i], deathcase[i]));
                    }
                    i++;
                }

                stateName_col.setCellValueFactory(new PropertyValueFactory<>("stateName"));
                confirmed_col.setCellValueFactory(new PropertyValueFactory<>("confirmed"));
                active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
                recovered_col.setCellValueFactory(new PropertyValueFactory<>("recovered"));
                deaths_col.setCellValueFactory(new PropertyValueFactory<>("deaths"));

                tbl.setItems(statesList);
            }
        }).start();
    }

    @FXML private TextField searchBox;
    @FXML
    private void searchListener(KeyEvent event){

        searchBox.textProperty().addListener((observable,oldValue,newValue)->{

            filter.setPredicate((Predicate<? super stateData>) (stateData std)->{

                if(newValue.isEmpty() || newValue==null){
                    return true;
                }
                else if(std.getStateName().toLowerCase().contains(newValue.toLowerCase())){
                    return  true;
                }

                return false;
            });
        });

        SortedList sort=new SortedList(filter);
        sort.comparatorProperty().bind(tbl.comparatorProperty());
        tbl.setItems(sort);
    }

    public static class stateData{
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
