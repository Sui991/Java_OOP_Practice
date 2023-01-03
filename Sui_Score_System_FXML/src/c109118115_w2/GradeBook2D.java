package c109118115_w2;

public class GradeBook2D {

    private int[][] grades;
    private String[] names;
    

    public GradeBook2D() {//建構子1
    }

    public GradeBook2D(int[][] grades) {//建構子2
        this.grades = grades;
    }

    public GradeBook2D(int grades[][], String[] names) //建構子3
    {
        this.names = names;
        this.grades = grades;
    }

    public void setGrades(int[][] grades) {
        this.grades = grades;
    }
public  int[] ESMax() {
        int HighGrade = grades[0][0];
        int esmax[]=new int[grades.length];
        for (int i=0;i<grades.length;i++) {
            for (int j=0;j< grades[i].length; j++) {
                if (grades[i][j] > HighGrade) {
                    HighGrade = grades[i][j];
                }
            }
            esmax[i]=HighGrade;
            HighGrade=0;
        }
        return esmax;
    }
public  int[] ESMin() {
        int LowGrade = grades[0][0];
        int esmin[]=new int[grades.length];
        for (int i=0;i<grades.length;i++) {
            for (int j=0;j< grades[i].length; j++) {
                if (grades[i][j] < LowGrade) {
                    LowGrade = grades[i][j];
                }
            }
            esmin[i]=LowGrade;
            LowGrade=100;
        }
        return esmin;
    }
    public int getNumberOfScore() {
        return this.grades[0].length;
    }

    public int getNumberOfStudent() {
        return grades.length;
    }

    public String outputGrades() {
        String msg = "";
        for (int student = 0; student < grades.length; student++) {
            msg += String.format("學生序號:%2d", student + 1);
            for (int test : grades[student]) {
                msg += String.format("%3d", test);
            }
            double average = getAvg(grades[student]);
            msg += String.format("%9.2f\n", average);
        }
        return msg;
    }

    public double get_classAvg() {
        int total = 0;
        int count = 0;

        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                total += grades[i][j];
                count++;
            }
        }
        return (double) total / count;
    }

    public double getAvg(int[] setOfGrades) {
        int total = 0;

        for (int grade : setOfGrades) {
            total += grade;
        }
        return (double) total / setOfGrades.length;
    }

    public int getMinimum() {
        int lowGrade = grades[0][0];
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade >lowGrade) {
                    lowGrade = grade;
                }
            }
        }

        return lowGrade;
    }
public int getMax() {
        int HighGrade = grades[0][0];
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade < HighGrade) {
                    HighGrade = grade;
                }
            }
        }

        return HighGrade;
    }

    public int getFailed() {
        int count = 0;
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                if (grades[i][j] < 60) {
                    count++;
                }
            }
        }
        return count;
    }

    //計算每位學生平均，以一維陣列回傳
     
      
    
   public int HMS() { int count=0;
   for (int i = 0; i < grades.length; i++) {
          
            for (int j = 0; j < grades[i].length; j++) {
              
            }
            count+=1;
            
   }return count;
   }
    public double[] getStuAverages() {
        double [] averages=new double[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int total = 0;
            for (int j = 0; j < grades[i].length; j++) {
                total = total + grades[i][j];
            }
            averages[i] = (double) total / grades[i].length;
        }
        return averages;
    }
    public  double TCavg1() {
        double avg=0;
        int count=0;
        int total=0;
         for (int i = 0; i < grades.length; i++) {
          
            for (int j = 0; j < grades[i].length; j++) {
              
            }
            count+=1;
         }
         for (int i = 0; i < count; i++) {
            
              total+=grades[i][0];
                }
            avg = (double) total / count;
        return avg;
    }
     public  double TCavg2() {
        double avg=0;
        int count=0;
        int total=0;
         for (int i = 0; i < grades.length; i++) {
          
            for (int j = 0; j < grades[i].length; j++) {
              
            }
            count+=1;
         }
         for (int i = 0; i < count; i++) {
            
              total+=grades[i][1];
                }
            avg = (double) total / count;
        return avg;
    }
}

