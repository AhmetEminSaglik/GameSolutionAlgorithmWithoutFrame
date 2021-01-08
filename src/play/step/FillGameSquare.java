package play.step;

import Game.GameModel;
import Game.player.Player;
import utility.ConvertVariable;

public class FillGameSquare {

    GameModel gameModel;
    Player player;

    public FillGameSquare(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();
    }

    public void printStepInGameSquare() {
        gameModel.getGameSquares()[player.getLocationX()][player.getLocationY()] = printDesign();
    }

    String printDesign() {

        if (player.getStep() / 100 > 0) {
            return "|" + ConvertVariable.intToString(player.getStep()) + "|";
        } else if (player.getStep() / 10 > 0) {
            return "|" + ConvertVariable.intToString(player.getStep()) + " |";
        } else {

            return "| " + ConvertVariable.intToString(player.getStep()) + " |";

        }
    }

}
