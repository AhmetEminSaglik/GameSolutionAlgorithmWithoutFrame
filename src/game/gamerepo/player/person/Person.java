package game.gamerepo.player.person;

import game.gamerepo.player.Player;
import game.location.Location;
import game.play.input.PlayerInput;

public class Person extends Player {

    @Override
    public boolean isMovableThatDirection(Location location) {
        return true;
    }

    @Override
    public int getInput() {
        return new PlayerInput().getInput();
    }

}
