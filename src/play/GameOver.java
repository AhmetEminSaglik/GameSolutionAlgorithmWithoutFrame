package play;

import Game.GameModel;

public class GameOver {

    public boolean isGameOver(GameModel gameModel) {
        if (new ControlAroundSquare().isThereAnyAvailableSquare(gameModel)) {
            return false;
        }
        return true;

    }
}
