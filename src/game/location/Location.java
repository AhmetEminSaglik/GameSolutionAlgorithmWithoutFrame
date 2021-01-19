package game.location;

import compass.Compass;
import compass.KeyboardCompass;
import game.gamerepo.CreateLocationOfLastStep;
import game.gamerepo.GameModel;
import game.location.direction.DirectionCompassValues;

public class Location {

    public DirectionCompassValues directionCompassValue = new DirectionCompassValues();

    private int id;
    private int x = 0, y = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + getId() + ", x=" + getX() + ", y=" + getY() + "}"; //To change body of generated methods, choose Tools | Templates.
    }

    public static Location getLocationFromCompass(Compass compass, int directionIndex) {
        return new SwitchDirection(compass).choseDirection(directionIndex);
    }

    public void printLocation() {
        System.out.println(toString());
    }

    /**
     * return Location of
     *
     * @param compass = is used to specify keyboradCommpas or DirectionCompass
     * @param directionIndex = is used to get index and index changes according
     * to Compass (Compass is abstract)
     */
    public Location getLocationValueAccordingToEnteredValue(GameModel gameModel, int choose) {
        if (choose == new KeyboardCompass().getLastLocation()) {
            return new CreateLocationOfLastStep(gameModel).createLastStepLocation();
        }
        return new SwitchDirection(new KeyboardCompass()).choseDirection(choose);
    }
}