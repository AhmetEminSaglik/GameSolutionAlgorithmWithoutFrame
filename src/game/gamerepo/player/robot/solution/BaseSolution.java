/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gamerepo.player.robot.solution;

import check.CheckSquare;
import compass.Compass;
import compass.DirectionCompass;
import game.Game;

/**
 *
 * @author ahmet
 */
public abstract class BaseSolution {

    final Compass compass = new DirectionCompass();
    CheckSquare checkSquare = new CheckSquare();

    public abstract int getLocationInput(Game game);

    public BaseSolution() {
        checkSquare.setCompass(compass);
    }

}
