package game.gamerepo.player.robot.solution;

import errormessage.ErrorMessage;
import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.RobotMemory;
import game.location.DirectionLocation;
import game.location.LocationsList;
import sleep.Sleep;

import java.util.ArrayList;

public class FirstSolution extends BaseSolution {

    @Override
    public int getLocationInput(Game game, RobotMemory robotMemory) {
        ArrayList<DirectionLocation> locationsList = new LocationsList().getList();
        // printSealedArea(robotMemory);
        //System.out.println(" IF KONTROLU game.getPlayer().getStep() : " + game.getPlayer().getStep());
//        new Sleep().sleep(3000);
        if (isStepAvailableToMoveForward(game.getPlayer().getStep(), (int) Math.pow(game.getModel().getGameSquares().length, 2)) == true) {
            for (int i = 0; i < locationsList.size() - 1; i++) {

                if (isSquareAvailableToMoveOnIt(game, locationsList.get(i), robotMemory)) {
                    return locationsList.get(i).getId();
                }
           /* if (checkSquare.isSquareFreeFromVisitedArea(game, locationsList.get(i).getId())
                    && !robotMemory.getVisitedDirections()[game.getPlayer().getStep()][locationsList.get(i).getId()]) {
                System.out.println("Robot's movation direction : " + locationsList.get(i).getClass().getSimpleName()
                        + " " + locationsList.get(i).getId());
                //new Sleep().sleep();
                return locationsList.get(i).getId();

            } */
//            else {
//                System.out.println(" 1 -) " + checkSquare.isSquareFreeFromVisitedArea(game, locationsList.get(i).getId()));
//                System.out.println(" 2 -) " + !robotMemory.getVisitedDirections()[game.getPlayer().getStep()][locationsList.get(i).getId()]);
//
//                // System.out.println("EN SON GIRIDIG ELSEYE BAKCAMMMMMMMMMMMMMMMMMMMM");
//            }
                //    System.out.println(" location index : " + locationsList.get(i).getId());
            }
        }
//        ErrorMessage.appearClassicError(this.getClass(), "HERE MAY HAVE PROBLEM  gonna sleep 3 secs");
//        new Sleep().sleep(3_000);

        //       ErrorMessage.appearFatalError(getClass(), "burayi doldurmadim");
        //new Sleep().sleep(1000);
        return locationsList.get(locationsList.size() - 1).getId();

    }

    boolean isStepAvailableToMoveForward(int step, int maxSquareValue) {
        if (step < maxSquareValue)
            return true;
        return false;
    }

    void printSealedArea(Robot robot) {
        for (int i = 0; i </* robotMemory.*/robot.getVisitedDirections().length; i++) {
            for (int j = 0; j < /*robotMemory.*/robot.getVisitedDirections()[0].length; j++) {
                if (/*robotMemory.*/robot.getVisitedDirections()[i][j] == true) {
                    System.out.println("getVisitedDirections()[" + i + "][" + j + "] : " + robot.getVisitedDirections()[i][j]);
                }
            }
        }
        //   new Sleep().sleep(3000);
    }

}
