package check;

import game.gamerepo.GameModel;
import compass.Compass;
import game.location.Location;
import validation.Validation;

public class CheckSquare {

    Validation validation = new Validation();
    Compass compass;

    public boolean isSquareAvailableToMoveOnIt(GameModel gameModel, int directionIndex) {
        if (isArraySuitableForIndexs(gameModel, directionIndex)) {
            //Compass compass = new DirectionCompass();

            Location location = Location.getLocationFromCompass(compass, directionIndex); // switchDirection.choseDirection(input);

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

        validation.setCompass(compass); // ==>>> HATA BURADAN KAYNAKLANIYOR
        return validation.isInputValidForArray(gameModel, choose);
    }

    public Compass getCompass() {
        return compass;
    }

    public void setCompass(Compass compass) {
        this.compass = compass;
    }

}
