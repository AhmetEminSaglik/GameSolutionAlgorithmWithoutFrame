package game.gamerepo.player;

import game.location.Location;

public interface IPlayer {

    /**
     * Bu silinebilir. Eger Robot dogrudan inputda kontrollu input alirsa o
     * zaman ilerleyecegi yonu kontrol etmesine gerek kalmiyor
     */
    boolean isMovableThatDirection(Location location);
}
