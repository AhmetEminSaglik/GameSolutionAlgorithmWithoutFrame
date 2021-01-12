package utility;

public class ConvertVariable {

    public String intToString(int value) {
        return Integer.toString(value);

    }

    public int StringToInt(String text) {
        try {

            return Integer.parseInt(text);

        } catch (NumberFormatException ex) {
            //   ErrorMessage.appearClassicError(ex.getMessage());
        }
        return -1;

    }
}
