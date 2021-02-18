package game.move;

import game.Game;
import game.gamerepo.GameModelProcess;
import game.gamerepo.updategamemodel.UpdateForMovedBack;
import game.location.DirectionLocation;
import game.location.Location;

public class MoveBack extends Move {

    public MoveBack(Game game) { //, DirectionLocation proceedLocation
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
    public void updateBeforeStep(DirectionLocation location) {
        System.out.println(getClass().getSimpleName() + " -->  before > update visited direction");
//        updateVisitedDirection(getLocation());
        updateVisitedArea();
        updateValuesInGameModel.updateValueVisitedDirection(location);
    }

    void decreasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

    void removeMaxStepBeforeGoingLastStep() {
        int maxValueInTable = new GameModelProcess(game).findMaxStep();

        //System.out.println("Max Value in Table  : >> : " + new GameModelProcess(game).findMaxStep() + " >> will be deleted ");
        new GameModelProcess(game).deleteMaxStep(game.getPlayer().getStep());
        System.out.println("Max Value in Table  << "+maxValueInTable+" >> value is deleted. ");
        // System.out.println(" New Max Value in Table  : >> : " + new GameModelProcess(game).findMaxStep());
        //System.out.println("Tablodaki max deger  >> : " + new GameModelProcess(game).findMaxStep());
    }
}
