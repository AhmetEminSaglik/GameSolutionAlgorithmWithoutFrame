package printarray;

import sleep.Sleep;
import utility.ConvertVariable;

public class PrintArray {

    public void printArray(String array[]) {
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);
        }
    }

    public void printMultipleArray(int array[][]) {
        for (int j = array.length - 1; j >= 0; j--) {
//            System.out.print("j  " + j + " : ");
            for (int i = 0; i < array[j].length; i++) {//
//                System.out.print("i : " + i + "  ");


                System.out.print(printDesign(array[i][j]));
            }
            System.out.println();
        }

       /* for (int i = array.length - 1; i >= 0; i--) {//
//            System.out.print("i : "+i+"  ");
            for (int j = 0; j < array[i].length; j++) {
//                System.out.print("j  "+j + " : ");
                System.out.print(printDesign(array[j][i]));
            }
            System.out.println();
        }
*/
    }

    public void printMultipleArrayBoolean(boolean array[][]) {
        //      System.out.println("Visited area yazdirma sureci baslatilacak");
        //  System.out.println(" Max  i ve j " + array.length + " , " + array[0].length);
        for (int i = array.length - 1; i >= 0; i--) {

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == true) {

                    System.out.print("[" + i + " ][" + j + "]  : ");
                    System.out.println(array[i][j]);
//                    new Sleep().sleep(1_000);
                }
            }

        }
        System.out.println("DIzi yazdirildi ve beklenecek 5 saniye");

        //       System.out.println("Visited area yazdirma surebi bitti");
    }

    String printDesign(int value) {
        if (value > 0) {
            if (value / 100 > 0) {
                return "|" + new ConvertVariable().intToString(value) + "|";
            } else if (value / 10 > 0) {
                return "|" + new ConvertVariable().intToString(value) + " |";
            } else {

                return "| " + new ConvertVariable().intToString(value) + " |";

            }
        }
        return "|   |";
    }

    /*public void NullCheckPoint(String array[][]) {

        for (int i = 0; i < array.length; i++) {

            System.out.println(array[0][0]);

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == null) {
                    System.out.println("NULL : array [" + i + "][" + j + "]");
                }
            }
        }
    }*/
}
