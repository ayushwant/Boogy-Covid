package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmGraph implements Initializable {

    @FXML
    private Button backBtnC;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private BarChart barChart;

    String statename[]=new String[36];
    int confirmcase[]=new int[36];

    @FXML
    private void backListenerC(ActionEvent event){
        Stage stage= (Stage) backBtnC.getScene().getWindow();
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

        XYChart.Series<String,Number> confirmSeries = new XYChart.Series();
        confirmSeries.setName("CONFIRMED");

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
                statename[i] = state.loc;
                confirmcase[i] = state.totalConfirmed;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 36; i++) {
            confirmSeries.getData().add(new XYChart.Data(statename[i], confirmcase[i]));
        }

        barChart.getData().addAll(confirmSeries);

        for (final XYChart.Data<String,Number> data : confirmSeries.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {
                    Tooltip.install(data.getNode(),new Tooltip("State : "+data.getXValue()+"\nConfirmed : "+data.getYValue()));
                }
            });
        }
    }
}
