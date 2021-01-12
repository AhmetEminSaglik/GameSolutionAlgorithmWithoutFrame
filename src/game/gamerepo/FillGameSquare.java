package game.gamerepo;

import game.gamerepo.GameModel;
import game.gamerepo.player.Player;

public class FillGameSquare {

    GameModel gameModel;
    Player player;

    public FillGameSquare(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();
    }

    public void printStepInGameSquare() {
        gameModel.getGameSquares()[player.getLocationX()][player.getLocationY()] = player.getStep();
        //ConvertVariable.intToString(player.getStep());
    }

    /* String printDesign() {

        if (player.getStep() / 100 > 0) {
            return "|" + ConvertVariable.intToString(player.getStep()) + "|";
        } else if (player.getStep() / 10 > 0) {
            return "|" + ConvertVariable.intToString(player.getStep()) + " |";
        } else {

            return "| " + ConvertVariable.intToString(player.getStep()) + " |";

        }
    }*/
}
