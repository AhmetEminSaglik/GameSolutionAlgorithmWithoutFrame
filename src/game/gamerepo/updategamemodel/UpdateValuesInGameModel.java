package game.gamerepo.updategamemodel;

import game.Game;
import game.gamerepo.player.Player;
import game.location.Location;
import game.move.MovePlayer;
import game.move.seal.SealVisitedAreas;

public abstract class UpdateValuesInGameModel {

    Game game;
    Player player;
    MovePlayer movePlayer;

    public UpdateValuesInGameModel(Game game) {
        this.game = game;

        player = game.getPlayer();
        movePlayer = new MovePlayer(game);
    }

    public abstract void updatePlayerStepValue();

    public final void changePlayerLocation(Location location) {
        movePlayer.changePlayerLocation(location);
    }

    /**
     * if player moved forward then return true else return false;
     */
    abstract boolean isMovedForward();

    public final void updateValueVisitedArea() {
        new SealVisitedAreas(game).updateSeal(isMovedForward());

    }

//    public abstract void updateVisitedDirection();

    final boolean isSuitableForConditionsToChangeVisitedDirection() {

        return (player.getStep() > 1) ? true : false;

    }

//    public void changeVisitedDirection(Location location) {
//
//        new errormessage.ErrorMessage().appearClassicError(getClass().getSimpleName() + " ---> changeVisitedDirection()  ==> HATA OLABILIR TEST EDILMELI");
//        if (player.getStep() > 1) {
//            if (isMovedForward() == true) {
//                gameModel.getVisitedDirections()[calculateTheIndexOfFirtsArrayOfVisitedDirection()][location.getId()] = isMovedForward();
//            } else {
//                ArrayList<Location> list = new LocationsList().getList();
//
//                for (int i = 0; i < list.size(); i++) {
//                    gameModel.getVisitedDirections()[player.getStep() - 1][list.get(i).getId()] = isMovedForward();
//                }
//            }
//        }
//    }
    public int calculateTheIndexOfFirtsArrayOfVisitedDirection() {
        return player.getStep() - 1;
    }

    /*
    10. adimdan 11. adima gidecem 
    0 -->      10. index
    [10][0] 
     */
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
