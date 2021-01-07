package move;

import Game.GameModel;
import Game.player.Player;
import location.Location;

public class MovePlayer {

    Player player;

    public MovePlayer(GameModel gameModel) {

        this.player = gameModel.getPlayer();
    }

    void xChangeLocation(int x) {
        player.setLocationX(player.getLocationX() + x);
    }

    void yChangeLocation(int y) {
        player.setLocationY(player.getLocationY() + y);
    }

    public void changePlayerLocation(Location location) {
        // player.increaseStep();
        xChangeLocation(location.getX());
        yChangeLocation(location.getY());
    }

    /* public void goNorth() {
        yChangeLocation(3);
    }

    public void goNorthEast() {
        xChangeLocation(2);
        yChangeLocation(2);
    }

    public void goEast() {
        xChangeLocation(3);
    }

    public void goSouthEast() {
        xChangeLocation(2);
        yChangeLocation(-2);

    }

    public void goSouth() {
        yChangeLocation(-3);
    }

    public void goSouthWest() {
        xChangeLocation(-2);
        yChangeLocation(-2);
    }

    public void goWest() {
        xChangeLocation(-3);
    }

    public void goNorthWest() {
        xChangeLocation(-2);
        yChangeLocation(2);
    }*/
}
