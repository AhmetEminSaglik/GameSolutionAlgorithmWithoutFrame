package location.direction;

import location.Location;

public class North extends Location {

    @Override
    public int getId() {
        return NORTH;  
    }

    @Override
    public int getY() {
        return 3;
    }

}
