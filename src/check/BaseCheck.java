package check;

import compass.Compass;
import validation.Validation;

public abstract class BaseCheck {

    Validation validation = new Validation();
    private Compass compass;

    public Compass getCompass() {
        return compass;
    }

    public void setCompass(Compass compass) {
        this.compass = compass;
    }
}
