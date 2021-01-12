package game.move;

import game.location.Location;

public interface IMove {

    void updatePlayerStepValue();

    void updateVisitedArea();

    void updateVisitedDirection(Location location);

    void updatePlayerLocation(Location location);

    void updateAfterStep();

    void updateBeforeStep();

}
