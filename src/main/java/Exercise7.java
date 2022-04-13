/*7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.*/

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Exercise7 {

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/resources/logs/configs/log4j.properties");

        int[] newArr = {5, 3, 1, 4, 2, 1};

        Exercise7 checkBalance = new Exercise7();
        checkBalance.checkBalance(newArr);
    }

    public boolean checkBalance(int[] arr) {
        Logger exercise7 = Logger.getLogger("exercise7");

        boolean result = false;
        int temporary = 0;
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            try {
                counter += arr[i];
                exercise7.debug("counter: " + counter);
            } catch (Exception e) {
                e.printStackTrace();
                exercise7.error("error counter add");
            }
        }

        for (int i = 0; i < arr.length; i++) {
            try {
                temporary += arr[i];
                exercise7.debug("temporary: " + temporary);
                //temporary = 2/0; // for test logs
            } catch (Exception e) {
                e.printStackTrace();
                exercise7.error("Error temporary add");
            }

            if (temporary == (counter - temporary)) {
                result = true;
                System.out.print(arr[i] + " ||| ");

            } else System.out.print(arr[i] + " ");
        }
        System.out.println();
        return result;
    }
}
