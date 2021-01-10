package Main;

import errormessage.ErrorMessage;

public class SILINECEKAnlikNotAlmaIcin {

    String text = " Game over classi calisirken keyboardCompass ile IDirectionCompasValue degerleri cakistigi icin sorun aliyorum";

    public SILINECEKAnlikNotAlmaIcin() {
        ErrorMessage.appearFatalError(text);
    }

}
