package game.play.input;

import game.Game;

public abstract class BaseControlInput {

    public Game game;

    public BaseControlInput(Game game) {
        this.game = game;
    }

    public abstract boolean isInputSuitableToMoveForward(Game game, int choose);

    public abstract boolean isInputSuitableToMoveBack(Game game, int choose);

}
