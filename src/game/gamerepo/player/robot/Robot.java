package game.gamerepo.player.robot;

import compass.Compass;
import compass.DirectionCompass;
import errormessage.ErrorMessage;
import game.Game;
import game.gameover.RobotGameOver;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.DirectionLocation;
import game.location.LocationsList;
import game.play.input.robot.RobotInput;
import game.rule.BaseGameRule;
import printarray.PrintArray;
import sleep.Sleep;

import java.util.ArrayList;

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

    @Override
    public void updateVisitedDirection(boolean movedFordward, DirectionLocation location) {
        System.out.println("location.getId() -> " + location.getId());
        if (getStep() > 1) {
            if (movedFordward == true) {
                System.out.println("Forward Step " + getStep());

                getRobotMemory()
                        .getVisitedDirections()[getStep()][location.getId()] = true;
                System.out.println(" MOVEFORWARRDD  STEPPPP " + getStep() + " /./" + getRobotMemory()
                        .getVisitedDirections()[getStep()][location.getId()]);
            } else {
                ArrayList<DirectionLocation> locationsList = new LocationsList().getList();

                System.out.println("Back Step : " + getStep());

                if (getStep() < Math.pow(game.getModel().getGameSquares().length, 2)) {

                    System.out.println(" X : "+game.getPlayer().getLocation().getX()+ " Y : "+game.getPlayer().getLocation().getY());

//                    new PrintArray().printMultipleArrayBoolean(getRobotMemory().getVisitedDirections());
//                    System.out.println("-----");
                    for (int i = 0; i < locationsList.size() - 1; i++) {
                        System.out.println(" getRobotMemory().getVisitedDirections()["+getStep()+"][locationsList.get("+i+").getId()] "+getRobotMemory().getVisitedDirections()[getStep()][locationsList.get(i).getId()]);
                        getRobotMemory().getVisitedDirections()[getStep()][locationsList.get(i).getId()] = false;

                    }
//                    System.out.println("-----");
//                    new PrintArray().printMultipleArrayBoolean(getRobotMemory().getVisitedDirections());

//                    new Sleep().sleep(20_000);
                }
            }
        }

    }

}
