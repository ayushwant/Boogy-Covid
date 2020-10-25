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
    @FXML
    public Button refreshBtnN;
    public Button backBtnN;
    public TextField tf1;
    public Button readBtn1;
    public Button saveBtn1;
    public TextField tf2;
    public Button readBtn2;
    public Button saveBtn2;
    public TextField tf3;
    public Button readBtn3;
    public Button saveBtn3;
    public TextField tf4;
    public Button readBtn4;
    public Button saveBtn4;
    public TextField tf5;
    public Button readBtn5;
    public Button saveBtn5;
    public TextField tf6;
    public Button readBtn6;
    public Button saveBtn6;
    public TextField tf7;
    public Button readBtn7;
    public Button saveBtn7;
    public TextField tf8;
    public Button readBtn8;
    public Button saveBtn8;
    public TextField tf9;
    public Button readBtn9;
    public Button saveBtn9;
    public TextField tf10;
    public Button readBtn10;
    public Button saveBtn10;
    public TextField tf11;
    public Button readBtn11;
    public Button saveBtn11;
    public TextField tf12;
    public Button readBtn12;
    public Button saveBtn12;
    public TextField tf13;
    public Button readBtn13;
    public Button saveBtn13;
    public TextField tf14;
    public Button readBtn14;
    public Button saveBtn14;
    public TextField tf15;
    public Button readBtn15;
    public Button saveBtn15;
    public TextField tf16;
    public Button readBtn16;
    public Button saveBtn16;
    public TextField tf17;
    public Button readBtn17;
    public Button saveBtn17;
    public TextField tf18;
    public Button readBtn18;
    public Button saveBtn18;
    public TextField tf19;
    public Button readBtn19;
    public Button saveBtn19;
    public TextField tf20;
    public Button readBtn20;
    public Button saveBtn20;

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

    String headline[]=new String[20];
    String link[]=new String[20];

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

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                fetchNews.main(null);
//            }
//        }).start();
    }
}
