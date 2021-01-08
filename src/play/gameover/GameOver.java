package play.gameover;

import Game.GameModel;
import play.CheckAroundSquare;

public class GameOver {

    public boolean isGameOver(GameModel gameModel) {
        if (new CheckAroundSquare().isThereAnyAvailableSquare(gameModel)) {
            return false;
        }
        return true;

    }
}
