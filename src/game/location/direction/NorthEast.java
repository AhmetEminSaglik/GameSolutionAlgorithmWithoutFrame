package game.location.direction;

import game.location.DirectionLocation;

public class NorthEast extends DirectionLocation {
//
//    public NorthEast(Compass compass) {
//        super(compass);
//    }

    @Override
    public int getId() {
        return getCompass().getNorthEast();
    }

    @Override
    public int getX() {
        return 2;
    }

    @Override
    public int getY() {
        return 2;
    }

}
