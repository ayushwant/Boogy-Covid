package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class IndiaHistoricalFXML
{

    @FXML private DatePicker datePicker;
    @FXML private Label dateLabel;
    @FXML private void getDate(ActionEvent event)
    {

        LocalDate i = datePicker.getValue();

        // get the selected date
        dateLabel.setText("Date :" + i);
        System.out.println("Date :" +i);

    }


}
