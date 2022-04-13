/*8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

public class Exercise8 {


    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/logs/configs/log4j.properties");

        int[] newArr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(newArr));
        Exercise8 displacementArr = new Exercise8();
        displacementArr.displacementArr(newArr, 7);
    }

    public int[] displacementArr(int[] arr, int n) {

        Logger exercise8 = Logger.getLogger("exercise8");
        if (n != 0) {

            int finalN;
            if (n > arr.length) {
                n = Math.abs(n % arr.length);
            } else {
                finalN = n;
            }

            try {
                if (n > 0) {
                    for (int i = 0; i < n; i++) {

                        int buffer = arr[0];
                        arr[0] = arr[arr.length - 1];

                        for (int j = 1; j < arr.length - 1; j++) {
                            arr[arr.length - j] = arr[arr.length - j - 1];
                        }

                        arr[1] = buffer;

                    }
                } else if (n < 0) {
                    for (int i = 0; i > n; n--) {
                        int buffer = arr[arr.length - 1];
                        arr[arr.length - 1] = arr[0];

                        for (int j = 1; j < arr.length - 1; j++) {
                            arr[j - 1] = arr[j];
                        }

                        arr[arr.length - 2] = buffer;

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                exercise8.error("Error bias array");
            }


            System.out.println(Arrays.toString(arr));
        }
        exercise8.debug("arr" + Arrays.toString(arr));
        return arr;
    }
}