package location.direction;

import location.Location;

public class NorthWest extends Location {

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
