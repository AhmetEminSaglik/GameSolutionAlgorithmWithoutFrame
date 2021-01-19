package SILINECEK;

import errormessage.ErrorMessage;

public class Yapilacaklar {

    public static void stickNote(String message) {
        ErrorMessage.appearFatalError(message);
    }

}
