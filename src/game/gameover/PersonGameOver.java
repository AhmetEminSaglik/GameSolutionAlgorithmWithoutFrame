package game.gameover;

import check.CheckAroundSquare;
import game.Game;

public class PersonGameOver implements IGameOver {

    @Override
    public boolean isGameOver(Game game) {
        if (new CheckAroundSquare().isThereAnyAvailableSquare(game)) {
            return false;
        }
         return true;
    }

}
