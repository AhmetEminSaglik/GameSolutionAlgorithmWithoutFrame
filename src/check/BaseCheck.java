package check;

import compass.Compass;
import compass.DirectionCompass;
import validation.Validation;

public abstract class BaseCheck {

    Validation validation = new Validation();
    private Compass compass= new DirectionCompass();

    public Compass getCompass() {
        return compass;
    }

    public void setCompass(Compass compass) {
       // ErrorMessage.appearFatalError(getClass(), "burada compass degistiriliyor");
        this.compass = compass;
    }
}
