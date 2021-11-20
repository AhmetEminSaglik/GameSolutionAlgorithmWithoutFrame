package game.play;

import game.Game;
import game.location.DirectionLocation;
import game.move.MoveForward;
import game.move.MovePlayer;
import printarray.PrintArray;
import sleep.Sleep;

import javax.swing.*;
import java.util.Random;

public class SelectFirstSqaureToStart extends DirectionLocation {

    private Game game;
    MovePlayer movePlayer;

    public SelectFirstSqaureToStart(Game game) {
        this.game = game;
        movePlayer = new MovePlayer(game.getPlayer());
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

    @Override
    public String toString() {
        return "SelectFirstSqaureToStart{ X : " + getX() + " Y " + getY() + " }";
    }

    public void locateThePlayer() {
        MoveForward moveForward = new MoveForward(game);
        moveForward.updatePlayerStepValue();

        movePlayer.changePlayerLocationByExcatlyLocation(this);

        moveForward.updateVisitedArea();
        moveForward.getFillGameSquare().printStepInGameSquare();
    }
}
