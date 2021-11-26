package game.location;

import game.location.direction.East;
import game.location.direction.LastLocation;
import game.location.direction.North;
import game.location.direction.NorthEast;
import game.location.direction.NorthWest;
import game.location.direction.South;
import game.location.direction.SouthEast;
import game.location.direction.SouthWest;
import game.location.direction.West;

import java.util.ArrayList;

public class LocationsList {

    ArrayList<DirectionLocation> list = new ArrayList<>();

    void fillList() {

        list.add(new North());
        list.add(new NorthEast());
        list.add(new East());
        list.add(new SouthEast());
        list.add(new South());
        list.add(new SouthWest());
        list.add(new West());
        list.add(new NorthWest());
        list.add(new LastLocation());

    }

    public ArrayList<DirectionLocation> getList() {
        if (list.size() == 0) {
            fillList();
        }
        return list;
    }

    public DirectionLocation getLastLocation() {

        return new LastLocation();
    }

}
