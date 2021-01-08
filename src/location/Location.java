package location;

import compass.Compass;
import location.direction.IDirectionCompassValues;

public abstract class Location implements IDirectionCompassValues {

    private int id;
    private int x = 0, y = 0;

    public abstract int getId();

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
        return "Location{" + "id=" + id + ", x=" + getX() + ", y=" + getY() + '}';
    }

    /**
     * return Location of
     *
     * @param compass = is used to specify keyboradCommpas or DirectionCompass
     * @param directionIndex = is used to get index and index changes according
     * to Compass (Compass is abstract)
     */
    public static Location getLocationFromCompass(Compass compass, int directionIndex) {
        return new SwitchDirection(compass).choseDirection(directionIndex);
    }

}
