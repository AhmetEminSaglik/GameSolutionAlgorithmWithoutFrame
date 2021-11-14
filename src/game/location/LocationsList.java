package game.location;

import compass.Compass;
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
    Compass compass;
    
//
//    public LocationsList(Compass compass) {
//        this.compass = compass;
//    }

    void fillList() {
//        System.out.println(new North().getId());
//        System.out.println(new NorthEast().getId());
//        System.out.println(new East().getId());
//        System.out.println(new SouthEast().getId());
//        System.out.println(new South().getId());
//        System.out.println(new SouthWest().getId());
//        System.out.println(new West().getId());

//        System.out.println(new NorthWest().getId());
//        System.out.println(new LastLocation().getId());

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

}
