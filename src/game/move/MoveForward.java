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
    public void updateVisitedArea() {
        changeValueVisitedArea();
    }

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
        updatePlayerStepValue();
        updatePlayerLocation(getLocation());
        updateVisitedArea();

    }

    /**
     * moveForward icin bu fonk ici boss
     */
    @Override
    public void updateBeforeStep(DirectionLocation location) {
//        updateVisitedDirection(getLocation());

        updateValuesInGameModel.updateValueVisitedDirection(location);
    }

    void increasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

    void changeValueVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }
 
    void changePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }

}
