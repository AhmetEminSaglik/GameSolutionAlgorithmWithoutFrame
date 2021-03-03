package game.location.direction;

import game.location.DirectionLocation;

public class NorthWest extends DirectionLocation {

//    public NorthWest(Compass compass) {
//        super(compass);
//    }

    @Override
    public int getId() {
        return getCompass().getNorthWest();
    }

    @Override
    public int getX() {
        return -2;
    }

    @Override
    public int getY() {
        return 2;
    }

}
