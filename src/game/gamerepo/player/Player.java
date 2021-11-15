package game.gamerepo.player;

import compass.Compass;
import game.Game;
import game.gamerepo.player.robot.TimeKeeper;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.rule.BaseGameRule;

public abstract class Player implements ISpecialFunctionForAKindOfPlayer {

    Game game;
    private boolean visitedDirections[][];
    TimeKeeper timeKeeper;

    public Player(Game game) {
        this.game = game;
        clearVisitedDirections();
        timeKeeper = new TimeKeeper();
    }

    public void clearVisitedDirections() {
        visitedDirections = new boolean[(int) Math.pow(game.getModel().getGameSquares().length, 2)][new LocationsList().getList().size()];
    }

    public void clearStepValue() {
        step = 0;
    }


    public BaseGameRule gameRule;
    Location location = new Location();

    private int step = 0;

    public Compass compass;

    public abstract BaseGameRule getGameRule();

    public void setGameRules(BaseGameRule gameRule) {
        this.gameRule = gameRule;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void increaseStep() {
        step++;
    }

    public void decreaseStep() {
        step--;
    }

    @Override
    public String toString() {
        return "Player{" + "location=" + location.toString() + ", step=" + step + ", compass=" + compass + '}';
    }

    public void printToString() {
        System.out.println(toString());
    }

    public void printPlayer() {
        System.out.println("******************");
        System.out.println(toString());
    }

    public abstract int getInput(Game game);

    public abstract Compass getCompass();

    public void getInfo() {
        System.out.println("Robot's Location : X,Y : " + location.getX() + " " + location.getY());
        System.out.println("Robot's step : " + getStep());
    }

    /**
     * This method is created for Robot visited direction
     */
    @Override
    public void updateVisitedDirection(boolean movedFordward, DirectionLocation location) {
//        System.out.println("gelen degerler : movedFordward : "+movedFordward+ " // "+location.getId());
//        getVisitedDirections()[getStep()][location.getId()] = movedFordward;
    }

    public Game getGame() {
        return game;
    }

    public boolean[][] getVisitedDirections() {
        return visitedDirections;
    }

    public TimeKeeper getTimeKeeper() {
        return timeKeeper;
    }
}
