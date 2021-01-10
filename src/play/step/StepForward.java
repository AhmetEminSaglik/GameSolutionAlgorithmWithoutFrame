package play.step;

import Game.FillGameSquare;
import Game.GameModel;
import Game.updategamemodel.UpdateForMovedForward;
import Game.updategamemodel.UpdateValuesInGameModel;
import location.Location;
import move.MovePlayer;

public class StepForward extends Step { //implements IStep

    GameModel gameModel;
    MovePlayer movePlayer;
    FillGameSquare fillGameSquare;
    UpdateValuesInGameModel updateValuesInGameModel;
    private Location location;

    public StepForward(GameModel gameModel) {
        this.gameModel = gameModel;
        movePlayer = new MovePlayer(gameModel);
        fillGameSquare = new FillGameSquare(gameModel);
        updateValuesInGameModel = new UpdateForMovedForward(gameModel);
    }

    @Override
    public void updatePlayerStepValue() {
        increasePlayerStepValue();
    }

    @Override
    public void updateVisitedArea() {
        changeValueVisitedArea();
    }

    @Override
    public void updateVisitedDirection(Location location) {
        changeVisitedDirection(location);
    }

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

    @Override
    public void updateBeforeStep() {
        updateVisitedDirection(getLocation());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    void changeValueVisitedArea() {
        updateValuesInGameModel.changeValueVisitedArea();
    }

    public void changeVisitedDirection(Location location) {
        updateValuesInGameModel.changeVisitedDirection(location);
        /* if (getPlayer().getStep() > 1) {

            getGameModel().getVisitedDirections()[getPlayer().getStep() - 1][location.getId()] = true; // 1. adimda [0][id] 10 adimda [9][id] olacak
        } else {
            new ClassicErrorMessage().showMessage("visited Direction is false >>> player step : " + getPlayer().getStep());
        }*/

    }

    void changePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }

    void increasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.changePlayerStepValue();
    }

}
