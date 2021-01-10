package play.step;

import location.Location;

public abstract class Step {

    abstract void updatePlayerStepValue();

    abstract void updateVisitedArea();

    abstract void updateVisitedDirection(Location location);

    abstract void updatePlayerLocation(Location location);

    abstract void updateAfterStep();

    abstract void updateBeforeStep();

}
