package utility;

public class ConvertVariable {

    public static String intToString(int value) {
        return Integer.toString(value);

    }

    public static int StringToInt(String text) {
        try {

            return Integer.parseInt(text);

        } catch (NumberFormatException ex) {
         //   ErrorMessage.appearClassicError(ex.getMessage());
        }
        return -1;

    }
}
