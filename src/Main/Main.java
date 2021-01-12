package Main;

import errormessage.ErrorMessage;
import game.gamerepo.BuildGameModel;
import game.gamerepo.GameModel;
import game.play.PlayGame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // SILINECEKAnlikNotAlmaIcin silinecek = new SILINECEKAnlikNotAlmaIcin();

        String text = "   Yapilacaklar  :  "
                + "\n Visited direction test edilecek "
                + "\n Cozum algoritmasi yazilacak ";
        ErrorMessage.appearFatalError(text);
        BuildGameModel buildGameModel = new BuildGameModel(10, 10);
        GameModel gameModel = buildGameModel.getGameModel();
        // PrintArray<String> printArray = new PrintArray<>();
        PlayGame playGame = new PlayGame(gameModel);
        playGame.playGame();

    }

}
