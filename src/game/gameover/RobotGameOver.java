package game.gameover;

import check.CheckSquare;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;
import game.location.Location;
import printarray.PrintArray;

import javax.swing.*;

public class RobotGameOver implements IGameOver {

    Game game;
    RobotMemory robotMemory;
    int squareEdge;

    public RobotGameOver(Game game) {
        this.game = game;
        robotMemory = new RobotMemory(game);
        squareEdge = game.getModel().getGameSquares().length;
    }

    @Override
    public boolean isGameOver(Game game) {
//        if (game.getPlayer().getLocation().getY() > 4) {
//            JOptionPane.showMessageDialog(null, " !!! player location : " + game.getPlayer().getLocation());
//        }

        if (//isThereAnyAvaiableSquareInVisitedArea(game) == false &&
                isRobotFinishedAllLocations() &&
                        allDirectionsAreVisitedAtStep1()

        ) {//isAllWaysToBackDone(game) == true
//            System.out.println("isThereAnyAvaiableSquareInVisitedArea(game) : "+isThereAnyAvaiableSquareInVisitedArea(game));
//            JOptionPane.showMessageDialog(null, "AAAAAAAAAAA");
//            new PrintArray().printMultipleArray(game.getModel().getGameSquares());
//            new PrintArray().printMultipleArrayBoolean(game.getModel().getVisitedAreas());
//            System.out.println(" && allDirectionsAreVisitedAtStep1()  :" + allDirectionsAreVisitedAtStep1());
//            System.out.println(getClass().getSimpleName() + " OYUN BITMISTIRRR");
//            JOptionPane.showMessageDialog(null,"BBBBBBBBBBBB");
            return true;
        }
     /*   System.out.println("isThereAnyAvaiableSquareInVisitedArea(game) : "+isThereAnyAvaiableSquareInVisitedArea(game));
        System.out.println("isRobotInTheLastLocation()  : "+ isRobotInTheLastLocation());
        System.out.println(" && allDirectionsAreVisitedAtStep1()  :"+allDirectionsAreVisitedAtStep1());*/

        return false;
    }


    boolean isRobotFinishedAllLocations() {
        Location robotLocation = game.getPlayer().getLocation();

        if (robotLocation.getX() == squareEdge-1 &&
                robotLocation.getY() == squareEdge-1) {
            return true;
        }
//        System.out.println("robotLocation   X : " + robotLocation.getX() + " Y : " + robotLocation.getY() +" squareEdge : "+squareEdge);
        return false;

    }

    boolean isRobotInTheLastLocation() {
        if (game.getPlayer().getLocation().getX() == (squareEdge - 1) &&
                game.getPlayer().getLocation().getY() == (squareEdge - 1)) {
            return true;
        }
        return false;
    }

    boolean allDirectionsAreVisitedAtStep1() { // dogru olursa oyun biter
        if (game.getPlayer().getStep() == 1) {
//            new PrintArray().printMultipleArray(game.getModel().getGameSquares());
//            System.out.println("Muhtemelen robot son konumda ve bosta visitedDirection var mi ona bakiyor : gelen cevap  " + (new CheckSquare().isAnySquareAvailableInVisitedDirection(game)));
//            new PrintArray().printMultipleArrayBoolean(game.getPlayer().getVisitedDirections());
            return !(new CheckSquare().isAnySquareAvailableInVisitedDirection(game));
        }
        return false;

    }


    boolean isThereAnyAvaiableSquareInVisitedArea(Game game) {
        /*new PrintArray().printMultipleArrayBoolean(robotMemory.getVisitedDirections());
        new Sleep().sleep(1_000);*/

        return new CheckSquare().isAnySquareAvailableInVisitedArea(game);
    }
/*        CheckSquare checkSquare = new CheckSquare();
        if(checkSquare.checkAllVisitedAreaThatIsThereAnyLocationThatIsNotSealedYet(game))

        for (int i = 0; i < game.getModel().getVisitedAreas().length; i++) {
            for (int j = 0; j < game.getModel().getVisitedAreas()[i].length; j++) {
                if (game.getModel().getVisitedAreas()[i][j] == false) {
                    return false;

                }
            }
        }
        return true;
    }*/

}
