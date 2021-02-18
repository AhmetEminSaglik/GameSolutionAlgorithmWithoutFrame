package game.gameover;

import game.Game;
import game.gamerepo.player.robot.RobotMemory;

public class RobotGameOver implements IGameOver {

    Game game;
    RobotMemory robotMemory;

    public RobotGameOver(Game game) {
        this.game = game;
        robotMemory = new RobotMemory(game);
    }

    @Override
    public boolean isGameOver(Game game) {

        if (isWholeSquaresVisited() == true) {
            return true;
        }

        return false;
    }

    boolean isWholeSquaresVisited() {
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
