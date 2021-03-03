package game.gamerepo.player.robot.solution;

import check.CheckSquare;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;
 
public abstract class BaseSolution {

    CheckSquare checkSquare = new CheckSquare();

    public abstract int getLocationInput(Game game, RobotMemory robotMemory);

}
