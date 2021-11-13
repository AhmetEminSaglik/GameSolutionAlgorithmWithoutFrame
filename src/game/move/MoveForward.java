package game.move;

import game.Game;
import game.gamerepo.updategamemodel.UpdateForMovedForward;
import game.location.DirectionLocation;
import game.location.Location;

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
    public void updateVisitedDirection(DirectionLocation location) {
//        game.getPlayer().updateVisitedDirection();
        updateValuesInGameModel.updateValueVisitedDirection(location);
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
    public void updatePlayerLocation(Location location) {
        changePlayerLocation(location);

    }

    @Override
    public void updateAfterStep() {
//        updatePlayerStepValue();
        updatePlayerLocation(getDirectionLocation());
        updateVisitedArea();

    }

    /**
     * moveForward icin bu fonk ici boss
     */
    @Override
    public void updateBeforeStep(DirectionLocation directionLocation) {
        updateVisitedDirection(directionLocation);
//        updateVisitedDirection(getLocation());
//        updateVisitedArea();

//        updateValuesInGameModel.updateValueVisitedDirection(location);
    }

    void increasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

  /*  void changeValueVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }*/

    void changePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }

}
