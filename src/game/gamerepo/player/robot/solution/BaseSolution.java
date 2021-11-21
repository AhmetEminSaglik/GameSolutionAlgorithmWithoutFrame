package game.gamerepo.player.robot.solution;

import check.CheckSquare;
import game.Game;
import game.move.fundamental.MoveBack;
import game.move.fundamental.MoveForward;
import squareprocess.SquareProcess;

public abstract class BaseSolution {
    private Game game;

    public BaseSolution(Game game) {
        this.game = game;
    }

    private MoveForward moveForward;
    private MoveBack moveBack;
    public CheckSquare checkSquare = new CheckSquare();
    public SquareProcess squareProcess = new SquareProcess();

    public abstract int getLocationInput(Game game);//, RobotMemory robotMemory

/*
    public boolean isSquareAvailableToMoveOnIt(Game game, DirectionLocation location) {//, RobotMemory robotMemory
        if (isAreaAvailableToVisit(game, location)
                && isDirectionAvailableToVisit(game, location))
            return true;

        return false;
    }

    public boolean isAreaAvailableToVisit(Game game, DirectionLocation location) {
        Location locationWillBeCheck = checkSquare.createLocationToCheck(game);
        return checkSquare.isSquareFreeFromVisitedArea(game, locationWillBeCheck, location.getId());
    }

 */
/*   Location createLocationToCheck(Game game) {
        Location locationWillBeCheck = new Location();
        locationWillBeCheck.setX(game.getPlayer().getLocation().getX());
        locationWillBeCheck.setY(game.getPlayer().getLocation().getY());
        return locationWillBeCheck;
    }*//*


    public boolean isDirectionAvailableToVisit(Game game, DirectionLocation location) {
        return checkSquare.isSquareFreeFromVisitedDirection(game, location.getId());
    }
*/

    public MoveForward getMoveForward() {
        return moveForward;
    }

    public void setMoveForward(MoveForward moveForward) {
        this.moveForward = moveForward;
    }

    public MoveBack getMoveBack() {
        return moveBack;
    }

    public void setMoveBack(MoveBack moveBack) {
        this.moveBack = moveBack;
    }

    public Game getGame() {
        return game;
    }

    public abstract void buildRobotMove();
}
