package game.move;

import game.location.DirectionLocation;
import game.location.Location;

public interface IMove {

    void updatePlayerStepValue();

    void updateVisitedArea();

    void updateVisitedDirection();//DirectionLocation location

    //    void updateVisitedDirection(Location location);
    void updatePlayerLocation( ); //Location location

    void updateBeforeStep();

    void updateAfterStep();


}
