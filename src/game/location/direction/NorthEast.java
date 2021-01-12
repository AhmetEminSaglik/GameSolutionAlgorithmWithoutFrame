package game.location.direction;

import game.location.Location;

public class NorthEast extends Location {

    @Override
    public int getId() {
        return directionCompassValue.NORTH_EAST;
    }

    @Override
    public int getX() {
        return 2;
    }

    @Override
    public int getY() {
        return 2;
    }

}
