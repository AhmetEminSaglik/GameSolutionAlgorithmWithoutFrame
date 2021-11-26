package game.gamerepo.player;

import compass.Compass;
import game.Game;
import game.gamerepo.player.robot.TimeKeeper;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.play.PlayerMove;
import game.rule.BaseGameRule;

public abstract class Player implements UpdateableVistedDirection {
    protected PlayerMove playerMove;
    protected String name;
    Game game;
    private boolean visitedDirections[][];
    TimeKeeper timeKeeper;
    Score score;

    public Player(Game game) {
        this.game = game;
        game.setPlayer(this);

        clearVisitedDirections();
        timeKeeper = new TimeKeeper();
        score = new Score(game, this);

        name = "Unknow " + getClass().getSimpleName() + " name ";
    }

    public Player(Game game, String name) {
        super();
        this.name = name;
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

    public abstract int getInput(Game game);

    public abstract Compass getCompass();

    @Override
    public void updateVisitedDirection(boolean sealOrUnseal, int step, DirectionLocation location) {

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

    public Score getScore() {
        return score;
    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
