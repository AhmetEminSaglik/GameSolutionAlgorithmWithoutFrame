package game.move;

import game.Game;
import game.gamerepo.GameModelProcess;
import game.gamerepo.updategamemodel.UpdateForMovedBack;
import game.location.Location;

public class MoveBack extends Move {

    public MoveBack(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedBack(game);

    }

//    @Override
//    public boolean isItAvailableToMove(Model gameModel, int choose) {
//        return (gameModel.getPlayer().getStep() > 1) ? true : false;
//    }
    @Override
    public void updatePlayerStepValue() {
        decreasePlayerStepValue();
    }

     @Override
    public void updateVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }
//
//    @Override
//    public void updateVisitedDirection(Location location) {
//        updateValuesInGameModel.changeVisitedDirection(location);
//    }

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

    /**
     * Moveback icin bu fonk dolu
     */
    @Override
    public void updateBeforeStep() {
        System.out.println(getClass().getSimpleName() + " -->  before > update visited direction");
//        updateVisitedDirection(getLocation());
        updateVisitedArea();
    }

    void decreasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

    void removeMaxStepBeforeGoingLastStep() {
        System.out.println("Tablodaki max deger  >> : " + new GameModelProcess(game).findMaxStep());

        new GameModelProcess(game).deleteMaxStep(game.getPlayer().getStep());
        System.out.println("Tablodaki max deger  >> : " + new GameModelProcess(game).findMaxStep());
    }
}
