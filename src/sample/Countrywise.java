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
import sample.fetchClasses.fetchWorldLatest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Countrywise implements Initializable {
    
    @FXML private Button refreshBtn;
    @FXML private void refreshListener(ActionEvent event){
        System.out.println("refreshing data");
        Stage stage= (Stage) refreshBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/countrywise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }
    
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

    @FXML
    private TableView<Countrywise.countryData> tbl;
    @FXML
    private TableColumn<Countrywise.countryData,String> countryName_col;
    @FXML
    private TableColumn<Countrywise.countryData, Integer> confirmed_col;
    @FXML
    private TableColumn<Countrywise.countryData,Integer> active_col;
    @FXML
    private TableColumn<Countrywise.countryData,Integer> recovered_col;
    @FXML
    private TableColumn<Countrywise.countryData,Integer> deaths_col;

    @FXML private ObservableList countryList = FXCollections.observableArrayList();
    @FXML private FilteredList filter=new FilteredList(countryList, e->true);

    @FXML private Label timeStampLbl;
    @FXML private Label confirmLbl;
    @FXML private Label activeLbl;
    @FXML private Label recoverLbl;
    @FXML private Label deathLbl;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fetchWorldLatest.main(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder().create();
                int confirmed = 0, active = 0, death = 0, recovered = 0;
                String timestamp = null;
                String[] countryname = new String[190];
                int[] confirmcase = new int[190];
                int[] activecase = new int[190];
                int[] recovercases = new int[190];
                int[] deathcase = new int[190];
                try {
                    BufferedReader br = new BufferedReader(new FileReader("worldLatestJSON.json"));
                    worldLatest response = gson.fromJson(br, worldLatest.class);
                    timestamp = response.Date;

                    worldLatest.GlobalData worldLatest = response.Global;
                    confirmed = worldLatest.TotalConfirmed;
                    active = worldLatest.getActive();
                    recovered = worldLatest.TotalRecovered;
                    death = worldLatest.TotalDeaths;

                    worldLatest.CountryWiseData[] countries = response.Countries;


                    int i = 0;
                    for (worldLatest.CountryWiseData country : countries) {
                        countryname[i] = country.Country;
                        confirmcase[i] = country.TotalConfirmed;
                        activecase[i] = country.getActive();
                        recovercases[i] = country.TotalRecovered;
                        deathcase[i] = country.TotalDeaths;
                        i++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String finalTimestamp = timestamp;
                int finalConfirmed = confirmed;
                int finalActive = active;
                int finalRecovered = recovered;
                int finalDeath = death;

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        timeStampLbl.setText("Last updated"+ finalTimestamp);
                        confirmLbl.setText(""+ finalConfirmed);
                        activeLbl.setText(""+ finalActive);
                        recoverLbl.setText(""+ finalRecovered);
                        deathLbl.setText(""+ finalDeath);

                        int i=0;
                        for(String countries : countryname)
                        {
                            if(countryname[i]!=null) {
                                countryList.add(new countryData(countryname[i],
                                        confirmcase[i], activecase[i], recovercases[i], deathcase[i]));
                            }
                            i++;
                        }

                        countryName_col.setCellValueFactory(new PropertyValueFactory<>("countryName"));
                        confirmed_col.setCellValueFactory(new PropertyValueFactory<>("confirmed"));
                        active_col.setCellValueFactory(new PropertyValueFactory<>("active"));
                        recovered_col.setCellValueFactory(new PropertyValueFactory<>("recovered"));
                        deaths_col.setCellValueFactory(new PropertyValueFactory<>("deaths"));

                        tbl.setItems(countryList);
                    }
                });

            }
        }).start();
    }

    @FXML private TextField searchBox;
    @FXML
    private void searchListener(KeyEvent event){

        searchBox.textProperty().addListener((observable,oldValue,newValue)->{

            filter.setPredicate((Predicate<? super countryData>) (countryData std)->{

                if(newValue.isEmpty() || newValue==null){
                    return true;
                }
                else if(std.getCountryName().toLowerCase().contains(newValue.toLowerCase())){
                    return  true;
                }

                return false;
            });
        });

        SortedList sort=new SortedList(filter);
        sort.comparatorProperty().bind(tbl.comparatorProperty());
        tbl.setItems(sort);
    }

    public  class countryData{
        SimpleStringProperty countryName;
        SimpleIntegerProperty confirmed;
        SimpleIntegerProperty active;
        SimpleIntegerProperty recovered;
        SimpleIntegerProperty deaths;

        public countryData(String countryName, int confirmed, int active, int recovered, int deaths){
            this.countryName=new SimpleStringProperty(countryName);
            this.confirmed=new SimpleIntegerProperty(confirmed);
            this.active=new SimpleIntegerProperty(active);
            this.recovered=new SimpleIntegerProperty(recovered);
            this.deaths=new SimpleIntegerProperty(deaths);
        }

        public String getCountryName() {
            return countryName.get();
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
