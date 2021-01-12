package game.gameover;

import game.gamerepo.GameModel;
import game.play.CheckAroundSquare;

public class GameOver {

    public boolean isGameOver(GameModel gameModel) {
        if (new CheckAroundSquare().isThereAnyAvailableSquare(gameModel)) {
            return false;
        }
        return true;

    }
}
