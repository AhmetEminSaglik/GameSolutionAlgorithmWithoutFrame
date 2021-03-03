package game.location.direction;

import game.location.DirectionLocation;

public class SouthEast extends DirectionLocation {

//    public SouthEast(Compass compass) {
//        super(compass);
//    }

    @Override
    public int getId() {
        return getCompass().getSouthEast();
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
