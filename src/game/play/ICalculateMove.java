package game.play;

import game.gamerepo.GameModel;

public interface ICalculateMove {

    public boolean isItAvailableToMove(GameModel gameModel, int choose);

}
