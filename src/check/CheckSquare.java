package check;

import game.Game;
import game.location.DirectionLocation;
import game.location.Location;

public class CheckSquare extends BaseCheck {

    public boolean isSquareAvailableToMoveOnIt(Game game, int directionIndex) {

        if (isIndexsSuitableForArray(game, directionIndex)) {
            //Compass compass = new DirectionCompass(); ;
            Location location = new DirectionLocation().getLocationFromCompass(getCompass(), directionIndex); // switchDirection.choseDirection(input);
          //  System.out.println(">>>>>>>>> XXXXXXXXXXX  >>>>>>>>  : " + game.getPlayer().getLocation().getX() + "  /  location.getX() " + location.getX());
            if (game.getModel().getVisitedAreas()[game.getPlayer().getLocation().getX()
                    + location.getX()][game.getPlayer().getLocation().getY() + location.getY()] == false) {
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

}
