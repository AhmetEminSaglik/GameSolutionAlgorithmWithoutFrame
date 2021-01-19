package game.gamerepo.player.robot;

import check.CheckDirection;
import errormessage.ErrorMessage;
import game.gamerepo.GameModel;
import game.gamerepo.player.Player;
import game.location.Location;
import game.play.input.RobotInput;
import robot.RobotMemory;

public class Robot extends Player {

    private RobotMemory robotMemory;
    private GameModel gameModel;
    private boolean visitedDirection[][];

    @Override
    public boolean isMovableThatDirection(Location location) { //boolean visitedDirections[][]
        return canRobotMoveThatDirection(location);
    }

    boolean canRobotMoveThatDirection(Location location) { //boolean visitedDirections[][]

        /*
        Burada daha once gidilmis directionlardan item almaliyiz.
        
         */
//        SIMDILIK TRUE DONDURECEM
//        System.out.println(getClass() + " --> location dan id alinca sorun olmayacagini dusunuyorum gelen");
//        location.printLocation();
//        CheckDirection checkDirection = new CheckDirection();
//
//        return checkDirection.isDirectionAvailableToMoveOnIt(this, location.getId());
        return true;
    }

    public RobotMemory getRobotMemory() {

        if (robotMemory == null) {
            if (gameModel == null) {
                new ErrorMessage().appearFatalError("Robot -> GAMEMODEL = NULL");
            } else {
                robotMemory = new RobotMemory(gameModel);
            }
        }
        return robotMemory;
    }

    public void setRobotMemory(RobotMemory robotMemory) {
        this.robotMemory = robotMemory;
    }

    @Override
    public void func() {

    }

    @Override
    public int getInput() {
        return new RobotInput().getInput();
    }

}
