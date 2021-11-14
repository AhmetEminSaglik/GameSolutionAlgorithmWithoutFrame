package game.gameover;

import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.RobotMemory;
import printarray.PrintArray;
import sleep.Sleep;

public class RobotGameOver implements IGameOver {

    Game game;
    RobotMemory robotMemory;

    public RobotGameOver(Game game) {
        this.game = game;
        robotMemory = new RobotMemory(game);
    }

    @Override
    public boolean isGameOver(Game game) {

        if (isWholeSquaresVisited(game) == true
                && isAllWaysToBackDone(game) == true) {
            System.out.println(getClass().getSimpleName() + " OYUN BITMISTIRRR");
            return true;
        }

        return false;
    }

    boolean isAllWaysToBackDone(Game game) {
//        System.out.println(getClass().getSimpleName() + " GERI ADIMLAR BITTI  MI KONTROLU");
//        new Sleep().sleep(3000);

        if (/*game.getPlayer().getLocation().getX() == game.getModel().getGameSquares().length &&
                game.getPlayer().getLocation().getY() == game.getModel().getGameSquares().length &&*/
                game.getPlayer().getStep() == 1) {
//            System.out.println("ADIM SAYISI 1 E DONDU");
//            new Sleep().sleep(100_000);
            return true;
        }
        return false;
    }

    boolean isWholeSquaresVisited(Game game) {
        /*new PrintArray().printMultipleArrayBoolean(robotMemory.getVisitedDirections());
        new Sleep().sleep(1_000);*/
        for (int i = 0; i < game.getModel().getVisitedAreas().length; i++) {
            for (int j = 0; j < game.getModel().getVisitedAreas()[i].length; j++) {
                if (game.getModel().getVisitedAreas()[i][j] == false) {
                    return false;

                }
            }
        }
        return true;
    }

}
