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
        // player.increaseStep();
        //  System.out.print("changePlayerLocation  ---> ");
        //location.printLocation();
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
