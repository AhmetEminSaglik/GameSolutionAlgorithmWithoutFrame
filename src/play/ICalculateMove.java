package play;

import Game.GameModel;

public interface ICalculateMove {

    public boolean isItAvailableToMove(GameModel gameModel, int choose);

}
