package game.move;

import game.Game;
import game.gamerepo.updategamemodel.UpdateForMovedForward;
import game.location.Location;

public class MoveForward extends Move {

    public MoveForward(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedForward(game);

    }

    // UpdateGameModel updateGameModel;
//    @Override
//    public boolean isItAvailableToMove(Model gameModel, int choose) {
//
//        validation.setCompass(compass);
//
//        CheckSquare checkSquare = new CheckSquare();
//        checkSquare.setCompass(compass);
////validation.isInputValidForArray(gameModel, choose)&& --> bunu simdilik kaldirdik cunku SquareAvaible'de de kontrol ediyor bunu
//        if (checkSquare.isSquareAvailableToMoveOnIt(gameModel, choose)) { //&& gameModel.getPlayer().isMovableThatDirection(new Location().getLocationValueAccordingToEnteredValue(gameModel, choose)
//            return true;
//        }
//        return false;
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
    public void updateBeforeStep() {
//        updateVisitedDirection(getLocation());
    }

    void increasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

    void changeValueVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }

//    public void changeVisitedDirection(Location location) {
//        updateValuesInGameModel.changeVisitedDirection(location);
//        /* if (getPlayer().getStep() > 1) {
//
//            getGameModel().getVisitedDirections()[getPlayer().getStep() - 1][location.getId()] = true; // 1. adimda [0][id] 10 adimda [9][id] olacak
//        } else {
//            new ClassicErrorMessage().showMessage("visited Direction is false >>> player step : " + getPlayer().getStep());
//        }*/
//    }
    void changePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }
}
