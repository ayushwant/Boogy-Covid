package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class DateWise implements Initializable {



    @FXML
    private TableView<DateWise.stateData> tbl;
    @FXML
    private TableColumn<DateWise.stateData,String> stateName_col;
    @FXML
    private TableColumn<DateWise.stateData, Integer> confirmed_col;
    @FXML
    private TableColumn<DateWise.stateData,Integer> active_col;
    @FXML
    private TableColumn<DateWise.stateData,Integer> recovered_col;
    @FXML
    private TableColumn<DateWise.stateData,Integer> deaths_col;

    @FXML private ObservableList statesList = FXCollections.observableArrayList();
    @FXML private FilteredList filter=new FilteredList(statesList, e->true);

    @FXML private Button backBtn;
    @FXML private void backListener(ActionEvent event){
        Stage stage= (Stage) backBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private Button resetBtn;
    @FXML private void resetListener(ActionEvent event){
        Stage stage= (Stage) resetBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/dateWise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @FXML private DatePicker datePicker;
    @FXML private LocalDate date;
    @FXML private void dateListener(ActionEvent event) {;
        date= datePicker.getValue();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder().create();
                int confirmed=0,active=0,death=0,recovered=0;

                String[] statename=new String[36];
                int[] confirmcase=new int[36];
                int[] activecase=new int[36];
                int[] recovercases=new int[36];
                int[] deathcase=new int[36];

                String dateshow=null;
                try {
                    BufferedReader br = new BufferedReader(new FileReader("indiaHistoryJSON.json"));
                    indiaHistory response = gson.fromJson(br, indiaHistory.class);
                    indiaHistory.datewiseHistory[] allDatesData = response.data;

                    for(indiaHistory.datewiseHistory  eachDateData : allDatesData){
                        if(eachDateData.day.equals(""+date))
                        {
                            dateshow=eachDateData.day;

                            indiaHistory.datewiseHistory.indiaThisDay indiaEachDate = eachDateData.summary;
                            confirmed=indiaEachDate.total;

                            active=indiaEachDate.getIndiaActive();

                            recovered=indiaEachDate.discharged;

                            death=indiaEachDate.deaths;

                            indiaHistory.datewiseHistory.statesThisDay[] allStatesEachDate = eachDateData.regional;
                            int i=0;
                            for( indiaHistory.datewiseHistory.statesThisDay state : allStatesEachDate )
                            {
                                statename[i]=state.loc;
                                confirmcase[i]= state.totalConfirmed;
                                activecase[i]=state.getActive();
                                recovercases[i]=state.discharged;
                                deathcase[i]=state.deaths;
                                i++;
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String finalDateshow = dateshow;
                int finalConfirmed = confirmed;
                int finalActive = active;
                int finalRecovered = recovered;
                int finalDeath = death;

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        dateLbl.setText("Date :- "+date);
                        comfirmLbl.setText(""+ finalConfirmed);
                        activeLbl.setText(""+ finalActive);
                        recoverLbl.setText(""+ finalRecovered);
                        deathLbl.setText(""+ finalDeath);

                        tbl.getItems().clear();
                        int i=0;
                        for(String states : statename)
                        {
                            if(statename[i]!=null) {
                                statesList.add(new DateWise.stateData(statename[i],
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
                });
            }

        }).start();
    }

    @FXML private Label comfirmLbl;
    @FXML private Label activeLbl;
    @FXML private Label recoverLbl;
    @FXML private Label deathLbl;
    @FXML private Label dateLbl;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder().create();
                int confirmed=0,active=0,death=0,recovered=0;
                String dateshow=null;

                String[] statename=new String[36];
                int[] confirmcase=new int[36];
                int[] activecase=new int[36];
                int[] recovercases=new int[36];
                int[] deathcase=new int[36];

                Calendar calendar=Calendar.getInstance();
                String date=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
                try {
                    BufferedReader br = new BufferedReader(new FileReader("indiaHistoryJSON.json"));
                    indiaHistory response = gson.fromJson(br, indiaHistory.class);
                    indiaHistory.datewiseHistory[] allDatesData = response.data;

                    for(indiaHistory.datewiseHistory  eachDateData : allDatesData){
                        if(eachDateData.day.equals(date))
                        {
                            dateshow=eachDateData.day;

                            indiaHistory.datewiseHistory.indiaThisDay indiaEachDate = eachDateData.summary;
                            confirmed=indiaEachDate.total;

                            active=indiaEachDate.getIndiaActive();

                            recovered=indiaEachDate.discharged;

                            death=indiaEachDate.deaths;

                            indiaHistory.datewiseHistory.statesThisDay[] allStatesEachDate = eachDateData.regional;
                            int i=0;
                            for( indiaHistory.datewiseHistory.statesThisDay state : allStatesEachDate )
                            {
                                statename[i]=state.loc;
                                confirmcase[i]= state.totalConfirmed;
                                activecase[i]=state.getActive();
                                recovercases[i]=state.discharged;
                                deathcase[i]=state.deaths;
                                i++;
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String finalDateshow = dateshow;
                int finalConfirmed = confirmed;
                int finalActive = active;
                int finalRecovered = recovered;
                int finalDeath = death;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        dateLbl.setText("Date :- "+finalDateshow);
                        comfirmLbl.setText(""+ finalConfirmed);
                        activeLbl.setText(""+ finalActive);
                        recoverLbl.setText(""+ finalRecovered);
                        deathLbl.setText(""+ finalDeath);

                        int i=0;
                        for(String states : statename)
                        {
                            if(statename[i]!=null) {
                                statesList.add(new DateWise.stateData(statename[i],
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
                });
            }
        }).start();
    }

    @FXML private TextField searchBox;
    @FXML
    private void searchListener(KeyEvent event){

        searchBox.textProperty().addListener((observable,oldValue,newValue)->{

            filter.setPredicate((Predicate<? super DateWise.stateData>) (DateWise.stateData std)->{

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
