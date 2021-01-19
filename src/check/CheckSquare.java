package check;

import game.Game;
import game.location.Location;

public class CheckSquare extends BaseCheck {

    public boolean isSquareAvailableToMoveOnIt(Game game, int directionIndex) {
        if (isIndexsSuitableForArray(game, directionIndex)) {
            //Compass compass = new DirectionCompass();

            Location location = Location.getLocationFromCompass(getCompass(), directionIndex); // switchDirection.choseDirection(input);

            if (game.getModel().getVisitedAreas()[game.getPlayer().getLocationX() + location.getX()][game.getPlayer().getLocationY() + location.getY()] == false) {
                return true;
            }
        }
        return false;

    }

//    void print(String text, int value) {
//        System.out.println(text + " : " + value);
//    }
    boolean isIndexsSuitableForArray(Game game, int choose) {

        validation.setCompass(getCompass()); // ==>>> HATA BURADAN KAYNAKLANIYOR
        return validation.isInputValidForArray(game, choose);
    }

}
