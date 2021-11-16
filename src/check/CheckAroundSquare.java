package check;

import compass.Compass;
import compass.DirectionCompass;
import game.Game;
import game.location.DirectionLocation;

import java.util.ArrayList;

import game.location.LocationsList;

public class CheckAroundSquare extends BaseCheck {

    Compass compass = new DirectionCompass();
    CheckSquare checkSquare = new CheckSquare();
    ArrayList<DirectionLocation> locationList = new LocationsList().getList();

    public int getNumberOfHowManySquaresAreAvailable(Game game) {

        int availableDirectionCounter = 0;

        for (int i = 0; i < locationList.size(); i++) {
            if (isLocationAvailable(game, locationList.get(i).getId())) {

                availableDirectionCounter++;
            }
        }
        return availableDirectionCounter;
    }

    public boolean isThereAnyAvailableSquare(Game game) {
        compass = game.getPlayer().getCompass();
        checkSquare.setCompass(compass);
        for (int i = 0; i < locationList.size(); i++) {
            if (isLocationAvailable(game, locationList.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    boolean isLocationAvailable(Game game, int directionIndex) {
            return checkSquare.isSquareFreeFromVisitedArea(game, directionIndex);
    }
}
