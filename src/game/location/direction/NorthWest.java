package game.location.direction;

import game.location.DirectionLocation;

public class NorthWest extends DirectionLocation {

    @Override
    public int getId() {
        return directionCompassValue.NORTH_WEST;
    }

    @Override
    public int getX() {
        return -2;
    }

    @Override
    public int getY() {
        return 2;
    }

}
