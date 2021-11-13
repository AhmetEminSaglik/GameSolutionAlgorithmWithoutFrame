package game.gamerepo.updategamemodel;

import game.Game;
import game.location.DirectionLocation;
import game.move.seal.Signature;
import sleep.Sleep;

public class UpdateForMovedBack extends UpdateValuesInGameModel {

    public UpdateForMovedBack(Game game) {
        super(game);
    }

    @Override
    public void updatePlayerStepValue() {
        game.getPlayer().decreaseStep();
    }

    @Override
    Signature ifMovedForwardThenSealTheLocation() {
        return Signature.UNSEAL;
    }

    @Override
    public void updateValueVisitedDirection(DirectionLocation directionLocation) {
        System.out.println(" (1 saniye durecak) >>>>   GERI ADIM ICIN MUHUR KALDIRIM GELEN DEGER : "+directionLocation);
            player.updateVisitedDirection(ifMovedForwardThenSealTheLocation().isSealed(), directionLocation);
//        new Sleep().sleep(1_000);
    }

    /*@Override
    boolean ifMovedForwardThenSealTheLocation() {
        return false;
    }*/


}
