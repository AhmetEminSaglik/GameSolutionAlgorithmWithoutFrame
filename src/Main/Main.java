package Main;

import Game.BuildGameModel;
import Game.GameModel;
import play.PlayGame;
import printarray.PrintArray;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // SILINECEKAnlikNotAlmaIcin silinecek = new SILINECEKAnlikNotAlmaIcin();

        BuildGameModel buildGameModel = new BuildGameModel(10, 10);
        GameModel gameModel = buildGameModel.getGameModel();

        PrintArray<String> printArray = new PrintArray<>();
        PlayGame playGame = new PlayGame(gameModel);
        playGame.playGame();

    }

}
