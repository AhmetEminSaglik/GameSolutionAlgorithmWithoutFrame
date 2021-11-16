package game.play.input.robot;

import errormessage.ErrorMessage;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.play.input.BaseControlInput;
import game.play.input.person.IRobotInput;

public class RobotInput extends BaseControlInput implements IRobotInput {

    BaseSolution solution;

    public RobotInput(BaseSolution solution, Game game) {
        super(game);
        this.solution = solution;
    }

    @Override
    public int getInput(RobotMemory robotMemory) {
 
        return solution.getLocationInput(game, robotMemory);
    }

    @Override
    public boolean isInputSuitableToMoveForward(Game game, int choose) {
        ErrorMessage.appearFatalError(getClass(), "BURAYA GELDIIII /  burasi kullanilmiyor");
        return false;
    }

    @Override
    public boolean isInputSuitableToMoveBack(Game game, int choose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
