package game.gamerepo.updategamemodel;

import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.location.DirectionLocation;
import game.move.seal.Signature;
import sleep.Sleep;
import validation.Validation;

import javax.swing.*;

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
        int step = player.getStep();
        if (new Validation().isStepValueAvailable(game, step)) {
//            ShowPanel.show(getClass(),"GERI ADIM ATMA UpdateVisitedDirection validasyon SAGLANDIIIIIIIIIIIIIIIII : "+step+ " direction id : "+directionLocation.getId());
            player.updateVisitedDirection(ifMovedForwardThenSealTheLocation().isSealed(), step, directionLocation);
        }else{
//            ShowPanel.show(getClass(),"GERI ADIM ATMA UpdateVisitedDirection validasyon saglanamadi : "+step+ " direction id : "+directionLocation.getId());
        }
    }


}
