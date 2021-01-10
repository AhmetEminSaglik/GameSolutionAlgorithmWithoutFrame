package Game;

public class GameModelProcess {

    GameModel gameModel;
    private int x, y;

    public GameModelProcess(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void calculateIndexOfGivenStepInGameSquareArrays(int step) {
        for (int i = 0; i < gameModel.getGameSquares().length; i++) {
            for (int j = 0; j < gameModel.getGameSquares()[i].length; j++) {
                if (gameModel.getGameSquares()[i][j] == step) {
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
        for (int i = 0; i < gameModel.getGameSquares().length; i++) {
            for (int j = 0; j < gameModel.getGameSquares()[i].length; j++) {
                if (gameModel.getGameSquares()[i][j] == step) {
                    gameModel.getGameSquares()[i][j] = 0;
                    return;
                }
            }
        }
    }

    public int findMaxStep() {
        int maxValue = 0;
        for (int i = 0; i < gameModel.getGameSquares().length; i++) {
            for (int j = 0; j < gameModel.getGameSquares()[i].length; j++) {
                if (maxValue < gameModel.getGameSquares()[i][j]) {
                    maxValue = gameModel.getGameSquares()[i][j];
                }
            }
        }

        return maxValue;
    }

}
