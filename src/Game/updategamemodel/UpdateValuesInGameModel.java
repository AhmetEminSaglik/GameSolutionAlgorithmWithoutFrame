package Game.updategamemodel;

import Game.GameModel;
import Game.player.Player;
import java.util.ArrayList;
import location.Location;
import move.MovePlayer;
import play.LocationsList;

public abstract class UpdateValuesInGameModel {

    GameModel gameModel;
    Player player;
    MovePlayer movePlayer;

    public UpdateValuesInGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();
        movePlayer = new MovePlayer(gameModel);
    }

    public void fillVisitedAreas() {
        // gameModel.getVisitedAreas(new boolean[gameModel.getGameSquares().length][gameModel.getGameSquares()[0].length]);

    }

    public abstract void changePlayerStepValue();

    /* public void increasePlayerStepValue() {
        gameModel.getPlayer().increaseStep();
    }*/
    public abstract void changePlayerLocation(Location location);

    /**
     * if player moved forward then return true else return false;
     */
    abstract boolean isMovedForward();

    public final void changeValueVisitedArea() {
        //  PrintArray<Boolean> p = new PrintArray<>();
        //    p.printMultipleArrayBoolean(gameModel.getVisitedAreas());
        //System.out.println("player.getLocationX() : " + player.getLocationX());
        //System.out.println("player.getLocationY() : " + player.getLocationY());
        gameModel.getVisitedAreas()[player.getLocationX()][player.getLocationY()] = isMovedForward();
    }

    final boolean isSuitableForConditionsToChangeVisitedDirection() {

        return (player.getStep() > 1) ? true : false;

    }

    /* why  step-2? Because  arrays start 0 and first step I mean  if step ==1  did not come from any direction.
     
    Ilerlemedeyken  --> Adim sayisini artirmadan once gidilecek yeri true yapiyoruz 
    
     */
    public void changeVisitedDirection(Location location) {
        /*
        --> geri adim atarken    step degeri dusmuyor
        2 kere geri gelmeye kalkinca 0 0  noktasina donuyor (muhtemelen yukariyi halledince burasi da olacak)
        
         */
        if (player.getStep() > 1) {
            if (isMovedForward() == true) {
                gameModel.getVisitedDirections()[calculateTheIndexOfFirtsArrayOfVisitedDirection()][location.getId()] = isMovedForward();
            } else {
                ArrayList<Location> list = new LocationsList().getList();

                for (int i = 0; i < list.size(); i++) {
                    gameModel.getVisitedDirections()[player.getStep() - 1][list.get(i).getId()] = isMovedForward();
                }
            }
        }
    }

    public int calculateTheIndexOfFirtsArrayOfVisitedDirection() {
        return player.getStep() - 1;
    }

    /*
    10. adimdan 11. adima gidecem 
    0 -->      10. index
    [10][0] 
     */
    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }
}
