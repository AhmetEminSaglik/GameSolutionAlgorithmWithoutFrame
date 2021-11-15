package game.move;

import game.Game;
import game.gamerepo.updategamemodel.UpdateForMovedForward;
import game.location.DirectionLocation;
import game.location.Location;

import javax.swing.*;

public class MoveForward extends Move {

    public MoveForward(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedForward(game);

    }

    //    }
    @Override
    public void updatePlayerStepValue() {
        increasePlayerStepValue();
    }

    @Override
    public void updateVisitedDirection() {//DirectionLocation location
//        game.getPlayer().updateVisitedDirection();
//        JOptionPane.showMessageDialog(null,getClass().getName());
        updateValuesInGameModel.updateValueVisitedDirection(getDirectionLocation());
    }

   /* @Override
    public void updateVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
//        changeValueVisitedArea();
    }*/

    //    @Override
//    public void updateVisitedDirection(Location location) {
//        changeVisitedDirection(location);
//    }
    @Override
    public void updatePlayerLocation() {
        changePlayerLocation(getDirectionLocation());

    }

    @Override
    public void updateBeforeStep( ) {

//        updateVisitedDirection(getLocation());
//        updateVisitedArea();

//        updateValuesInGameModel.updateValueVisitedDirection(location);
    }

    @Override
    public void updateAfterStep() {
//        updatePlayerStepValue();
        updatePlayerLocation();
        updateVisitedArea();
        updateVisitedDirection();

    }

    /**
     * moveForward icin bu fonk ici boss
     */


    void increasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

  /*  void changeValueVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }*/

    public void changePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }

}
