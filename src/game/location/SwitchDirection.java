package game.location;

import compass.Compass;
import errormessage.ErrorMessage;
import game.location.direction.South;
import game.location.direction.East;
import game.location.direction.LastLocation;
import game.location.direction.North;
import game.location.direction.West;
import game.location.direction.NorthEast;
import game.location.direction.NorthWest;
import game.location.direction.SouthWest;
import game.location.direction.SouthEast;

public class SwitchDirection {

    Compass compass;

    public SwitchDirection(Compass compass) {
        this.compass = compass;
    }

    public DirectionLocation choseDirection(int value) {

        if (compass.getNorth() == value) {
            return new North();
        }
        if (compass.getNorthEast() == value) {
            return new NorthEast();
        }
        if (compass.getEast() == value) {
            return new East();
        }
        if (compass.getSouthEast() == value) {
            return new SouthEast();
        }
        if (compass.getSouth() == value) {
            return new South();
        }
        if (compass.getSouthWest() == value) {
            return new SouthWest();
        }
        if (compass.getWest() == value) {
            return new West();
        }
        if (compass.getNorthWest() == value) {
            return new NorthWest();
        }
        if (compass.getLastLocation() == value) {
            return new LastLocation();
        }

        ErrorMessage.appearClassicError(getClass(), " compass  : " + compass.getClass().getSimpleName() + " -> Unknow Option  : " + value);

        return null;
    }

}
