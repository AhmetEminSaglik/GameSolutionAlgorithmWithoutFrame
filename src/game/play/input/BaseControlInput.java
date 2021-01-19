package game.play.input;

import game.Game;
import game.gamerepo.Model;

public abstract class BaseControlInput {

    Game game;

    public BaseControlInput(Game game) {
        this.game = game;
    }

    abstract boolean isInputSuitableToMoveForward(Game game, int choose);

    abstract boolean isInputSuitableToMoveBack(Game game, int choose);

    abstract int getInput();

}
