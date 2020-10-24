package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class Symanalyzer {
    public Button backBtnSA;
    public RadioButton rbYes1A;
    public RadioButton rbYes1B;
    public RadioButton rbYes1C;
    public RadioButton rbYes1D;
    public RadioButton rbYes2;
    public RadioButton rbYes3;
    public RadioButton rbNo1A;
    public RadioButton rbNo1B;
    public RadioButton rbNo1C;
    public RadioButton rbNo1D;
    public RadioButton rbNo2;
    public RadioButton rbNo3;
    public Button resetBtnSA;
    public Label resultLbl;


     public void resetListenerSA(ActionEvent actionEvent){
        System.out.println("Data reset : true");
        Stage stage= (Stage) resetBtnSA.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("symanalyzer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }

    public void backlistenerSA(ActionEvent event){
        Stage stage= (Stage) backBtnSA.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
    }
    public void radioSelect(ActionEvent event){
        String message ="";
        int chanceper =0;

        if (rbYes1A.isSelected()) {
            chanceper=1;
        }
        if (rbNo1A.isSelected()) {
            chanceper += 0;
        }
        if (rbYes1B.isSelected()) {
            chanceper=2;
        }
        if (rbNo1B.isSelected()) {
            chanceper +=0;
        }
        if (rbYes1C.isSelected()) {
            chanceper=3;;
        }
        if (rbNo1C.isSelected()) {
            chanceper += 0;
        }
        if (rbYes1D.isSelected()) {
            chanceper=4;
        }
        if (rbNo1D.isSelected()) {
            chanceper += 0;
        }

        if (rbYes2.isSelected()) {
            chanceper=5;
        }
        if (rbNo2.isSelected()) {
            chanceper += 0;
        }
        if (rbYes3.isSelected()) {
            chanceper=6;
        }
        if (rbNo3.isSelected()) {
            chanceper += 0;
        }

        if (chanceper ==0){
            message += "You are at " + 0 + "% risk. Be safe and healthy.";
        }
        if (chanceper == 1){
            message += "You are at " + 1 + "% to " + 20 + "% risk. Be in Quarantine and visit medical if necessary.";
        }
        if (2 <= chanceper && chanceper <= 3) {
            message += "You are at " + 20 + "% to " + 60 + "% risk. Call to GOV helpline NO. and visit Hospital.";
        }
        if (chanceper==4) {
            message += "You are at " + 60 + "% to " + 80 + "% risk. Call to GOV helpline NO. and visit Hospital.";
        }
        if (5 <= chanceper && chanceper <= 6) {
            message += "You are at " + 80 + "% to " + 100 + "% risk. Must go for covid-19 checkup.";
        }
        resultLbl.setText(message);
    }
}
