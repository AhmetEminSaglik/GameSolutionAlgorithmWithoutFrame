package check.forwardlocation;

import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.location.CreateLocation;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.move.MovePlayer;
import squareprocess.SquareProcess;

import java.util.ArrayList;

public class ForwardLocation {
    SquareProcess squareProcess = new SquareProcess();
    ArrayList<DirectionLocation> locationsList = new LocationsList().getList();

    public int inspectLocationAndGetAvailableSquareNumbers(Game game, DirectionLocation locationNeededToInspect) {

        Location droneLocation = getDroneLocation(game, locationNeededToInspect);

        int availableLocationNumberToMove = 0;
        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isSquareAvailableToMoveOnIt(game, droneLocation, locationsList.get(i)))
                availableLocationNumberToMove++;
        }
        return availableLocationNumberToMove;
    }

    Location getDroneLocation(Game game, DirectionLocation locationNeededToInspect) {
        Location droneLocation = new Location();
        droneLocation.setX(game.getPlayer().getLocation().getX() + locationNeededToInspect.getX());
        droneLocation.setY(game.getPlayer().getLocation().getY() + locationNeededToInspect.getY());
        return droneLocation;
    }

}
