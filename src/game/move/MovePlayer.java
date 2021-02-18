package game.move;

import game.Game;
import game.gamerepo.player.Player;
import game.location.Location;

public class MovePlayer {

    Player player;

    public MovePlayer(Game game) {

        this.player = game.getPlayer();
    }

    void xChangeLocation(int x) {
        player.getLocation().setX(player.getLocation().getX() + x);
    }

    void yChangeLocation(int y) {
        player.getLocation().setY(player.getLocation().getY() + y);
    }

    public void changePlayerLocation(Location location) {
        xChangeLocation(location.getX());
        yChangeLocation(location.getY());
    }

}
