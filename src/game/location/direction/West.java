package game.location.direction;

import errormessage.joptionpanel.ShowPanel;
import game.location.DirectionLocation;

public class West extends DirectionLocation {

    @Override
    public int getId() {
        return getCompass().getWest();
    }

    @Override
    public int getX() {
        return -3;
    }

}
