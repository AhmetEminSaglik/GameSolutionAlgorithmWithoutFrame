package game.gamerepo.player.robot;

import errormessage.ErrorMessage;
import game.gamerepo.Model;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.solution.BaseSolution;

public class Robot extends Player {

    ??? 
    private RobotMemory robotMemory;
    s private Model gameModel;
    private BaseSolution solution;

    public Robot(BaseSolution solution) {
        this.solution = solution;
    }
//
////    @Override
//    public boolean isMovableThatDirection(Location location) { //boolean visitedDirections[][]
//        return canRobotMoveThatDirection(location);
//    }
//
//    boolean canRobotMoveThatDirection(Location location) { //boolean visitedDirections[][]
//
//        /*
//        Burada daha once gidilmis directionlardan item almaliyiz.
//        
//         */
////        SIMDILIK TRUE DONDURECEM
////        System.out.println(getClass() + " --> location dan id alinca sorun olmayacagini dusunuyorum gelen");
////        location.printLocation();
////        CheckDirection checkDirection = new CheckDirection();
////
////        return checkDirection.isDirectionAvailableToMoveOnIt(this, location.getId());
//        return true;
//    }

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

//    @Override
//    public int getInput() {
//        return new RobotInput(gameModel).getInput();
//    }
    @Override
    public int getInput(Model gameModel) {
        getRobotMemory();
        System.exit(0);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
