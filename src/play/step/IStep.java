package play.step;

import location.Location;

public interface IStep {

    void updatePlayerStepValue();

    void updateVisitedArea();

    void updateVisitedDirection(Location location);

    void updatePlayerLocation(Location location);
    
    void updateAfterStep();
}
