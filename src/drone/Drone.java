package drone;

import game.location.Location;

public class Drone {
    private Location location = new Location();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
