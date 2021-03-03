package game.location.direction;

import game.location.DirectionLocation;

public class South extends DirectionLocation {

//    public South(Compass compass) {
//        super(compass);
//    }

    @Override
    public int getId() {
        return getCompass().getSouth();
    }

    @Override
    public int getY() {
        return -3;
    }

}
