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

    void fillList(Compass compass) {

        list.add(getDirectionLocationWithEmbeddCompass(new North(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new NorthEast(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new East(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new SouthEast(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new South(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new SouthWest(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new West(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new NorthWest(), compass));
        list.add(getDirectionLocationWithEmbeddCompass(new LastLocation(), compass));

    }

    DirectionLocation getDirectionLocationWithEmbeddCompass(DirectionLocation directionLocation, Compass compass) {
        directionLocation.setCompass(compass);
        return directionLocation;

    }


    public ArrayList<DirectionLocation> getListOfLocationsAccordingToPlayerCompass(Compass compass) {
        if (list.size() == 0) {
            fillList(compass);
        }
        return list;
    }

    public DirectionLocation getLastLocation(Compass compass) {
        DirectionLocation lastLocation = new LastLocation();
        lastLocation.setCompass(compass);
        return lastLocation;
    }

}
