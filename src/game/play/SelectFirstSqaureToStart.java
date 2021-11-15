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
        movePlayer = new MovePlayer(game);
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

    final int firstStep = 1;

    public void locateThePlayer() {
//        game.getModel().getGameSquares()[getX()][getY()] = firstStep;
        System.out.println("LOCATE PLAYER  : kontroller : ");


        MoveForward moveForward = new MoveForward(game);
        moveForward.updatePlayerStepValue();
//        moveForward.changePlayerLocation(this);
        movePlayer.changePlayerLocationByExcatlyLocation(this);
        moveForward.updateVisitedArea();
        moveForward.getFillGameSquare().printStepInGameSquare();

        new PrintArray().printMultipleArray(game.getModel().getGameSquares());
        new PrintArray().printMultipleArrayBoolean(game.getModel().getVisitedAreas());
        new PrintArray().printMultipleArrayBoolean(game.getPlayer().getVisitedDirections());

//        JOptionPane.showMessageDialog(null,getClass().getName()+"    BAKKKK");
//        System.out.println("111111111111111111111111111111111111111111111111111");
//        new PrintArray().printMultipleArray(game.getModel().getGameSquares());
//        new PrintArray().printMultipleArrayBoolean(game.getModel().getVisitedAreas());
//        new PrintArray().printMultipleArrayBoolean(game.getPlayer().getVisitedDirections());
//        JOptionPane.showMessageDialog(null,getClass().getName()+" DEVAM ETT");

/*        String ilkAdimGenelBakis = "step :" + game.getPlayer().getStep() + "\n" +
                "location : " + game.getPlayer().getLocation() + "\n" +
                "visited area [" + getX() + "][" + getY() + "]: " + game.getModel().getVisitedAreas()[getX()][getY()];
        JOptionPane.showMessageDialog(null, ilkAdimGenelBakis);*/


    }
}
