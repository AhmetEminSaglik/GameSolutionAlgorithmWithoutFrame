package game.gamerepo;

import game.Game;
import game.gamerepo.player.Player;

public class FillGameSquare {

    Game game;
    Player player;

    public FillGameSquare(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    public void printStepInGameSquare() {
        game.getModel().getGameSquares()[player.getLocation().getX()][player.getLocation().getY()] = player.getStep();
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
