package game.gamerepo.updategamemodel;

import game.Game;
import game.location.DirectionLocation;
import game.move.seal.Signature;

public class UpdateForMovedForward extends UpdateValuesInGameModel {

    public UpdateForMovedForward(Game game) {
        super(game);
        //System.out.println("game :|||||||  " + game);
    }

    @Override
    public void updatePlayerStepValue() {
        game.getPlayer().increaseStep();

    }

    @Override
    Signature ifMovedForwardThenSealTheLocation() {
        return Signature.SEAL;
    }

    @Override
    public void updateValueVisitedDirection(DirectionLocation directionLocation) {
        player.updateVisitedDirection(ifMovedForwardThenSealTheLocation().isSealed(), directionLocation);
    }


    /*@Override
    public void updateVisitedDirection(DirectionLocation location) {
        game.getPlayer().updateVisitedDirection(ifMovedForwardThenSealTheLocation().isSealed(),location );
    }*/

    /* @Override
    public void changePlayerLocation(Location location) {
        movePlayer.changePlayerLocation(location);
    }*/
    /*@Override
    boolean isMovedForward() {
        return true;
    }*/

//    @Override
//    public void changeVisitedDirection(Location location) {
//        super.changeVisitedDirection(location); //To change body of generated methods, choose Tools | Templates.
//
//    }
//    @Override
//    public void updateVisitedDirection() {
//
//    }
}
