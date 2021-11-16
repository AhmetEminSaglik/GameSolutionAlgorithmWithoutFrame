package game.location.direction;

import game.location.DirectionLocation;

public class South extends DirectionLocation {


    @Override
    public int getId() {
        return getCompass().getSouth();
    }

    @Override
    public int getY() {
        return -3;
    }

}
