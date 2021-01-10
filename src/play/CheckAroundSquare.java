package play;

import Game.GameModel;
import compass.Compass;
import compass.DirectionCompass;
import java.util.ArrayList;
import location.Location;

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
        /*if (getNumberOfHowManySquaresAreAvailable(gameModel) > 0) {

            return true;
        }*/
        for (int i = 0; i < locationList.size(); i++) {

            if (isLocationAvailable(gameModel, locationList.get(i).getId())) {
                // System.out.println("Musait yon : " + locationList.get(i).getClass().getSimpleName());
                return true;
            }
        }
        return false;
    }

    boolean isLocationAvailable(GameModel gameModel, int directionIndex) {

        checkSquare.setCompass(compass);

        return checkSquare.isSquareAvailableToMoveOnIt(gameModel, directionIndex);
    }

}
