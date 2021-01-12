package game.move;

import game.gamerepo.GameModel;
import game.gamerepo.GameModelProcess;
import game.gamerepo.updategamemodel.UpdateForMovedBack;
import game.location.Location;

public class MoveBack extends Move {

    public MoveBack(GameModel gameModel) {
        super(gameModel);
        updateValuesInGameModel = new UpdateForMovedBack(gameModel);

    }

    @Override
    public boolean isItAvailableToMove(GameModel gameModel, int choose) {
        return (gameModel.getPlayer().getStep() > 1) ? true : false;
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

    void decreasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

    void removeMaxStepBeforeGoingLastStep() {
        System.out.println("Tablodaki max deger  >> : " + new GameModelProcess(gameModel).findMaxStep());

        new GameModelProcess(gameModel).deleteMaxStep(gameModel.getPlayer().getStep());
        System.out.println("Tablodaki max deger  >> : " + new GameModelProcess(gameModel).findMaxStep());
    }
}
