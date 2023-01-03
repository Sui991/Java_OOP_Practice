package homework;

public class E1 {

    public static void main(String[] args) {
        String[] fruit = {"fruit0", "fruit1", "fruit2", "fruit3", "fruit4", "fruit5", "fruit6"};
        int[] selected = {3, 9, 0, 2};
        int h;

        for (int i = 0; i < selected.length; i++) {
            try {

                h = selected[i];

                System.out.println(fruit[h]);
            } catch (ArrayIndexOutOfBoundsException egg) {
                System.out.println("選擇錯誤編號");

            }
        }
    }

}
