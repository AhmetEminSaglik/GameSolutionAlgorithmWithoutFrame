package check;

import compass.Compass;
import compass.DirectionCompass;
import game.Game;
import game.location.DirectionLocation;
import java.util.ArrayList;
import game.location.LocationsList;

public class CheckAroundSquare {

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

        checkSquare.setCompass(compass); // bu normalde isLocationAvailable() fonksiyonunun ilk satiriydi

        for (int i = 0; i < locationList.size(); i++) {

            if (isLocationAvailable(game, locationList.get(i).getId())) {
                // System.out.println("Musait yon : " + locationList.get(i).getClass().getSimpleName());
                return true;
            }
        }
        return false;
    }

    boolean isLocationAvailable(Game game, int directionIndex) {

        return checkSquare.isSquareAvailableToMoveOnIt(game, directionIndex);
    }

}
