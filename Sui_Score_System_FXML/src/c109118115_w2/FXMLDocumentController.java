/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118115_w2;


import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    GradeBook2D gb = new GradeBook2D();
    private String[] names;
    private int[][] grades;
    private String fileName = "score.csv";
//private File file; //沒用到
    @FXML
    private TextArea display;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
 


    private void read_default_file(ActionEvent event) {
        File file = new File(fileName);
        display.setText(file.getAbsolutePath() + "\n");//塞入一個換行符號
        openFile(file);
        gb.setGrades(grades);
    }

    public void openFile(File file) {
        String row = "";
        String line = "";
        int student_size = 0;
        int numgrades = 0;//紀錄有幾次成績
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                line = input.nextLine();
                System.out.println("---" + line);
                if (!line.isEmpty()) {
                    student_size++;
                    row = line;
                }
            }
            System.out.printf("學生人數:%d \n", student_size);
            numgrades = row.split(",").length - 1;
            System.out.printf("成績個數:%d \n", numgrades);
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("檔案讀取錯誤!");
        }
      
        names = new String[student_size];
        grades = new int[student_size][numgrades];
        try {
            Scanner input = new Scanner(file);
            int stu = 0;
            while (input.hasNextLine()) {
                line = input.nextLine();
                System.out.println("---" + line);
                if (!line.isEmpty()) {
                    String[] rec = line.split(","); //這裡改成各種分隔符號都可以!!
                    names[stu] = rec[0];
                    for (int j = 0; j < numgrades; j++) {
                        grades[stu][j] = Integer.parseInt(rec[j + 1]);
                    }
                    stu++;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("檔案讀取錯誤!");
        }
    }

    private void print_all(ActionEvent event) {
        display.appendText(gb.outputGrades());
    }

    private void get_classAvg(ActionEvent event) {
        String msg = String.format("班平均分:%.2f\n", gb.get_classAvg());
        display.appendText(msg);
    }

    @FXML
    private void TTTT(ActionEvent event) {
    }

    @FXML
    private void classAvg(ActionEvent event) {
        String msg = String.format("班平均分:%.2f\n", gb.get_classAvg());
        display.appendText(msg);
    }

    @FXML
    private void min(ActionEvent event) {
        String msg = String.format("最低分:%d\n", gb.getMax());
        display.appendText(msg);
    
    }

    @FXML
    private void HMS(ActionEvent event) { 
      String msg = String.format("多少成績數量:%d\n", gb.getNumberOfScore());
        display.appendText(msg);
  
    }
    @FXML
    private void ESAvg(ActionEvent event) {
      
     String msg = String.format("每個學生的平均成績:%s\n", Arrays.toString(gb.getStuAverages()));
      display.appendText(msg);        
    }

    @FXML
    private void ESMax(ActionEvent event) {
  String msg = String.format("每個學生的最高成績:%s\n", Arrays.toString(gb.ESMax()));
      display.appendText(msg);        
    }

    @FXML
    private void ESMin(ActionEvent event) {
  String msg = String.format("每個學生的最低成績:%s\n", Arrays.toString(gb.ESMin()));
      display.appendText(msg);          
    }

    @FXML
    private void Max(ActionEvent event) {
        String max = String.format("最高分:%d\n", gb.getMinimum());
        display.appendText(max);
    }

    @FXML
    private void TCavg(ActionEvent event) {
       String msg = String.format("第一次平均分:%.2f\n", gb.TCavg1());
        display.appendText(msg);
      String msg1 = String.format("第二次平均分:%.2f\n", gb.TCavg2());
        display.appendText(msg1);
    }

    @FXML
    private void HMStudent(ActionEvent event) {
               String msg = String.format("學生人數:%d\n", gb.HMS());
        display.appendText(msg);
    }
}
