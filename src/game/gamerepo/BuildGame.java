package game.gamerepo;

import game.Game;
import validation.SquareValidationGame;

public class BuildGame {

    private int horizontalSquare;
    private int verticalSquare;
    private Game game;

    public BuildGame(int verticalSquare, int horizontalSquare) throws InterruptedException { //Model model, Player player,
        new SquareValidationGame(verticalSquare, horizontalSquare);
        this.horizontalSquare = horizontalSquare;
        this.verticalSquare = verticalSquare;
        game = new Game();

    }

    public Game fillGame() throws InterruptedException {

        game.setModel(new Model());

        game.getModel().setGameSquares(createMultipleArrayFromIntegers(verticalSquare, horizontalSquare));

        return game;
    }

    public Game clearAreas() {
        return game = creatVisitArea(game);
    }

    public int[][] createMultipleArrayFromIntegers(int verticalSquare, int horizontalSquare) {
        return new int[verticalSquare][horizontalSquare];
    }

    public String[] prepareNullArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = "   ";
        }

        return array;
    }

    Game creatVisitArea(Game game) {
        boolean visitedAreas[][] = new boolean[verticalSquare][horizontalSquare];
        game.getModel().setVisitedAreas(visitedAreas);
        clearVisitedAreas(game);
        return game;
    }

    Game clearVisitedAreas(Game game) {
        for (int i = 0; i < game.getPlayer().getLocation().getX(); i++) {

            for (int j = 0; j < game.getPlayer().getLocation().getY(); j++) {
                game.getModel().getVisitedAreas()[i][j] = false;
            }
        }
        return game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
