package printarray;

public class PrintArray<T> {

    public void printArray(T array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public void printMultipleArray(T array[][]) {
        for (int i = array.length - 1; i >= 0; i--) {//
            for (int j = 0; j < array[i].length; j++) {

                System.out.print(array[j][i]);
            }
            System.out.println();
        }
    }

    public void printMultipleArrayBoolean(boolean array[][]) {
        System.out.println("Visited area yazdirma sureci baslatilacak");
        for (int i = array.length - 1; i >= 0; i--) {//
            for (int j = 0; j < array[i].length; j++) {

                if (array[j][i] == true) {
                    System.out.println("[" + j + " ][" + i + "]" + array[j][i]);
                }
            }

        }
        System.out.println("Visited area yazdirma surebi bitti");
    }

    public void NullCheckPoint(T array[][]) {

        for (int i = 0; i < array.length; i++) {

            System.out.println(array[0][0]);

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == null) {
                    System.out.println("NULL : array [" + i + "][" + j + "]");
                }
            }
        }
    }
}
