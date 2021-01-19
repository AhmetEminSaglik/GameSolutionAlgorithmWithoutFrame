package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.Model;
import game.gamerepo.player.person.Person;
import game.gamerepo.player.Player;
import game.play.PlayGame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // SILINECEKAnlikNotAlmaIcin silinecek = new SILINECEKAnlikNotAlmaIcin();

//        String text = "   Yapilacaklar  :  "
//                + "\n Visited direction test edilecek "
//                + "\n Cozum algoritmasi yazilacak ";
//        ErrorMessage.appearFatalError(text);
        Player person = new Person();
        // BaseSolution firstSolution = new FirstSolution();
        // Player robot = new Robot(firstSolution);
        Model model = new Model();

        BuildGame buildGameModel = new BuildGame(model, person, 10, 10);

        Game game = buildGameModel.getGame();

// PrintArray<String> printArray = new PrintArray<>();
        PlayGame playGame = new PlayGame(game);
        playGame.playGame();

    }

}
