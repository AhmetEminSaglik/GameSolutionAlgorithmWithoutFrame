package game.gamerepo.player.robot.solution;

import game.Game;
import game.location.DirectionLocation;
import game.location.LocationsList;
import java.util.ArrayList;
import sleep.Sleep;

public class FirstSolution extends BaseSolution {

    @Override
    public int getInputLocationId(Game game) {
        ArrayList<DirectionLocation> locationsList = new LocationsList().getList();
        for (int i = 0; i < locationsList.size(); i++) {

            if (checkSquare.isSquareAvailableToMoveOnIt(game, locationsList.get(i).getId())) {
                System.out.println("ROBOTUN ILERLEYECEGI YON  : " + locationsList.get(i).getClass().getSimpleName()
                        + " " + locationsList.get(i).getId());

                //new Sleep().sleep();
                return locationsList.get(i).getId();

            } else {
                System.out.println("EN SON GIRIDIG ELSEYE BAKCAMMMMMMMMMMMMMMMMMMMM");
            }
            //    System.out.println(" location index : " + locationsList.get(i).getId());
        }
        System.out.println("burada bir sorun olabilir ");

        //       ErrorMessage.appearFatalError(getClass(), "burayi doldurmadim");
        new Sleep().sleep(1000);
        return locationsList.get(locationsList.size() - 1).getId();

    }

}
