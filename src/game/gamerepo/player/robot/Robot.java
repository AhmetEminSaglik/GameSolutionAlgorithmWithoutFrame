package game.gamerepo.player.robot;

import compass.Compass;
import compass.DirectionCompass;
import errormessage.ErrorMessage;
import game.Game;
import game.gameover.RobotGameOver;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.play.input.robot.RobotInput;
import game.rule.BaseGameRule;

public class Robot extends Player {

    private RobotMemory robotMemory;
    private Game game;
    private BaseSolution solution;

    public Robot(Game game, BaseSolution solution) {
        this.game = game;
        this.solution = solution;

    }

    @Override
    public Compass getCompass() {
        return new DirectionCompass();
    }

    public RobotMemory getRobotMemory() {

        if (robotMemory == null) {
            if (game == null) {
                new ErrorMessage().appearFatalError(getClass(), "Robot -> GAME = NULL");
            } else {
                robotMemory = new RobotMemory(game);
            }
        }
        return robotMemory;
    }

    public void setRobotMemory(RobotMemory robotMemory) {
        this.robotMemory = robotMemory;
    }

    @Override
    public int getInput(Game game) {
        return new RobotInput(solution, game).getInput(getRobotMemory());
    }

    public BaseSolution getSolution() {
        return solution;
    }

    public void setSolution(BaseSolution solution) {
        this.solution = solution;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new RobotGameOver(game));
        }
        return gameRule;
    }

}
