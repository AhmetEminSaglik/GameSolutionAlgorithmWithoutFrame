package game.play.input;

import SILINECEK.Yapilacaklar;
import game.Game;
import game.gamerepo.player.robot.solution.BaseSolution;

public class RobotInput extends BaseControlInput {

    BaseSolution solution;

    public RobotInput(BaseSolution solution, Game game) {
        super(game);
        this.solution = solution;
    }

    @Override
    public int getInput() { // visited area , visited direction
        Yapilacaklar.stickNote("Robotun ilerlemesi musait olan alanlar hesaplanip input seklinde alinacaktir\n"
                + " once bos alana ardindan gidilmemis alana gore hesaplanacaktir.");
        return solution.getLocationInput(game);
    }

    @Override
    boolean isInputSuitableToMoveForward(Game game, int choose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean isInputSuitableToMoveBack(Game game, int choose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
