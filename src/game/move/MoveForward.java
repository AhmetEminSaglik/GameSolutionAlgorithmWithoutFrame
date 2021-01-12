package game.move;

import game.gamerepo.GameModel;
import game.gamerepo.updategamemodel.UpdateForMovedForward;
import game.location.Location;
import check.CheckSquare;

public class MoveForward extends Move {

    GameModel gameModel;
    // UpdateGameModel updateGameModel;

    public MoveForward(GameModel gameModel) {
        super(gameModel);
        //updateGameModel = new UpdateGameModel(gameModel);
        updateValuesInGameModel = new UpdateForMovedForward(gameModel);

    }

    @Override
    public boolean isItAvailableToMove(GameModel gameModel, int choose) {
        validation.setCompass(compass);

        CheckSquare checkSquare = new CheckSquare();
        checkSquare.setCompass(compass);

        if (validation.isInputValidForArray(gameModel, choose)
                && checkSquare.isSquareAvailableToMoveOnIt(gameModel, choose)) {
            return true;
        }
        return false;
    }

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
