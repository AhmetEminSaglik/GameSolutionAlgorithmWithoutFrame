/*
package check;

import compass.DirectionCompass;
import game.gamerepo.player.robot.Robot;
import game.location.DirectionLocation;
import game.location.Location;

public class CheckDirection extends BaseCheck {

    public boolean isDirectionAvailableToMoveOnIt(Robot robot, int directionIndex) {
        setCompass(new DirectionCompass());

        Location location = DirectionLocation.getLocationFromCompass(getCompass(), directionIndex);
        if (robot.getVisitedDirections()[robot.getStep()][directionIndex] == false) {
            return true;
        }
        return false;
    }
}
*/
