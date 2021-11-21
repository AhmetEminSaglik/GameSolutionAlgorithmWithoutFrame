package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.Player;
import game.gamerepo.player.person.Person;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.gamerepo.player.robot.solution.first.FirstSolution_Combination;
import game.gamerepo.player.robot.solution.second.SecondSolution_CalculateForwardAvailableWays;
import game.play.PlayGame;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int squareEdge=5;
        BuildGame buildGameModel = new BuildGame(squareEdge, squareEdge);
        Game game = buildGameModel.createGame();

        Player person = new Person(game);


        BaseSolution firstSolution = new SecondSolution_CalculateForwardAvailableWays();
// 3 farkli cozum algortimasi var aklimda suan sadece en basitini yazdim. Buda FirstSolution() Oluyor
        Player robot = new Robot(game, firstSolution);
        System.out.println("Enter even number to play\n"
                + "Enter odd number to see solution");
        if (new Scanner(System.in).nextInt() % 2 == 0) {
            game.setPlayer(person);
        } else {
            game.setPlayer(robot);
        }

        buildGameModel.createVisitedArea();
        PlayGame playGame = new PlayGame(game);
        playGame.playGame();

    }

}
