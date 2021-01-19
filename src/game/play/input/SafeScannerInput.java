package game.play.input;

import errormessage.ErrorMessage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeScannerInput {

    private Scanner scanner = new Scanner(System.in);
    private int input;

    private String inputMismatchMessage = "Please enter number between  0 and 10 (except these numbers)";

    public int getInput() {

        while (true) {
            try {
                input = getIntegerValue(scanner.nextLine());
                return input;
            } catch (InputMismatchException ex) {

                ErrorMessage.appearClassicError(ex.getMessage());

            }
            return getInput();
        }
    }

    int getIntegerValue(String text) {
        try {
            int value = Integer.parseInt(text);
            isNumberProper(value);
            return value;
        } catch (NumberFormatException ex) {
            throw new InputMismatchException(inputMismatchMessage);
        }

    }

    boolean isNumberProper(int value) throws InputMismatchException {
        if (0 <= value && value < 10) {
            return true;

        }
        throw new InputMismatchException(inputMismatchMessage);
    }

}
