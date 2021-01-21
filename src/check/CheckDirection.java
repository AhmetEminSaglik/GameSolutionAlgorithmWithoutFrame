package check;

import compass.DirectionCompass;
import game.gamerepo.player.robot.Robot;
import game.location.DirectionLocation;
import game.location.Location;

public class CheckDirection extends BaseCheck {

    /**
     * This is for robot
     */
    public boolean isDirectionAvailableToMoveOnIt(Robot robot, int directionIndex) {
        setCompass(new DirectionCompass());

        Location location = DirectionLocation.getLocationFromCompass(getCompass(), directionIndex);
        if (robot.getRobotMemory().getVisitedDirections()[robot.getStep()][directionIndex] == false) { // eger false ise bu yonde gidilmemistir demektir
            return true;
        }
        return false;
//        if () {
//
//        }
    }
}
