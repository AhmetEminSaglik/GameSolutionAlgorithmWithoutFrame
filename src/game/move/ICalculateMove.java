package game.move;

import game.gamerepo.Model;

public interface ICalculateMove {

    public boolean isItAvailableToMove(Model gameModel, int choose);

}
