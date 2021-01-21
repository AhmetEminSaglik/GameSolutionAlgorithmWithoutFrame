package game.play;

import game.Game;
import game.location.DirectionLocation;
import java.util.Random;

public class SelectFirstSqaureToStart extends DirectionLocation {

    private Game game;

    public SelectFirstSqaureToStart(Game game) {
        this.game = game;
    }

    public void randomStart() {
        fillCordinates(new Random().nextInt(game.getModel().getGameSquares().length),
                new Random().nextInt(game.getModel().getGameSquares()[0].length));

    }

    public void selectSquareStart(int x, int y) {
        fillCordinates(x, y);
    }

    void fillCordinates(int x, int y) {
        setX(x);
        setY(y);

    }

    @Override
    public int getId() {
        return -1;
    }

}
