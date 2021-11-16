package game.gamerepo.player.robot;

import compass.Compass;
import compass.DirectionCompass;
import errormessage.ErrorMessage;
import game.Game;
import game.gameover.RobotGameOver;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.DirectionLocation;
import game.play.input.robot.RobotInput;
import game.rule.BaseGameRule;


public class Robot extends Player {

    private RobotMemory robotMemory;

    private BaseSolution solution;

    public Robot(Game game, BaseSolution solution) {
        super(game);
        this.solution = solution;

    }

    @Override
    public Compass getCompass() {
        return new DirectionCompass();
    }

    public RobotMemory getRobotMemory() {

        if (robotMemory == null) {
            if (getGame() == null) {
                new ErrorMessage().appearFatalError(getClass(), "Robot -> GAME = NULL");
            } else {
                robotMemory = new RobotMemory(getGame());
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


    @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new RobotGameOver(getGame()));
        }
        return gameRule;
    }


    @Override
    public void updateVisitedDirection(boolean sealOrUnseal, int step, DirectionLocation location) {// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! BURASI REFACTOR EDILECEK adim sayisi eklenecek

//        ShowPanel.show(getClass(), " GELEN  MUHUR : " + sealOrUnseal + " ADIMSAYISI : " + step);
        assert (getStep() > 1) : getClass().getName() + " >>> ADIM SAYUISI " + getStep() + " GELDI";


        getVisitedDirections()[step][location.getId()] = sealOrUnseal;
        /*if (movedFordward == true) {

            getVisitedDirections()[getStep() - 1][location.getId()] = true;
        } else {
            ArrayList<DirectionLocation> locationsList = new LocationsList().getList();

            if (getStep() < Math.pow(getGame().getModel().getGameSquares().length, 2)) {
                for (int i = 0; i < locationsList.size() - 1; i++) {
                    getVisitedDirections()[getStep()][locationsList.get(i).getId()] = false;

                }
            }
        } */
    }

}
