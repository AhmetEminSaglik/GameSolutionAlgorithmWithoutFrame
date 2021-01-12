package game.location.direction;

import game.location.Location;

public class East extends Location {

    @Override
    public int getId() {
        return directionCompassValue.EAST;
    }

    @Override
    public int getX() {
        return 3;
    }

    

}
