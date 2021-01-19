package check;

import game.gamerepo.GameModel;
import game.location.Location;

public class CheckSquare extends BaseCheck {

    public boolean isSquareAvailableToMoveOnIt(GameModel gameModel, int directionIndex) {
        if (isArraySuitableForIndexs(gameModel, directionIndex)) {
            //Compass compass = new DirectionCompass();

            Location location = Location.getLocationFromCompass(getCompass(), directionIndex); // switchDirection.choseDirection(input);

            if (gameModel.getVisitedAreas()[gameModel.getPlayer().getLocationX() + location.getX()][gameModel.getPlayer().getLocationY() + location.getY()] == false) {
                return true;
            }
        }
        return false;

    }

    void print(String text, int value) {
        System.out.println(text + " : " + value);
    }

    boolean isArraySuitableForIndexs(GameModel gameModel, int choose) {

        validation.setCompass(getCompass()); // ==>>> HATA BURADAN KAYNAKLANIYOR
        return validation.isInputValidForArray(gameModel, choose);
    }

}
