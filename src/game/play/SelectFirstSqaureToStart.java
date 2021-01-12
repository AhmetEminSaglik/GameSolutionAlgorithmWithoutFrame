package game.play;

import game.gamerepo.GameModel;
import game.location.Location;
import java.util.Random;

public class SelectFirstSqaureToStart extends Location {

    private GameModel gameModel;

    public SelectFirstSqaureToStart(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void randomStart() {
        fillCordinates(new Random().nextInt(gameModel.getGameSquares().length),
                new Random().nextInt(gameModel.getGameSquares()[0].length));

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
