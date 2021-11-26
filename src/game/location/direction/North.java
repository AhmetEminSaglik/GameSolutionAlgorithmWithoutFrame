package game.location.direction;

import errormessage.joptionpanel.ShowPanel;
import game.location.DirectionLocation;

public class North extends DirectionLocation {
//
//    public North(Compass compass) {
//        super(compass);
//    }

    @Override
    public int getId() {

    
        return getCompass().getNorth();
    }

    @Override
    public int getY() {
        return 3;
    }

}

/*
package game.location.direction;

import game.location.DirectionLocation;

public class North extends DirectionLocation {

    @Override
    public int getId() {
        return directionCompassValue.NORTH;  
    }

    @Override
    public int getY() {
        return 3;
    }

}

 */
