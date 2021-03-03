package game.location;

import compass.Compass;
import compass.DirectionCompass;
import errormessage.ErrorMessage;
import java.util.ArrayList;
import game.location.direction.South;
import game.location.direction.East;
import game.location.direction.LastLocation;
import game.location.direction.North;
import game.location.direction.West;
import game.location.direction.NorthEast;
import game.location.direction.NorthWest;
import game.location.direction.SouthWest;
import game.location.direction.SouthEast;

public class SwitchDirection {

    Compass compass;

    public SwitchDirection(Compass compass) {
//        System.out.println(" 1 11  compass : " + compass);
//        ErrorMessage.appearFatalError(getClass(), "\nBURADA  COMPASS GONDERILIYOR ANCAK 2. DEFA BU CLASSIN FONKSIYONU KULLANILDIGINDA \n"
//                + " NULL OLARAK DONUYOR COMPASS");
        this.compass = compass;
    }

    public DirectionLocation choseDirection(int value) {
        //System.out.println("int value :: "+value);

        if (compass.getNorth() == value) {
            return new North();
        }
        if (compass.getNorthEast() == value) {
            return new NorthEast();
        }
        if (compass.getEast() == value) {
            return new East();
        }
        if (compass.getSouthEast() == value) {
            return new SouthEast();
        }
        if (compass.getSouth() == value) {
            return new South();
        }
        if (compass.getSouthWest() == value) {
            return new SouthWest();
        }
        if (compass.getWest() == value) {
            return new West();
        }
        if (compass.getNorthWest() == value) {
            return new NorthWest();
        }
        if (compass.getLastLocation() == value) {
            return new LastLocation();
        }

        ArrayList<Integer> list = getLocationList();
        ErrorMessage.appearClassicError(getClass(), " compass  : " + compass.getClass().getSimpleName() + " -> Unknow Option  : " + value);

        return null;
    }

    public void updateCompass(Compass compass) {
        this.compass = compass;

    }

    ArrayList<Integer> getLocationList() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(new DirectionCompass().getNorth());
        list.add(new DirectionCompass().getNorthEast());
        list.add(new DirectionCompass().getEast());
        list.add(new DirectionCompass().getSouthEast());
        list.add(new DirectionCompass().getSouth());
        list.add(new DirectionCompass().getSouthWest());
        list.add(new DirectionCompass().getWest());
        list.add(new DirectionCompass().getNorthWest());
        return list;
    }
}
