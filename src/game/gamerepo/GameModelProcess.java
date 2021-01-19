package game.gamerepo;

import game.Game;

public class GameModelProcess {

    Game  game;
    private int x, y;

    public GameModelProcess(Game game) {
        this.game = game;
    }

    
    public void calculateIndexOfGivenStepInGameSquareArrays(int step) {
        for (int i = 0; i < game.getModel().getGameSquares().length; i++) {
            for (int j = 0; j < game.getModel().getGameSquares()[i].length; j++) {
                if (game.getModel().getGameSquares()[i][j] == step) {
                    x = i;
                    y = j;
                   // System.out.println("Geri adim icin hesaplanan location : " + x + ", " + y);
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void deleteMaxStep(int step) {
        for (int i = 0; i < game.getModel().getGameSquares().length; i++) {
            for (int j = 0; j < game.getModel().getGameSquares()[i].length; j++) {
                if (game.getModel().getGameSquares()[i][j] == step) {
                    game.getModel().getGameSquares()[i][j] = 0;
                    return;
                }
            }
        }
    }

    public int findMaxStep() {
        int maxValue = 0;
        for (int i = 0; i < game.getModel().getGameSquares().length; i++) {
            for (int j = 0; j < game.getModel().getGameSquares()[i].length; j++) {
                if (maxValue < game.getModel().getGameSquares()[i][j]) {
                    maxValue = game.getModel().getGameSquares()[i][j];
                }
            }
        }

        return maxValue;
    }

}
