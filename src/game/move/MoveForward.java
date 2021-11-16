package game.move;

import game.Game;
import game.gamerepo.updategamemodel.UpdateForMovedForward;

public class MoveForward extends Move {

    public MoveForward(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedForward(game);
    }

    @Override
    public void updateVisitedDirection() {
        updateValuesInGameModel.updateValueVisitedDirection(getDirectionLocation());
    }


    @Override
    public void updateBeforeStep() {
    }

    @Override
    public void updateAfterStep() {
        updatePlayerLocation();
        updateVisitedArea();
        updateVisitedDirection();
    }

      /* @Override
    public void updatePlayerLocation() {
        changePlayerLocation(getDirectionLocation());

    }*/
   /* public void changePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }*/

/*    @Override
    public void updatePlayerStepValue() {
        increasePlayerStepValue();
    }*/

    /*void increasePlayerStepValue() {
        updateValuesInGameModel.updatePlayerStepValue();
    }*/

}
