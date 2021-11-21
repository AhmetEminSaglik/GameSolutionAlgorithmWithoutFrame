package printarray;

import utility.ConvertVariable;

public class StringFormat {

    public String getStringFormatArray(int array[][]) {
        String text = "";
        for (int j = array.length - 1; j >= 0; j--) {
            for (int i = 0; i < array[j].length; i++) {
                text += printDesign(array[i][j]);
            }
            text += getNextLine();

        }
        text += "----------------------------------" + getNextLine();

        return text;
    }

    private String printDesign(int value) {
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

    private String getNextLine() {
        return "\n";
    }
}
