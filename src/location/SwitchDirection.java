package location;

import compass.Compass;
import compass.DirectionCompass;
import errormessage.ClassicErrorMessage;
import errormessage.FatalErrorMessage;
import java.util.ArrayList;
import location.direction.South;
import location.direction.East;
import location.direction.North;
import location.direction.West;
import location.direction.NorthEast;
import location.direction.NorthWest;
import location.direction.SouthWest;
import location.direction.SouthEast;

public class SwitchDirection {

    Compass compass;

    public SwitchDirection(Compass compass) {
        this.compass = compass;
    }

    public Location choseDirection(int value) {
        //  System.out.println("Compass : " + compass.getClass().getSimpleName());
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
        ArrayList<Integer> list = getLocationList();

        new ClassicErrorMessage().showMessage(" compas  : " + compass.getClass().getSimpleName() + "  DEGER SECILEMEDI " + value);
        for (Integer location : list) {
            System.out.println(location);
        }
        /*  switch (value) {
            case NORTH_Move_Int:
            case compass.getNORTH():
                return new North();

            case NORTH_EAST_Move_Int:
                return new NorthEast();

            case EAST_Move_Int:
                return new East();

            case SOUTH_EAST_Move_Int:
                return new SouthEast();

            case SOUTH_Move_Int:
                return new South();

            case SOUTH_WEST_Move_Int:
                return new SouthWest();

            case WEST_Move_Int:
                return new West();

            case NORTH_WEST_Move_Int:
                return new NorthWest();
            default:
                new ClassicErrorMessage().showMessage("Unknown option...   returned  null");

        }*/

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
