package game.move.fundamental;

import game.Game;
import game.gamerepo.GameModelProcess;
import game.gamerepo.updategamemodel.UpdateForMovedBack;
import game.location.DirectionLocation;
import game.location.LocationsList;
import game.move.Move;

import java.util.ArrayList;

public class MoveBack extends Move {

    public MoveBack(Game game) {
        super(game);
        updateValuesInGameModel = new UpdateForMovedBack(game);
    }

    @Override
    public void updateVisitedDirection() {
        clearAllDirectionBeforeGoBack();
    }

    void clearAllDirectionBeforeGoBack() {
        ArrayList<DirectionLocation> directionLocationList = new LocationsList().getList();

        for (int i = 0; i < directionLocationList.size(); i++) {
            updateValuesInGameModel.updateValueVisitedDirection(directionLocationList.get(i));
        }
    }

    @Override
    public void updateBeforeStep() {
        updateVisitedArea();
        updateVisitedDirection();
        removeMaxStepBeforeGoingLastStep();
    }

    @Override
    public void updateAfterStep() {
        updatePlayerLocation();
    }

    void removeMaxStepBeforeGoingLastStep() {
        new GameModelProcess(game).deleteMaxStep(game.getPlayer().getStep());
    }

       /* @Override
    public void updatePlayerLocation() {
        updateValuesInGameModel.changePlayerLocation(getDirectionLocation());
    }*/
   /* @Override
    public void updatePlayerStepValue() {
        decreasePlayerStepValue();
    }
*/
   /* void decreasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }*/
}
