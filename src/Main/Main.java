package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.Player;
import game.gamerepo.player.person.Person;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.gamerepo.player.robot.solution.FirstSolution;
import game.play.PlayGame;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

      /*  JOptionPane.showMessageDialog(null, "Move Back de " +
                "geri adim atmak icin oyun sinirlari - x ve -y yaparak buluyor" +
                "enterasan kisimsa su -4 ve -4 yaparak 1,4 konumunda 1 atiyor ve sonrasinda " +
                "isler sacma sapan bir seye sariyor, buga giriyor surekli bu duzeltilecek");*/

        int squareEdge=6;
        BuildGame buildGameModel = new BuildGame(squareEdge, squareEdge);
        Game game = buildGameModel.createGame();

        Player person = new Person(game);

        BaseSolution firstSolution = new FirstSolution();
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

        // PrintArray<String> printArray = new PrintArray<>();
        PlayGame playGame = new PlayGame(game);
        playGame.playGame();

    }

}
