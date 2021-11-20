package squareprocess;

import check.CheckSquare;
import game.Game;
import game.location.DirectionLocation;
import game.location.Location;
import sleep.Sleep;

public class SquareProcess {
    CheckSquare checkSquare = new CheckSquare();

    public boolean isSquareAvailableToMoveOnIt(Game game, Location currentProcessLocation, DirectionLocation directionLocation) {//, RobotMemory robotMemory
//        System.out.println("AREA " + isAreaAvailableToVisit(game, currentProcessLocation, directionLocation));
//        System.out.println("DIRECTION " + isDirectionAvailableToVisit(game, currentProcessLocation, directionLocation));
//        System.out.println("---------");
//        System.out.println("currentProcessLocation: "+currentProcessLocation+" /// directionLocation : "+directionLocation);
        if (isAreaAvailableToVisit(game, currentProcessLocation, directionLocation)
                && isDirectionAvailableToVisit(game, currentProcessLocation, directionLocation)) {
//            System.out.println("CCCCCCCCCCCCCCC currentProcessLocation: "+currentProcessLocation+" /// directionLocation : "+directionLocation);
            return true;
        }/* else {
            System.out.println("AREA " + isAreaAvailableToVisit(game, currentProcessLocation, directionLocation)+" current Location : "+ currentProcessLocation+" direction Location : "+directionLocation);
            System.out.println("DIRECTION " + isDirectionAvailableToVisit(game, currentProcessLocation, directionLocation)+" current Location : "+ currentProcessLocation+" direction Location : "+directionLocation);
//new Sleep().sleep(15_000);
        }*/
//        System.out.println("DDDDDDDDDDDDDDDD currentProcessLocation: "+currentProcessLocation+" /// directionLocation : "+directionLocation);
//        new Sleep().sleep(1000);

        return false;
    }

    public boolean isAreaAvailableToVisit(Game game, Location playerLocation, DirectionLocation location) {
//        Location locationWillBeCheck = checkSquare.getPlayerLocation(game);
        return checkSquare.isSquareFreeFromVisitedArea(game, playerLocation, location.getId());
    }

 /*   Location createLocationToCheck(Game game) {
        Location locationWillBeCheck = new Location();
        locationWillBeCheck.setX(game.getPlayer().getLocation().getX());
        locationWillBeCheck.setY(game.getPlayer().getLocation().getY());
        return locationWillBeCheck;
    }*/

    public boolean isDirectionAvailableToVisit(Game game, Location currentProcessLocation, DirectionLocation location) {
             return checkSquare.isSquareFreeFromVisitedDirection(game, currentProcessLocation, location.getId());
    }

}
