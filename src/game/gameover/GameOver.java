package game.gameover;

import check.CheckAroundSquare;
import game.Game;

public class GameOver {

    public boolean isGameOver(Game game) {
        if (new CheckAroundSquare().isThereAnyAvailableSquare(game)) {
            return false;
        }
        return true;

    }
}
