package game.play.input.robot;

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

//    @Override
//    public int getInput() { // visited area , visited direction
//        Yapilacaklar.stickNote("Robotun ilerlemesi musait olan alanlar hesaplanip input seklinde alinacaktir\n"
//                + " once bos alana ardindan gidilmemis alana gore hesaplanacaktir.");
//        return solution.getLocationInput(game);
//    }
    @Override
    public boolean isInputSuitableToMoveForward(Game game, int choose) {

    }

    @Override
    public boolean isInputSuitableToMoveBack(Game game, int choose) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
