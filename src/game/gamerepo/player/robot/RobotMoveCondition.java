package game.gamerepo.player.robot;

import game.gamerepo.GameModel;
import game.gamerepo.player.Player;

public abstract class RobotMoveCondition implements IRobotMove {

    GameModel gameModel;
    Player player;

    public RobotMoveCondition(GameModel gameModel) {
        this.gameModel = gameModel;
       }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

}
