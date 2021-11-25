package game.gamerepo.player.robot.solution.second.navigation;

import game.location.CreateLocation;
import game.location.DirectionLocation;

public class Navigation {
    int step, oneWayNumbersValue;
    DirectionLocation compulsoryLocation = null;
    boolean isExitSituationWasLocatedInThisStep;
//    ExitSituation exitSituation = new ExitSituation(ExitSituation.EXIT_FREE);

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getOneWayNumbersValue() {
        return oneWayNumbersValue;
    }

    public void setOneWayNumbersValue(int oneWayNumbersValue) {
        this.oneWayNumbersValue = oneWayNumbersValue;
    }

    public DirectionLocation getCompulsoryLocation() {
//        System.out.println("KOPYALANNANNNN COMPOULSARI LOCATINO  ID : "+compulsoryLocation.getId());
        return createNewDirectionLocation(compulsoryLocation.getX(), compulsoryLocation.getY());
    }

    DirectionLocation createNewDirectionLocation(int x, int y) {
        DirectionLocation directionLocation = new DirectionLocation();

        directionLocation.setX(x);
        directionLocation.setY(y);
        return directionLocation;
    }

    public void setCompulsoryLocation(DirectionLocation compulsoryLocation) {
        this.compulsoryLocation = compulsoryLocation;
    }

    public boolean isExitSituationWasLocatedInThisStep() {
        return isExitSituationWasLocatedInThisStep;
    }

    public void setExitSituationWasLocatedInThisStep(boolean exitSituationWasLocatedInThisStep) {
        isExitSituationWasLocatedInThisStep = exitSituationWasLocatedInThisStep;
    }

    @Override
    public String toString() {
        return "Navigation{" +
                "step=" + step +
                ", oneWayNumbersValue=" + oneWayNumbersValue +
                ", compulsoryLocation=" + compulsoryLocation +
                ", isExitSituationWasLocatedInThisStep=" + isExitSituationWasLocatedInThisStep +
                '}';
    }
}
