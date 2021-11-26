package check.forwardlocation;

import drone.Drone;
import game.Game;
import game.location.DirectionLocation;
import game.location.LocationsList;
import squareprocess.SquareProcess;

import java.util.ArrayList;

public class ForwardLocation {
    SquareProcess squareProcess = new SquareProcess();
    ArrayList<DirectionLocation> locationsList = new LocationsList().getList();

    public int inspectLocationAndGetAvailableSquareNumbers(Game game, DirectionLocation locationNeededToInspect) {

        Drone drone = buildDrone(game, locationNeededToInspect);

        int availableLocationNumberToMove = 0;
        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isAreaAvailableToVisit(game, drone.getLocation(), locationsList.get(i)))
                availableLocationNumberToMove++;
        }
        return availableLocationNumberToMove;
    }

    Drone buildDrone(Game game, DirectionLocation locationNeededToInspect) {

        Drone drone = new Drone();
        drone.getLocation().setX(game.getPlayer().getLocation().getX() + locationNeededToInspect.getX());
        drone.getLocation().setY(game.getPlayer().getLocation().getY() + locationNeededToInspect.getY());

        return drone;
    }

}
