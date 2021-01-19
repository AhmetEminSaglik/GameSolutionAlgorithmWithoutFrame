package Main;

import game.gamerepo.BuildGameModel;
import game.gamerepo.GameModel;
import game.gamerepo.player.person.Person;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.play.PlayGame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // SILINECEKAnlikNotAlmaIcin silinecek = new SILINECEKAnlikNotAlmaIcin();

//        String text = "   Yapilacaklar  :  "
//                + "\n Visited direction test edilecek "
//                + "\n Cozum algoritmasi yazilacak ";
//        ErrorMessage.appearFatalError(text);
        Player person = new Person();
        Player robot = new Robot();
        BuildGameModel buildGameModel = new BuildGameModel(person, 10, 10);

        GameModel gameModel = buildGameModel.getGameModel();
        // PrintArray<String> printArray = new PrintArray<>();
        PlayGame playGame = new PlayGame(gameModel);
        playGame.playGame();

    }

}
