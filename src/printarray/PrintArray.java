package printarray;

public class PrintArray {
    StringFormat stringFormat = new StringFormat();

    public void printArray(String array[]) {
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);
        }
    }

    public void printMultipleArray(int array[][]) {
        System.out.println(stringFormat.getStringFormatArray(array));

      /*  for (int j = array.length - 1; j >= 0; j--) {
            for (int i = 0; i < array[j].length; i++) {
                System.out.print(printDesign(array[i][j]));
            }
            System.out.println();
        }*/

    }

    public void printMultipleArrayBoolean(boolean array[][]) {

        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == true) {

                    System.out.print("[" + i + " ][" + j + "]  : ");
                    System.out.print(array[i][j]);
                }
            }
        }
    }

 /*   String printDesign(int value) {
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
    }*/

}
