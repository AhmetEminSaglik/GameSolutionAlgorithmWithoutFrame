package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.person.Person;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.gamerepo.player.robot.solution.FirstSolution;
import game.play.PlayGame;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        new Yapilacaklar().stickNote("NOT\nNOT\nNOT\nNOT\n"
//                + "ileri adim atarken adim  visitedDirectionnu doldurup, geri  adim  atarken onu silmem lazim. bunu robot mermorye yapmam lazim "
//                + "ancak player ile ortak fonksiyonlarda bu mumkun degil. Belki PlayerMove Tarzinda bir sey yazip  o player classina ozel fonksiyonlari"
//                + "ona aktarirsam olur\n\n\n"
//                + "YA DA  VISITED DIRECTIONU GAMEMODEL E EKLICEM "
//                + "NOT\nNOT\nNOT\n");

//        String text = "   Yapilacaklar  :  "
//                + "\n Visited direction test edilecek "
//                + "\n Cozum algoritmasi yazilacak ";
//        ErrorMessage.appearFatalError(text);
//        new Yapilacaklar().stickNote("Not\nNot\nNot\n"
//                + "VisitedDirectionu  model'e ekle ve MOVE daki update'lerin yanina  updateVisitedDirection'ni ekle ve icine yazmaya devam  et\n"
//                + "Person vs de olmazsa bos kalir"
//                + "Not\nNot\nNot\n");
//        
        BuildGame buildGameModel = new BuildGame(10, 10);
        Game game = buildGameModel.fillGame(); //robot        

        Player person = new Person();

        BaseSolution firstSolution = new FirstSolution();
        Player robot = new Robot(game, firstSolution);
        System.out.println("Enter 0 to play\n"
                + "Enter any number to see solution");
//        if (0 == new Scanner(System.in).nextInt()) {
//            game.setPlayer(person);
//        } else {
//            game.setPlayer(robot);
//
//        }
game.setPlayer(robot);

        buildGameModel.clearAreas();

        // PrintArray<String> printArray = new PrintArray<>();
        PlayGame playGame = new PlayGame(game);
        playGame.playGame();

    }

}
