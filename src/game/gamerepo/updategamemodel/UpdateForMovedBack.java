/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gamerepo.updategamemodel;

import game.Game;

/**
 *
 * @author ahmet
 */
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
