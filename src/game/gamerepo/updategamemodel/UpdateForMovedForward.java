package game.gamerepo.updategamemodel;

import game.gamerepo.GameModel;

public class UpdateForMovedForward extends UpdateValuesInGameModel {

    public UpdateForMovedForward(GameModel gameModel) {
        super(gameModel);
    }

    @Override
    public void updatePlayerStepValue() {
        gameModel.getPlayer().increaseStep();
    }

    /* @Override
    public void changePlayerLocation(Location location) {
        movePlayer.changePlayerLocation(location);
    }*/
    @Override
    boolean isMovedForward() {
        return true;
    }

//    @Override
//    public void changeVisitedDirection(Location location) {
//        super.changeVisitedDirection(location); //To change body of generated methods, choose Tools | Templates.
//
//    }

}
