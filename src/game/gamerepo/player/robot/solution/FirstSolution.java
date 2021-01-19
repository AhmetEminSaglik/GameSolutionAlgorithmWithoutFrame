package game.gamerepo.player.robot.solution;

import errormessage.ErrorMessage;
import game.Game;
import game.location.Location;
import game.location.LocationsList;
import java.util.ArrayList;

public class FirstSolution extends BaseSolution {

    @Override
    public int getLocationInput(Game game) {
        ArrayList<Location> locationsList = new LocationsList().getList();

        for (int i = 0; i < locationsList.size(); i++) {

            if (checkSquare.isSquareAvailableToMoveOnIt(game, locationsList.get(i).getId())) {
                System.out.println("ROBOTUN ILERLEYECEGI YON  : " + locationsList.get(i).getClass().getSimpleName() + " " + locationsList.get(i).getId());
                return locationsList.get(i).getId();

            }
        }
        ErrorMessage.appearFatalError("burayi doldurmadim");
        return -1;
        
    }

}
