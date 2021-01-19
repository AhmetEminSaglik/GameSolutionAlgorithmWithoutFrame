package game.gamerepo.player.person;

import game.Game;
import game.gamerepo.player.Player;
import game.play.input.PersonInput;

public class Person extends Player {

//    @Override
//    public boolean isMovableThatDirection(Location location) {
//        return true;
//    }
    @Override
    public int getInput(Game game) {
        return new PersonInput(game).getInput();
    }

}
