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
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    HashMap<String, String> saved = new HashMap<String, String>();

    public News() throws IOException {
    }



    @FXML
    void link1(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[0]));
    }
    @FXML
    void save1(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            saved.put(tf1.getText(),Description[0] + "\n" + "Link : " + link[0]);

    }

    @FXML
    void link2(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[1]));
    }

    @FXML
    void save2(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf2.getText(),Description[1] + "\n" + "Link : " + link[1]);
    }

    @FXML
    void link3(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[2]));
    }

    @FXML
    void save3(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf3.getText(),Description[2] + "\n" + "Link : " +  link[2]);
    }
    @FXML
    void link4(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[3]));
    }

    @FXML
    void save4(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf4.getText(),Description[3] + "\n" + "Link : " +  link[3]);
    }
    @FXML
    void link5(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[4]));
    }
    @FXML
    void save5(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf5.getText(),Description[4] + "\n" + "Link : " + link[4]);
    }

    @FXML
    void link6(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[5]));
    }
    @FXML
    void save6(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf6.getText(),Description[5] + "\n" + "Link : " + link[5]);
    }

    @FXML
    void link7(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[6]));
    }
    @FXML
    void save7(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf7.getText(),Description[6] + "\n" + "Link : " + link[6]);
    }
    @FXML
    void link8(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[7]));
    }
    @FXML
    void save8(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf8.getText(),Description[7] + "\n" + "Link : " + link[7]);
    }

    @FXML
    void link9(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[8]));
    }
    @FXML
    void save9(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf9.getText(),Description[8] + "\n" + "Link : " + link[8]);
    }

    @FXML
    void link10(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[9]));
    }
    @FXML
    void save10(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf10.getText(),Description[9] + "\n" + "Link : " + link[9]);
    }

    @FXML
    void link11(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[10]));
    }
    @FXML
    void save11(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf11.getText(),Description[10] + "\n" + "Link : " + link[10]);
    }

    @FXML
    void link12(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[11]));
    }
    @FXML
    void save12(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf12.getText(),Description[11] + "\n" + "Link : " + link[11]);
    }

    @FXML
    void link13(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[12]));
    }
    @FXML
    void save13(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf13.getText(),Description[12] + "\n" + "Link : " + link[12]);
    }

    @FXML
    void link14(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[13]));
    }
    @FXML
    void save14(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf14.getText(),Description[13] + "\n" + "Link : " + link[13]);
    }

    @FXML
    void link15(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[14]));
    }
    @FXML
    void save15(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf15.getText(),Description[14] + "\n" + "Link : " + link[14]);
    }

    @FXML
    void link16(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[15]));
    }
    @FXML
    void save16(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf16.getText(),Description[15] + "\n" + "Link : " + link[15]);
    }

    @FXML
    void link17(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[16]));
    }
    @FXML
    void save17(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf17.getText(),Description[16] + "\n" + "Link : " + link[16]);
    }

    @FXML
    void link18(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[17]));
    }
    @FXML
    void save18(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf18.getText(),Description[17] + "\n" + "Link : " + link[17]);
    }

    @FXML
    void link19(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[18]));
    }
    @FXML
    void save19(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf19.getText(),Description[18] + "\n" + "Link : " + link[18]);
    }

    @FXML
    void link20(ActionEvent event) throws URISyntaxException, IOException {
        d.browse(new URI(link[19]));
    }
    @FXML
    void save20(ActionEvent event){

        File file = new File("savedNews.txt");
        BufferedWriter bf = null;
        try{
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            bf = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, String> entry : saved.entrySet())
            {
                bf.write(entry.getKey() + "\n" +entry.getValue() +"\n\n");
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        saved.put(tf20.getText(),Description[19] + "\n" + "Link : " + link[19]);
    }


    @FXML private String headline[]=new String[20];
    @FXML private String link[]=new String[20];
    @FXML private String Description[]=new String[20];

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

    @FXML private Button favouriteBtn;
    @FXML
    void favouriteListener(ActionEvent event){
        Stage stage= (Stage) favouriteBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("savedNews.fxml"));
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
                        Description[i]=art.description;
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