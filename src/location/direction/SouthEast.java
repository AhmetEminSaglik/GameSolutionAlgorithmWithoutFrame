package location.direction;

import location.Location;

public class SouthEast extends Location {

    @Override
    public int getId() {
        return directionCompassValue.SOUTH_EAST;
    }

    @Override
    public int getX() {
        return 2;

    }

    @Override
    public int getY() {
        return -2;
    }

}
