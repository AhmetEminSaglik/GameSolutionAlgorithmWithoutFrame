package play.step;

import Game.GameModel;
import location.Location;

public class AfterForwardStep extends AfterStep {

    public AfterForwardStep(GameModel gameModel) {
        super(gameModel);
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

    void increasePlayerStepValue() {
        //getPlayer().increaseStep();
        getUpdateValuesInGameModel().changePlayerStepValue();
    }

    void changeValueVisitedArea() {
        getUpdateValuesInGameModel().changeValueVisitedArea(); //    getGameModel().getVisitedAreas()[getPlayer().getLocationX()][getPlayer().getLocationY()] = true;
        //  System.out.println("makeTrueVisitedArea()  kontrol edilmeli " + getClass().getSimpleName());
        //     System.out.println("ZIYARET EDILEN (True oldu, tekrar buraya gelemicek) KONUM X : " + getPlayer().getLocationX() + " Y : " + getPlayer().getLocationY());
    }

    void changePlayerLocation(Location location) {

        getUpdateValuesInGameModel().changePlayerLocation(location);
    }

    @Override
    public void updatePlayerStepValue() {
        increasePlayerStepValue();
    }

    @Override
    public void updateVisitedArea() {
        changeValueVisitedArea();
    }

    public void changeVisitedDirection(Location location) {
        getUpdateValuesInGameModel().changeVisitedDirection(location);
        /* if (getPlayer().getStep() > 1) {

            getGameModel().getVisitedDirections()[getPlayer().getStep() - 1][location.getId()] = true; // 1. adimda [0][id] 10 adimda [9][id] olacak
        } else {
            new ClassicErrorMessage().showMessage("visited Direction is false >>> player step : " + getPlayer().getStep());
        }*/

    }

    @Override
    public void updateVisitedDirection(Location location) {
        changeVisitedDirection(location);
    }

    @Override
    public void updatePlayerLocation(Location location) {
        changePlayerLocation(location);

    }

}
