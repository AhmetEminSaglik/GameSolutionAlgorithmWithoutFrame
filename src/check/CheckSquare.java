package check;

import game.Game;
import game.location.DirectionLocation;
import game.location.Location;

public class CheckSquare extends BaseCheck {

    public boolean isSquareFreeFromVisitedArea(Game game, int directionIndex) {

        if (isIndexsSuitableForArray(game, directionIndex)) {
            //Compass compass = new DirectionCompass(); ;
            Location location = new DirectionLocation().getLocationFromCompass(getCompass(), directionIndex); // switchDirection.choseDirection(input);
            //  System.out.println(">>>>>>>>> XXXXXXXXXXX  >>>>>>>>  : " + game.getPlayer().getLocation().getX() + "  /  location.getX() " + location.getX());
            if (game.getModel().getVisitedAreas()[game.getPlayer().getLocation().getX()
                    + location.getX()][game.getPlayer().getLocation().getY() + location.getY()] == false) {
                System.out.println("VisitedAreas()[" + (game.getPlayer().getLocation().getX() + location.getX()) + "][" + (game.getPlayer().getLocation().getY() + location.getY()) + "] : "
                        + (game.getModel().getVisitedAreas()[game.getPlayer().getLocation().getX()
                        + location.getX()][game.getPlayer().getLocation().getY() + location.getY()]));

                System.out.println(getClass().getSimpleName() + ":::::::: || \n player x : " + game.getPlayer().getLocation().getX());
                System.out.println(" player y : " + game.getPlayer().getLocation().getY());
                System.out.println(" location x : " + location.getX());
                System.out.println(" location y : " + location.getY());

                return true;
            }
        }
        return false;

    }

    public boolean isSquareFreeFromVisitedDirection(Game game, int directionIndex) {
        if (game.getPlayer().getVisitedDirections()[game.getPlayer().getStep()][directionIndex] == true) {
            return false;
        }
        return true;
    }

    boolean isIndexsSuitableForArray(Game game, int choose) {
        //System.out.println("| Compass :::  " +getCompass());
        validation.setCompass(getCompass()); // ==>>> HATA BURADAN KAYNAKLANIYOR
        return validation.isInputValidForArray(game, choose);
    }

}
