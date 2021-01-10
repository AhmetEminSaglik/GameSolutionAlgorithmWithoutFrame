package location.direction;

import location.Location;

public class West extends Location {

    @Override
    public int getId() {
        return directionCompassValue.WEST;
    }

    @Override
    public int getX() {
        return -3;
    }

}
