package game.gamerepo.player;

import game.location.DirectionLocation;

public interface UpdateableVistedDirection {

    void updateVisitedDirection(boolean sealOrUnseal,int step, DirectionLocation location);
}
