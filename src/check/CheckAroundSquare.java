package check;

import game.gamerepo.GameModel;
import compass.Compass;
import compass.DirectionCompass;
import java.util.ArrayList;
import game.location.Location;
import game.location.LocationsList;

public class CheckAroundSquare {

    Compass compass = new DirectionCompass();
    CheckSquare checkSquare = new CheckSquare();
    ArrayList<Location> locationList = new LocationsList().getList();

    public int getNumberOfHowManySquaresAreAvailable(GameModel gameModel) {

        int availableDirectionCounter = 0;

        for (int i = 0; i < locationList.size(); i++) {
            if (isLocationAvailable(gameModel, locationList.get(i).getId())) {

                availableDirectionCounter++;
            }
        }
        return availableDirectionCounter;
    }

    public boolean isThereAnyAvailableSquare(GameModel gameModel) {

        checkSquare.setCompass(compass); // bu normalde isLocationAvailable() fonksiyonunun ilk satiriydi

        for (int i = 0; i < locationList.size(); i++) {

            if (isLocationAvailable(gameModel, locationList.get(i).getId())) {
                // System.out.println("Musait yon : " + locationList.get(i).getClass().getSimpleName());
                return true;
            }
        }
        return false;
    }

    boolean isLocationAvailable(GameModel gameModel, int directionIndex) {

        return checkSquare.isSquareAvailableToMoveOnIt(gameModel, directionIndex);
    }

}
