package move;

import Game.GameModel;
import location.Location;

public class MoveBack extends Move {

    public MoveBack(GameModel gameModel) {
        super(gameModel);
    }

    @Override
    public void move(Location location) { // geri adim at
    }

    @Override
    public boolean isItAvailableToMove(GameModel gameModel, int choose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
