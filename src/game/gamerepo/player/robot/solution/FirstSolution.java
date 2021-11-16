package game.gamerepo.player.robot.solution;

import game.Game;
import game.gamerepo.player.robot.RobotMemory;
import game.location.DirectionLocation;
import game.location.LocationsList;

import java.util.ArrayList;

public class FirstSolution extends BaseSolution {

    @Override
    public int getLocationInput(Game game, RobotMemory robotMemory) {
        ArrayList<DirectionLocation> locationsList = new LocationsList().getList();

        if (isStepAvailableToMoveForward(game.getPlayer().getStep(), (int) Math.pow(game.getModel().getGameSquares().length, 2)) == true) {
            for (int i = 0; i < locationsList.size() - 1; i++) {

                if (isSquareAvailableToMoveOnIt(game, locationsList.get(i), robotMemory)) {
                    return locationsList.get(i).getId();
                }
            }
        }
        return locationsList.get(locationsList.size() - 1).getId();

    }

    boolean isStepAvailableToMoveForward(int step, int maxSquareValue) {
        if (step < maxSquareValue)
            return true;
        return false;
    }

   /* void printSealedArea(Robot robot) {
        for (int i = 0; i <*//* robotMemory.*//*robot.getVisitedDirections().length; i++) {
            for (int j = 0; j < *//*robotMemory.*//*robot.getVisitedDirections()[0].length; j++) {
                if (*//*robotMemory.*//*robot.getVisitedDirections()[i][j] == true) {
                    System.out.println("getVisitedDirections()[" + i + "][" + j + "] : " + robot.getVisitedDirections()[i][j]);
                }
            }
        }
        //   new Sleep().sleep(3000);
    }*/

}
