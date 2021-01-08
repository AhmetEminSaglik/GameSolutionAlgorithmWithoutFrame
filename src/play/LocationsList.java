package play;

import location.direction.East;
import location.Location;
import location.direction.North;
import location.direction.NorthEast;
import location.direction.NorthWest;
import location.direction.South;
import location.direction.SouthEast;
import location.direction.SouthWest;
import location.direction.West;
import java.util.ArrayList;

public class LocationsList {

    ArrayList<Location> list = new ArrayList<>();

    void fillList() {
        list.add(new North());
        list.add(new NorthEast());
        list.add(new East());
        list.add(new SouthEast());
        list.add(new South());
        list.add(new SouthWest());
        list.add(new West());
        list.add(new NorthWest());
    }

    public ArrayList<Location> getList() {
        if (list.size() == 0) {
            fillList();
        }
        return list;
    }

}
