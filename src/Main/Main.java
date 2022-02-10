package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.Player;
import game.gamerepo.player.person.Person;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.gamerepo.player.robot.solution.first.FirstSolution_Combination;
import game.gamerepo.player.robot.solution.second.SecondSolution_CalculateForwardAvailableWays;
import game.gamerepo.player.robot.solution.third.ThirdtSolution_GoldenSquare;
import game.play.PlayGame;

import java.util.Scanner;


public class Main {

    BaseSolution baseSolution;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

//        int squareEdge = 5;
        BuildGame buildGameModel = new BuildGame();

        Game game = buildGameModel.createGame();

        Player player = main.selectPlayer(game);

        buildGameModel.createVisitedArea();

        PlayGame playGame = new PlayGame(game);
        playGame.playGame();
        System.out.println();
        if (main.baseSolution != null)
            System.out.println(main.baseSolution.getClass().getSimpleName());
        System.out.println("Game Dimension : " + game.getModel().getGameSquares().length + "-" + game.getModel().getGameSquares().length);

      /*  BaseSolution baseSolution2 = new SecondSolution_CalculateForwardAvailableWays(game);
        Player robot2 = new Robot(game, baseSolution2);
        buildGameModel.createVisitedArea();

        PlayGame playGame2 = new PlayGame(game);
        playGame2.playGame();


         comparisonOfSolutions = new ComparisonOfSolutions(game);
        comparisonOfSolutions.deleteBothIfTheyAreSame(playGame.comparisonOfSolutions.copyModel, playGame2.comparisonOfSolutions.copyModel);*/
        System.out.println("----------------");


    }

    Player selectPlayer(Game game) {
        System.out.println("Select Player : \nPerson : 1 \n Robot : 2");

        String input = new Scanner(System.in).nextLine();
        if (input.equals("1")) {
            return new Person(game);
        } else if (input.equals("2")) {
            baseSolution = new SecondSolution_CalculateForwardAvailableWays(game);
            return new Robot(game, baseSolution);

        } else {
            System.out.println("Unknow choice ");
            return selectPlayer(game);
        }

    }

}

