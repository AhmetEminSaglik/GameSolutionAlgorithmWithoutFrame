package game.gamerepo.player.robot.solution;

import check.CheckSquare;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ahmet
 */
public abstract class BaseSolution {

    CheckSquare checkSquare = new CheckSquare();

    public abstract int getLocationInput(Game game, RobotMemory robotMemory);

}
