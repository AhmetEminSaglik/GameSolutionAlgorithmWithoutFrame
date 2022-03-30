package game.play.input.robot;

import errormessage.ErrorMessage;
import game.Game;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.play.input.BaseControlInput;

public class RobotInput extends BaseControlInput {

    BaseSolution solution;

    public RobotInput(BaseSolution solution, Game game) {
        super(game);
        this.solution = solution;
    }

    @Override
    public int getInput() {
        return solution.getLocationInput(game);
    }

   /* @Override
    public boolean isInputSuitableToMoveForward(Game game, int choose) {
        ErrorMessage.appearFatalError(getClass(), "BURAYA GELDIIII /  burasi kullanilmiyor");
        return false;
    }

    @Override
    public boolean isInputSuitableToMoveBack(Game game, int choose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
