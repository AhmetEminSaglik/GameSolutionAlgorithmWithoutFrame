package robot;

import game.gamerepo.GameModel;
import game.location.Location;
import game.location.LocationsList;
import java.util.ArrayList;

public class RobotMemory {

    private boolean visitedDirections[][];
    private boolean endPointDetermined = false;
    private ArrayList<Location> availableDirectionList = new ArrayList<>();
    private ArrayList<Integer> oneWayDirectionList = new ArrayList<>();

    GameModel gameModel;

    public RobotMemory(GameModel gameModel) {
        visitedDirections = new boolean[getTotalNumberOfSquares()][new LocationsList().getList().size()];
        this.gameModel = gameModel;
        System.out.println("Kontrol Amacli  :\n"
                + "Total Number Of Squares : " + getTotalNumberOfSquares()
                + "LocationList size : " + new LocationsList().getList().size());
    }

    int getTotalNumberOfSquares() {
        return gameModel.getGameSquares().length * gameModel.getGameSquares().length;
    }

    public boolean[][] getVisitedDirections() {
        return visitedDirections;
    }

    public void setVisitedDirections(boolean[][] visitedDirections) {
        this.visitedDirections = visitedDirections;
    }

    public GameModel getGameModel() {

        return gameModel;

    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public boolean isEndPointDetermined() {
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

}