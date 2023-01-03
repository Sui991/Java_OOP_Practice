package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class E2 {

    public static void main(String[] args) throws FileNotFoundException {
        String[] names;
        int[][] scores;
        int num_students = 0; //紀錄有幾位學生
        int num_scores = 0; //紀錄有幾次成績
      Scanner input = new Scanner(new File("score.csv"));
        String row = "";

        while (input.hasNextLine()) {
            num_students++;
            row = input.nextLine();
        }
        num_scores = row.split(",").length - 1; //扣掉前面一個姓名才是成績個數
       
        System.out.printf("學生人數:%d \n", num_students);
        System.out.printf("成績個數:%d \n", num_scores);
           System.out.println("姓名       成績1  成績2 成績3 個人平均");
        scores = new int[num_students][num_scores];
        names = new String[num_students];
        input = new Scanner(new File("score.csv")); //讀過不回頭,此處須重新接一次水管 再讀一次
        int stu = 0; //學生索引
        while (input.hasNextLine()) { //已經知道有幾位學生,你可以改用 for 迴圈讀取,比較簡單
            row = input.nextLine();
            String[] rec = row.split(","); //這裡改成各種分隔符號都可以!!
            names[stu] = rec[0];
            for (int j = 0; j < num_scores; j++) {
                scores[stu][j] = Integer.parseInt(rec[j + 1]); //
            }
            stu++;
        }
        printScores(scores, names);

    }

    public static void printScores(int[][] scores, String[] names) {
        int avg=0;
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%s     ", names[i]);
            for (int j = 0; j < scores[i].length; j++) {
                System.out.printf("%d     ", scores[i][j]);
                avg+=scores[i][j];
            }
             System.out.print(avg/3);
             avg=0;
            System.out.println();
        }
    }
}
