package game.location.direction;

import game.location.Location;

public class South extends Location {

    @Override
    public int getId() {
        return directionCompassValue.SOUTH;
    }

    @Override
    public int getY() {
        return -3;
    }

}
