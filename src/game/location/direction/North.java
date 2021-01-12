package game.location.direction;

import game.location.Location;

public class North extends Location {

    @Override
    public int getId() {
        return directionCompassValue.NORTH;  
    }

    @Override
    public int getY() {
        return 3;
    }

}
