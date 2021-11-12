package game.play;

import game.gamerepo.Model;
import printarray.PrintArray;
import sleep.Sleep;

import java.util.ArrayList;

public class CopyModel {

    ArrayList<int[][]> valueList = new ArrayList<int[][]>();

    public int[][] copyModel(Model model) {
        int[][] values = new int[model.getGameSquares().length][model.getGameSquares().length];
        for (int i = 0; i < model.getGameSquares().length; i++) {
            for (int j = 0; j < model.getGameSquares().length; j++) {
                values[i][j] = model.getGameSquares()[i][j];
            }
        }
        return values;
    }

    void addToList(int[][] value) {
        valueList.add(value);

    }

    public void sendModelToCompareAndAddToList(Model model) {
        int[][] values = copyModel(model);
        if (valueList.size() == 0) {
            addToList(values);
        } else {
            int index = 0;
            for (int[][] tmp : valueList) {
                index++;
                if (comparedItemsAreSame(tmp, values)) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   DEGERLER AYNI OLDUGUNDAN LISTEYE EKLENMICEK");

                    for (int i = 0; i < valueList.size(); i++) {

                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ index : "+i);
                        new PrintArray().printMultipleArray(valueList.get(i));


                    }
                    System.out.println("-----");
                    new PrintArray().printMultipleArray(values);
                    System.out.println("============================================================");
                    System.out.println("INDEX : "+index);
                    System.out.println("size : "+valueList.size());
                    new Sleep().sleep(10_000);

                    return;
                }
            }
            addToList(values);
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DEGERLER FARKLI OLDUGUNDAN LISTEYE EKLENECEK " + valueList.size());

        }


    }

    boolean comparedItemsAreSame(int[][] v1, int[][] v2) {
//        boolean breakLoop = false;
        for (int i = 0; i < v1.length; i++) {
//            if (breakLoop == true) {
//                break;
//            }
            for (int j = 0; j < v1.length; j++) {
                if (v1[i][j] != v2[i][j]) {
                    return false;
//                    breakLoop = true;
//                    System.out.println("Degerler farkli,  listeye eklenecek");
//                    addToList(v2);
//                    break;

                }

            }

        }
        return true;
    }
}
