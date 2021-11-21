package game.gamerepo.player.robot.solution.second.navigation;

import game.location.DirectionLocation;

public class Navigation {
    int step, oneWayNumbersValue;
    DirectionLocation compulsoryLocation=null;
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
        oneWayNumbersValue = oneWayNumbersValue;
    }

    public DirectionLocation getCompulsoryLocation() {
        return compulsoryLocation;
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
}
