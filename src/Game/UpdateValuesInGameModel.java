package Game;

import Game.player.Player;
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
        gameModel.getVisitedAreas()[player.getLocationX()][player.getLocationY()] = isMovedForward();
    }

    final boolean isSuitableForConditionsToChangeVisitedDirection() {

        return (player.getStep() > 1) ? true : false;

    }

    /* why  step-2? Because  arrays start 0 and first step I mean  if step ==1  did not come from any direction.
     
    Ilerlemedeyken  --> Adim sayisini artirmadan once gidilecek yeri true yapiyoruz 
    
     */
    public void changeVisitedDirection(Location location) {
        if (player.getStep() > 1) {
            if (isMovedForward() == true) {
                gameModel.getVisitedDirections()[calculateTheIndexOfFirtsArrayOfVisitedDirection()][location.getId()] = isMovedForward();
            } else {

                for (int i = 0; i < new LocationsList().getList().size(); i++) {
                    gameModel.getVisitedDirections()[player.getStep() - 1][location.getId()] = isMovedForward();
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
}
