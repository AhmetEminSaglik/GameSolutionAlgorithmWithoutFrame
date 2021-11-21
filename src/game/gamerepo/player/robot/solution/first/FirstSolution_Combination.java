package game.gamerepo.player.robot.solution.first;

import game.Game;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.move.fundamental.MoveBack;
import game.move.fundamental.MoveForward;

import java.util.ArrayList;

public class FirstSolution_Combination extends BaseSolution {


    public FirstSolution_Combination(Game game) {
        super(game);
    }

    @Override
    public int getLocationInput(Game game) {//, RobotMemory robotMemory
        ArrayList<DirectionLocation> locationsList = new LocationsList().getList();

//        if (isStepAvailableToMoveForward(game.getPlayer().getStep(), (int) Math.pow(game.getModel().getGameSquares().length, 2)) == true) {
        //yukaridaki if niye var bilmiyorum ama  simdilik dursun sonra ise yarayabilir
        Location playerLocation = checkSquare.getPlayerLocation(game);

        for (int i = 0; i < locationsList.size() - 1; i++) {

            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {//, robotMemory
                return locationsList.get(i).getId();
            }
        }
//        }
        return locationsList.get(locationsList.size() - 1).getId(); //LastLocation

    }

    @Override
    public void buildRobotMove() {
        setMoveForward(new MoveForward(getGame()));
        setMoveBack(new MoveBack(getGame()));
    }
/*

    boolean isStepAvailableToMoveForward(int step, int maxSquareValue) {
        if (step < maxSquareValue)
            return true;
        return false;
    }
*/

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
