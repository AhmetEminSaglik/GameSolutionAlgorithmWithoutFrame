package check;

import game.Game;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import printarray.PrintArray;

import javax.swing.*;
import java.util.ArrayList;

public class CheckSquare extends BaseCheck {

    public boolean isSquareFreeFromVisitedArea(Game game, int directionIndex) {

        if (isIndexsSuitableForArray(game, directionIndex)) {
            //Compass compass = new DirectionCompass(); ;
            Location location = new DirectionLocation().getLocationFromCompass(getCompass(), directionIndex);

            if (game.getModel().getVisitedAreas()[game.getPlayer().getLocation().getX()
                    + location.getX()][game.getPlayer().getLocation().getY() + location.getY()] == false) {
                return true;
            }
        }
        return false;

    }

    public boolean isSquareFreeFromVisitedDirection(Game game, int directionIndex) {

        if (isIndexsSuitableForArray(game, directionIndex)) {
            if (game.getPlayer().getVisitedDirections()[game.getPlayer().getStep()][directionIndex] == false) {
                return true;
            }
        }
        return false;
    }

    boolean isIndexsSuitableForArray(Game game, int choose) {
        //System.out.println("| Compass :::  " +getCompass());
        validation.setCompass(getCompass()); // ==>>> HATA BURADAN KAYNAKLANIYOR
        return validation.isInputValidForArray(game, choose);
    }


    public boolean isAnySquareAvailableInVisitedDirection(Game game) {
        ArrayList<DirectionLocation> locationList = new LocationsList().getList();

        for (int i = 0; i < locationList.size() - 1; i++) {

            if (isSquareFreeFromVisitedDirection(game, locationList.get(i).getId()) == true) {
                return true;
            }

        }
        return false;
    }

}
