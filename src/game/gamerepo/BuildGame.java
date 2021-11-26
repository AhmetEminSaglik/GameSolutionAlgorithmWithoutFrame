package game.gamerepo;

import game.Game;
import validation.SquareValidationGame;

public class BuildGame {

    // horizontalSquare and verticalSquare are unnecessary. But later I may need them if I want to play as a rectangle instead of square
    private int horizontalSquare;
    private int verticalSquare;
    private Game game;

    public BuildGame(int verticalSquare, int horizontalSquare) throws InterruptedException {
        new SquareValidationGame(verticalSquare, horizontalSquare);
        this.horizontalSquare = horizontalSquare;
        this.verticalSquare = verticalSquare;
        game = new Game();
    }

    public Game createGame() throws InterruptedException {

        game.setModel(new Model());

        game.getModel().setGameSquares(createMultipleArrayFromIntegers(verticalSquare, horizontalSquare));

        return game;
    }

    public Game createVisitedArea() {
        game.getModel().setVisitedAreas(buildVisitedArea(game));
        clearVisitedAreas(game);
        return game;

    }

    public int[][] createMultipleArrayFromIntegers(int verticalSquare, int horizontalSquare) {
        return new int[verticalSquare][horizontalSquare];
    }

    boolean[][] buildVisitedArea(Game game) {
        return new boolean[verticalSquare][horizontalSquare];
    }

    void clearVisitedAreas(Game game) {
        for (int i = 0; i < game.getModel().getVisitedAreas().length; i++) {
            for (int j = 0; j < game.getModel().getVisitedAreas().length; j++) {
                game.getModel().getVisitedAreas()[i][j] = false;
            }
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
