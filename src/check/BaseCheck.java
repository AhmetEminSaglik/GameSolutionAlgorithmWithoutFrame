package check;

import compass.Compass;
import compass.DirectionCompass;
import game.Game;
import game.location.Location;
import validation.Validation;

public abstract class BaseCheck {

    private Game game;
    Validation validation = new Validation();
    private Compass compass = new DirectionCompass();


    public Compass getCompass() {
        return compass;
    }

    public void setCompass(Compass compass) {
        this.compass = compass;
    }

    public Location getPlayerLocation(Game game) {
        Location locationWillBeCheck = new Location();
        locationWillBeCheck.setX(game.getPlayer().getLocation().getX());
        locationWillBeCheck.setY(game.getPlayer().getLocation().getY());
        return locationWillBeCheck;
    }


}
