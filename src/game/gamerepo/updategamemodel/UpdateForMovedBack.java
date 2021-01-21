package game.gamerepo.updategamemodel;

import game.Game;

public class UpdateForMovedBack extends UpdateValuesInGameModel {

    public UpdateForMovedBack(Game game) {
        super(game);
    }

    @Override
    public void updatePlayerStepValue() {
        game.getPlayer().decreaseStep();
    }

    @Override
    boolean isMovedForward() {
        return false;
    }

}
