package check;

import game.Game;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import printarray.PrintArray;

import javax.swing.*;
import java.util.ArrayList;

public class CheckSquare extends BaseCheck {

    public boolean isSquareFreeFromVisitedArea(Game game, int directionIndex) {

        if (isIndexsSuitableForArray(game, directionIndex)) {
            //Compass compass = new DirectionCompass(); ;
            Location location = new DirectionLocation().getLocationFromCompass(getCompass(), directionIndex); // switchDirection.choseDirection(input);
            //  System.out.println(">>>>>>>>> XXXXXXXXXXX  >>>>>>>>  : " + game.getPlayer().getLocation().getX() + "  /  location.getX() " + location.getX());
            if (game.getModel().getVisitedAreas()[game.getPlayer().getLocation().getX()
                    + location.getX()][game.getPlayer().getLocation().getY() + location.getY()] == false) {
//                System.out.println("VisitedAreas()[" + (game.getPlayer().getLocation().getX() + location.getX()) + "][" + (game.getPlayer().getLocation().getY() + location.getY()) + "] : "
//                        + (game.getModel().getVisitedAreas()[game.getPlayer().getLocation().getX()
//                        + location.getX()][game.getPlayer().getLocation().getY() + location.getY()]));

//                System.out.println(getClass().getSimpleName() + ":::::::: || \n player x : " + game.getPlayer().getLocation().getX());
//                System.out.println(" player y : " + game.getPlayer().getLocation().getY());
//                System.out.println(" location x : " + location.getX());
//                System.out.println(" location y : " + location.getY());

                return true;
            }
        }
        return false;

    }

    public boolean isSquareFreeFromVisitedDirection(Game game, int directionIndex) {

        if (isIndexsSuitableForArray(game, directionIndex)) {
            if (game.getPlayer().getVisitedDirections()[game.getPlayer().getStep()][directionIndex] == false) {
//            System.out.println("game.getPlayer().getVisitedDirections()["+game.getPlayer().getStep()+"]["+directionIndex+"] : "+game.getPlayer().getVisitedDirections()[game.getPlayer().getStep()][directionIndex]);
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

    public boolean isAnySquareAvailableInVisitedArea(Game game) {
        int squareEdge = game.getModel().getVisitedAreas().length;
        for (int i = 0; i < squareEdge; i++) {
            for (int j = 0; j < squareEdge; j++) {
                if (game.getModel().getVisitedAreas()[i][j] == false) {
                    System.out.println(" UnVisited  Area : [" + i + "][" + j + "] : " + game.getModel().getVisitedAreas()[i][j]);
//                    new PrintArray().printMultipleArrayBoolean(game.getModel().getVisitedAreas());
                    new PrintArray().printMultipleArray(game.getModel().getGameSquares());
                    return true;

                }
            }
        }
        return false;
    }

    public boolean isAnySquareAvailableInVisitedDirection(Game game) {
        ArrayList<DirectionLocation> locationList = new LocationsList().getList();

        for (int i = 0; i < locationList.size() - 1; i++) {

            if (isSquareFreeFromVisitedDirection(game, locationList.get(i).getId()) == true) {
//                JOptionPane.showMessageDialog(null,getClass().getSimpleName()+"Visited Direction :  "+locationList.get(i).toString()+"  IS NOT VISITED YET ");
                return true;
            }

        }
        return false;
    }

}
