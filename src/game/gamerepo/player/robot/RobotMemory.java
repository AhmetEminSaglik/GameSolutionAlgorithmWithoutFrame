package game.gamerepo.player.robot;

import game.Game;
import game.location.Location;
import game.location.LocationsList;

import java.util.ArrayList;

public class RobotMemory {

    private boolean endPointDetermined = false;
    private ArrayList<Location> availableDirectionList = new ArrayList<>();
    private ArrayList<Integer> oneWayDirectionList = new ArrayList<>();

    Game game;

    public RobotMemory(Game game) {
        this.game = game;
    }

 /*   int getTotalNumberOfSquares() {
        return game.getModel().getGameSquares().length * game.getModel().getGameSquares().length;
    }
*/
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

  /*  public boolean isEndPointDetermined() {
        return endPointDetermined;
    }

    public void setEndPointDetermined(boolean endPointDetermined) {
        this.endPointDetermined = endPointDetermined;
    }

    public ArrayList<Location> getAvailableDirectionList() {
        return availableDirectionList;
    }

    public void setAvailableDirectionList(ArrayList<Location> availableDirectionList) {
        this.availableDirectionList = availableDirectionList;
    }

    public ArrayList<Integer> getOneWayDirectionList() {
        return oneWayDirectionList;
    }

    public void setOneWayDirectionList(ArrayList<Integer> oneWayDirectionList) {
        this.oneWayDirectionList = oneWayDirectionList;
    }
*/

}
