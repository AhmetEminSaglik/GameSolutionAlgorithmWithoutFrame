package game.location.direction;

import game.location.DirectionLocation;

public class SouthWest extends DirectionLocation {
//
//    public SouthWest(Compass compass) {
//        super(compass);
//    }

    @Override
    public int getId() {
        return getCompass().getSouthWest();
    }

    @Override
    public int getX() {
        return -2;
    }

    @Override
    public int getY() {
        return -2;
    }

}
