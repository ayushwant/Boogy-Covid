package sample;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class News implements Initializable {

    @FXML private TextField tf1;
    @FXML private Button saveBtn1;
    @FXML private TextField tf2;
    @FXML private Button saveBtn2;
    @FXML private TextField tf3;
    @FXML private Button saveBtn3;
    @FXML private TextField tf4;
    @FXML private Button saveBtn4;
    @FXML private TextField tf5;
    @FXML private Button saveBtn5;
    @FXML private TextField tf6;
    @FXML private Button saveBtn6;
    @FXML private TextField tf7;
    @FXML private Button saveBtn7;
    @FXML private TextField tf8;
    @FXML private Button saveBtn8;
    @FXML private TextField tf9;
    @FXML private Button saveBtn9;
    @FXML private TextField tf10;
    @FXML private Button saveBtn10;
    @FXML private TextField tf11;
    @FXML private Button saveBtn11;
    @FXML private TextField tf12;
    @FXML private Button saveBtn12;
    @FXML private TextField tf13;
    @FXML private Button saveBtn13;
    @FXML private TextField tf14;
    @FXML private Button saveBtn14;
    @FXML private TextField tf15;
    @FXML private Button saveBtn15;
    @FXML private TextField tf16;
    @FXML private Button saveBtn16;
    @FXML private TextField tf17;
    @FXML private Button saveBtn17;
    @FXML private TextField tf18;
    @FXML private Button saveBtn18;
    @FXML private TextField tf19;
    @FXML private Button saveBtn19;
    @FXML private TextField tf20;
    @FXML private Button saveBtn20;

    Desktop d=Desktop.getDesktop();

    @FXML
    void link1(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[0]));
    }
    @FXML
    void link2(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[1]));
    }
    @FXML
    void link3(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[2]));
    }
    @FXML
    void link4(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[3]));
    }
    @FXML
    void link5(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[4]));
    }
    @FXML
    void link6(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[5]));
    }
    @FXML
    void link7(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[6]));
    }
    @FXML
    void link8(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[7]));
    }
    @FXML
    void link9(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[8]));
    }
    @FXML
    void link10(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[9]));
    }
    @FXML
    void link11(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[10]));
    }
    @FXML
    void link12(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[11]));
    }
    @FXML
    void link13(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[12]));
    }
    @FXML
    void link14(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[13]));
    }
    @FXML
    void link15(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[14]));
    }
    @FXML
    void link16(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[15]));
    }
    @FXML
    void link17(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[16]));
    }
    @FXML
    void link18(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[17]));
    }
    @FXML
    void link19(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[18]));
    }
    @FXML
    void link20(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[19]));
    }

    @FXML private String headline[]=new String[20];
    @FXML private String link[]=new String[20];

    @FXML private Button refreshBtnN;
    @FXML
    void refreshListenerN(ActionEvent event){
        System.out.println("refreshing news");
        Stage stage= (Stage) refreshBtnN.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("news.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root,700,700));
    }

    @FXML private Button backBtnN;
    @FXML
    void backListenerN(ActionEvent event){
        Stage stage= (Stage) backBtnN.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fetchNews.main(null);
        new Thread(new Runnable() {
            @Override
            public void run() {

                Gson gson = new GsonBuilder().create();
                try {
                    BufferedReader br = new BufferedReader(new FileReader("newsJSON.json"));
                    covidNews news=gson.fromJson(br,covidNews.class);
                    covidNews.allArticles[] arts= news.articles;
                    int i=0;
                    for(covidNews.allArticles art : arts)
                    {
                        headline[i]=art.title;
                        link[i]=art.url;
                        i++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        tf1.setText(""+headline[0]);
                        tf2.setText(""+headline[1]);
                        tf3.setText(""+headline[2]);
                        tf4.setText(""+headline[3]);
                        tf5.setText(""+headline[4]);
                        tf6.setText(""+headline[5]);
                        tf7.setText(""+headline[6]);
                        tf8.setText(""+headline[7]);
                        tf9.setText(""+headline[8]);
                        tf10.setText(""+headline[9]);
                        tf11.setText(""+headline[10]);
                        tf12.setText(""+headline[11]);
                        tf13.setText(""+headline[12]);
                        tf14.setText(""+headline[13]);
                        tf15.setText(""+headline[14]);
                        tf16.setText(""+headline[15]);
                        tf17.setText(""+headline[16]);
                        tf18.setText(""+headline[17]);
                        tf19.setText(""+headline[18]);
                        tf20.setText(""+headline[19]);
                    }
                });
            }
        }).start();
    }
}
