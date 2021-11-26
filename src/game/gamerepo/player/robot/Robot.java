package game.gamerepo.player.robot;

import compass.Compass;
import compass.DirectionCompass;
import game.Game;
import game.gameover.RobotGameOver;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.DirectionLocation;
import game.play.PlayerMove;
import game.play.input.robot.RobotInput;
import game.rule.BaseGameRule;


public class Robot extends Player {

    RoadMemory roadMemory = new RoadMemory();
    private BaseSolution solution;

    public Robot(Game game, BaseSolution solution) {
        super(game);
        this.solution = solution;
        solution.buildRobotMove();
        playerMove = new PlayerMove(solution.getMoveForward(),solution.getMoveBack());
        setName(solution.getClass().getSimpleName()+"_"+game.getModel().getGameSquares());
    }

    @Override
    public Compass getCompass() {
        return new DirectionCompass();
    }

    @Override
    public int getInput(Game game) {
        return new RobotInput(solution, game).getInput();//getRobotMemory()
    }

    public BaseSolution getSolution() {
        return solution;
    }

    public void setSolution(BaseSolution solution) {
        this.solution = solution;
    }

   @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new RobotGameOver(getGame()));
        }
        return gameRule;
    }

    @Override
    public void updateVisitedDirection(boolean sealOrUnseal, int step, DirectionLocation location) {
        assert (getStep() > 1) : getClass().getName() + " >>> ADIM SAYUISI " + getStep() + " GELDI";
        getVisitedDirections()[step][location.getId()] = sealOrUnseal;
    }

    public RoadMemory getRoadMemory() {
        return roadMemory;
    }
}
