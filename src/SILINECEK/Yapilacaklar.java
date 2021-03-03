
package SILINECEK;

import errormessage.ErrorMessage;

public class Yapilacaklar {

    public void stickNote(String message) {
        ErrorMessage.appearFatalError(getClass(), message);

    }

}
