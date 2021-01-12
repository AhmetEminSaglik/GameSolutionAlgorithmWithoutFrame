package game.gamerepo.updategamemodel;

import game.gamerepo.GameModel;
import game.gamerepo.player.Player;
import java.util.ArrayList;
import game.location.Location;
import game.move.MovePlayer;
import game.move.seal.SealVisitedAreas;
import game.play.LocationsList;

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
    
    public abstract void updatePlayerStepValue();

    /* public void increasePlayerStepValue() {
        gameModel.getPlayer().increaseStep();
    }*/
    public final void changePlayerLocation(Location location) {
        movePlayer.changePlayerLocation(location);
    }

    /**
     * if player moved forward then return true else return false;
     */
    abstract boolean isMovedForward();
    
    public final void changeValueVisitedArea() {
        //  PrintArray<Boolean> p = new PrintArray<>();
        //    p.printMultipleArrayBoolean(gameModel.getVisitedAreas());
        //System.out.println("player.getLocationX() : " + player.getLocationX());
        //System.out.println("player.getLocationY() : " + player.getLocationY());
        new SealVisitedAreas(gameModel).updateSealOfCurrentLocation(isMovedForward());
        
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
        new errormessage.ErrorMessage().appearClassicError(getClass().getSimpleName() + " ---> changeVisitedDirection()  ==> HATA OLABILIR TEST EDILMELI");
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
