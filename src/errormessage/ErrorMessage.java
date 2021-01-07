package errormessage;

public class ErrorMessage {

    public static void appearFatalError(String message) {
        new FatalErrorMessage().showMessage(message);

    }

    public static void appearClassicError(String message) {
        new ClassicErrorMessage().showMessage(message);
    }
}
