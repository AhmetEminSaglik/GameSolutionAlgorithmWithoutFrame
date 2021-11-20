package game.gamerepo.player.robot.solution;

import check.forwardlocation.ForwardLocation;
import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;

import java.util.ArrayList;

public class SecondSolution_CalculateForwardAvailableWays extends BaseSolution {
    @Override
    public int getLocationInput(Game game, RobotMemory robotMemory) {

        ArrayList<DirectionLocation> locationsList = new LocationsList().getList();
        ForwardLocation forwardLocation = new ForwardLocation();
        Location playerLocation = checkSquare.getPlayerLocation(game);

//        ErrorMessage.appearClassicError(getClass(),"AAAA");

        for (int i = 0; i < locationsList.size() - 1; i++) {
//            ErrorMessage.appearClassicError(getClass(),"BBB");
//            ShowPanel.show(getClass()," For dongusu  Second solution : >>>> isSquareAvailableToMoveOnIt() GIRECEK ");
            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {//, robotMemory
         /*       ShowPanel.show(getClass(), "Available location  for  " +
                        locationsList.get(i).getClass().getSimpleName() + " : " + locationsList.get(i) + " : "
                        + forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, locationsList.get(i)));*/
                System.out.println("Available location  for  " +
                        locationsList.get(i).getClass().getSimpleName() + " : " + locationsList.get(i) + " : "
                        + forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, locationsList.get(i))       );
//                return locationsList.get(i).getId();
            }
        }

        ShowPanel.show(getClass(),"islemler bitti");
        return 0;
    }
}
