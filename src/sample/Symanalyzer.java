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
    public RadioButton rby1;
    public RadioButton rby2;
    public RadioButton rby3;
    public RadioButton rby4;
    public RadioButton rby5;
    public RadioButton rby6;
    public RadioButton rbn1;
    public RadioButton rbn2;
    public RadioButton rbn3;
    public RadioButton rbn4;
    public RadioButton rbn5;
    public RadioButton rbn6;
    public Label lb2;



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

        if (rby1.isSelected()) {
            chanceper=1;
        }
        if (rbn1.isSelected()) {
            chanceper += 0;
        }
        if (rby2.isSelected()) {
            chanceper=2;
        }
        if (rbn2.isSelected()) {
            chanceper +=0;
        }
        if (rby3.isSelected()) {
            chanceper=3;;
        }
        if (rbn3.isSelected()) {
            chanceper += 0;
        }


        if (rby4.isSelected()) {
            chanceper=4;
        }
        if (rbn4.isSelected()) {
            chanceper += 0;
        }

        if (rby5.isSelected()) {
            chanceper=5;
        }
        if (rbn5.isSelected()) {
            chanceper += 0;
        }

        if (rby6.isSelected()) {
            chanceper=6;
        }
        if (rbn6.isSelected()) {
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
        lb2.setText(message);
    }
}
