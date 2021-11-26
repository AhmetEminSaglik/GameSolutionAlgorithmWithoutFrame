package game.location.direction;

import game.location.DirectionLocation;

public class LastLocation extends DirectionLocation {
    /**
     * Return directly value which is given 5.
     */
    @Override
    public int getId() {
        return getCompass().getLastLocation();
    }

}
