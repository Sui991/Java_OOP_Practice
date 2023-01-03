/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketordermain;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    private String[] stations = {"台北", "台中", "嘉義", "左營"};
    private String[] seats = {"無", "靠窗優先", "走道優先"};
    private int price[][] = {
        {0, 700, 1350, 1490},
        {700, 0, 650, 790},
        {1350, 650, 0, 140},
        {1490, 790, 140, 0}};

    @FXML
    private ComboBox<String> fromstation;
    @FXML
    private ComboBox<String> tostation;
    @FXML
    private TextArea display;
    @FXML
    private ToggleGroup ticketType;
    @FXML
    private RadioButton adult;
    @FXML
    private RadioButton child;
    @FXML
    private TextField count;
    @FXML
    private RadioButton one;
    @FXML
    private ToggleGroup ticketType2;
    @FXML
    private RadioButton one1;
    @FXML
    private ComboBox<String> seat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        fromstation.getItems().addAll("台北", "台中", "嘉義", "左營");
//        fromstation.setValue("台北");//設定起站為台北
//        tostation.setValue("左營"); //設定訖站左營
//        tostation.getItems().addAll("台北", "台中", "嘉義", "左營");

        for (int i = 0; i < stations.length; i++) {
            fromstation.getItems().addAll(stations[i]);
            tostation.getItems().addAll(stations[i]);
        }
        fromstation.setValue(stations[0]);
        tostation.setValue(stations[stations.length - 1]); 
         for (int i = 0; i < seats.length; i++) {
            seat.getItems().addAll(seats[i]);       
        }
        seat.setValue(seats[0]);
   
    }

    @FXML
    private void exchange(ActionEvent event) {
         String from = fromstation.getValue();
String to = tostation.getValue();
tostation.setValue( from );
fromstation.setValue( to );
/*
int from = fromStation.getSelectionModel().getSelectedIndex();
int to = toStation.getSelectionModel().getSelectedIndex();
fromStation.getSelectionModel().select(to);
toStation.getSelectionModel().select(from);
*/
    }

    @FXML
    private void purchase(ActionEvent event) {

        int from = fromstation.getSelectionModel().getSelectedIndex();
        int to = tostation.getSelectionModel().getSelectedIndex();
        String fromSt = fromstation.getValue();
        String toSt = tostation.getValue();

        int amount = 0;
int cou=Integer.valueOf(count.getText());
        amount = price[from][to];
        String ticket_type = "";
        if (adult.isSelected()) {
            amount = price[from][to];
            ticket_type = adult.getText();
        } else {
            amount = (int) (price[from][to] * 0.5);
            ticket_type = child.getText();
        }
   if (one1.isSelected()) {
       amount=amount*2;
   }
        String msg = String.format("從%s到%s 票價:%d\n", fromSt, toSt, amount*cou);
        display.setText(msg);

        Date c = new Date();
        String datemsg = String.format("購買日期:%tY 年%tm 月%td 日\n", c, c, c);
        String pre=seat.getValue();
          String prefer = String.format("座位偏好:%s",pre);
        display.appendText(datemsg);
        display.appendText(prefer);
    }

}
