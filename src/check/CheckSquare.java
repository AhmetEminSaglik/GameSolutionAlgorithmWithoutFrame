package check;

import game.Game;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import printarray.PrintArray;

import javax.swing.*;
import java.util.ArrayList;

public class CheckSquare extends BaseCheck {

    public boolean isSquareFreeFromVisitedArea(Game game, Location currentProcessLocation, int directionIndex) {

        if (isIndexsSuitableForArray(game,currentProcessLocation, directionIndex)) {
            //Compass compass = new DirectionCompass(); ;
            Location location = new DirectionLocation().getLocationFromCompass(getCompass(), directionIndex);

            if (!game.getModel().getVisitedAreas()[currentProcessLocation.getX()
                    + location.getX()][currentProcessLocation.getY() + location.getY()]) {
                return true;
            }
        }
        return false;

    }

    public boolean isSquareFreeFromVisitedDirection(Game game, Location currentProcessLocation, int directionIndex) {

        if (isIndexsSuitableForArray(game, currentProcessLocation, directionIndex)) {
//            System.out.println("Step " +game.getPlayer().getStep()+" / directionIndex : "+directionIndex);
            if (game.getPlayer().getVisitedDirections()[game.getPlayer().getStep()][directionIndex] == false) {
                return true;
            }
        }
        return false;
    }

    boolean isIndexsSuitableForArray(Game game, Location currentProcessLocation, int choose) {
        //System.out.println("| Compass :::  " +getCompass());
        validation.setCompass(getCompass()); // ==>>> HATA BURADAN KAYNAKLANIYOR
        return validation.isInputValidForArray(game, currentProcessLocation, choose);
    }


    public boolean isAnySquareAvailableInVisitedDirection(Game game, Location currentProcessLocation) {
        ArrayList<DirectionLocation> locationList = new LocationsList().getList();

        for (int i = 0; i < locationList.size() - 1; i++) {

            if (isSquareFreeFromVisitedDirection(game,currentProcessLocation, locationList.get(i).getId()) == true) {
                return true;
            }

        }
        return false;
    }

}
