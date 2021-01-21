package game.location.direction;

import game.location.DirectionLocation;

public class West extends DirectionLocation {

    @Override
    public int getId() {
        return directionCompassValue.WEST;
    }

    @Override
    public int getX() {
        return -3;
    }

}
