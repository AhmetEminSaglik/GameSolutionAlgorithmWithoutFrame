package game.play.input;

import game.Game;
import game.play.input.person.IPlayerInput;

public abstract class BaseControlInput implements IPlayerInput {

    public Game game;

    public BaseControlInput(Game game) {
        this.game = game;
    }

    public abstract boolean isInputSuitableToMoveForward(Game game, int choose);

    public abstract boolean isInputSuitableToMoveBack(Game game, int choose);

}
