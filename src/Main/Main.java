package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.person.Person;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.gamerepo.player.robot.solution.FirstSolution;
import game.play.PlayGame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        new Yapilacaklar().stickNote("NOT\nNOT\nNOT\nNOT\n"
//                + "GameRules diye bir sey acarim  her oyuncu icin ayri bir class olur  ve robot icin de de person icinde de new'lenmesi gerekir\n"
//                + "buna gore isGameOver() ve daha boyle bazi ortak fonksiyonlari ayiririm"
//                + "NOT\nNOT\nNOT\n");

//        String text = "   Yapilacaklar  :  "
//                + "\n Visited direction test edilecek "
//                + "\n Cozum algoritmasi yazilacak ";
//        ErrorMessage.appearFatalError(text);
        BuildGame buildGameModel = new BuildGame(10, 10);
        Game game = buildGameModel.fillGame(); //robot        

        Player person = new Person();

        BaseSolution firstSolution = new FirstSolution();
        Player robot = new Robot(game, firstSolution);

        game.setPlayer(robot);

        buildGameModel.clearAreas();

        // PrintArray<String> printArray = new PrintArray<>();
        PlayGame playGame = new PlayGame(game);
        playGame.playGame();

    }

}
