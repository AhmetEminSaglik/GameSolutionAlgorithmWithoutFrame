/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gamerepo.updategamemodel;

import game.gamerepo.GameModel;

/**
 *
 * @author ahmet
 */
public class UpdateForMovedBack extends UpdateValuesInGameModel {

    public UpdateForMovedBack(GameModel gameModel) {
        super(gameModel);
    }

    @Override
    public void updatePlayerStepValue() {
        gameModel.getPlayer().decreaseStep();
    }

    @Override
    boolean isMovedForward() {
        return false;
    }

}
