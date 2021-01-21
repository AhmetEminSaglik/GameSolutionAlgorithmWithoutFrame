package game.location.direction;

import game.location.DirectionLocation;

public class East extends DirectionLocation {

    @Override
    public int getId() {
        return directionCompassValue.EAST;
    }

    @Override
    public int getX() {
        return 3;
    }

}
