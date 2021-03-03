package game.location.direction;

import game.location.DirectionLocation;

public class West extends DirectionLocation {
//
//    public West(Compass compass) {
//        super(compass);
//    }

    @Override
    public int getId() {
        return getCompass().getWest();
    }

    @Override
    public int getX() {
        return -3;
    }

}
