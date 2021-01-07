package play;

import Game.GameModel;
import compass.Compass;
import compass.DirectionCompass;
import java.util.ArrayList;
import location.Location;

public class ControlAroundSquare {

    Compass compass = new DirectionCompass();
    CheckSquare checkSquare = new CheckSquare();

    ArrayList<Location> locationList = new LocationsList().getList();

    public int getNumberOfHowManySquaresAreAvailable(GameModel gameModel) {

        int availableDirectionCounter = 0;

        for (int i = 0; i < locationList.size(); i++) {
            if (isLocationAvailable(gameModel, locationList.get(i).getId())) {
                //        System.out.println("UYGUN >>>> " + locationList.get(i).getClass().getSimpleName());

                availableDirectionCounter++;
            }
        }
        return availableDirectionCounter;
    }

    public boolean isThereAnyAvailableSquare(GameModel gameModel) {
        System.out.println("MUSAIT YON SAYISI " + getNumberOfHowManySquaresAreAvailable(gameModel));
        if (getNumberOfHowManySquaresAreAvailable(gameModel) > 0) {
            return true;
        }
        return false;
    }

    boolean isLocationAvailable(GameModel gameModel, int directionIndex) {
        checkSquare.setCompass(compass);
        //  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> GameOver dan geldik compass : " + compass.getClass().getSimpleName());
        return checkSquare.isSquareAvailableToMoveOnIt(gameModel, directionIndex);
    }

}
