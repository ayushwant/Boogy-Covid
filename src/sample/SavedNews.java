package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SavedNews implements Initializable {

    @FXML private TextArea newsArea;

    @FXML private Button backBtn;
    @FXML
    private void backListener(ActionEvent event){
        Stage stage= (Stage) backBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLs/news.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            File file = new File("savedNews.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String str = new String(data, "UTF-8");
            newsArea.setText(str);

            } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
