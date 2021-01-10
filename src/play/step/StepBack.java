package play.step;

import Game.FillGameSquare;
import Game.GameModel;
import Game.GameModelProcess;
import Game.updategamemodel.UpdateForMovedBack;
import Game.updategamemodel.UpdateValuesInGameModel;
import location.Location;
import move.MovePlayer;

public class StepBack extends Step { //implements IStep

    GameModel gameModel;
    MovePlayer movePlayer;
    FillGameSquare fillGameSquare;
    UpdateValuesInGameModel updateValuesInGameModel;
    private Location location;

    public StepBack(GameModel gameModel) {
        this.gameModel = gameModel;
        movePlayer = new MovePlayer(gameModel);
        fillGameSquare = new FillGameSquare(gameModel);
        updateValuesInGameModel = new UpdateForMovedBack(gameModel);
    }

    @Override
    public void updatePlayerStepValue() {
        decreasePlayerStepValue();
    }

    @Override
    public void updateVisitedArea() {
        updateValuesInGameModel.changeValueVisitedArea();
    }

    @Override
    public void updateVisitedDirection(Location location) {
        updateValuesInGameModel.changeVisitedDirection(location);
    }

    @Override
    public void updatePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }

    @Override
    public void updateAfterStep() {
        removeMaxStepBeforeGoingLastStep();
        updatePlayerStepValue();
        updatePlayerLocation(getLocation());

    }

    @Override
    public void updateBeforeStep() {
        System.out.println(getClass().getSimpleName() + " -->  before > update visited direction");
        updateVisitedDirection(getLocation());
        updateVisitedArea();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    void decreasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.changePlayerStepValue();
    }

    void removeMaxStepBeforeGoingLastStep() {
        System.out.println("Tablodaki max deger  >> : " + new GameModelProcess(gameModel).findMaxStep());

        new GameModelProcess(gameModel).deleteMaxStep(gameModel.getPlayer().getStep());
        System.out.println("Tablodaki max deger  >> : " + new GameModelProcess(gameModel).findMaxStep());
    }
}
