package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.gamerepo.player.robot.solution.second.SecondSolution_CalculateForwardAvailableWays;
import game.play.PlayGame;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        int squareEdge = 5;
        BuildGame buildGameModel = new BuildGame(squareEdge, squareEdge);
        Game game = buildGameModel.createGame();

//        Player person = new Person(game);


        System.out.println("Enter even number to play\n"
                + "Enter odd number to see solution");

        BaseSolution baseSolution = new SecondSolution_CalculateForwardAvailableWays(game);
        Player robot = new Robot(game, baseSolution);
        buildGameModel.createVisitedArea();

        PlayGame playGame = new PlayGame(game);
        playGame.playGame();

      /*  BaseSolution baseSolution2 = new SecondSolution_CalculateForwardAvailableWays(game);
        Player robot2 = new Robot(game, baseSolution2);
        buildGameModel.createVisitedArea();

        PlayGame playGame2 = new PlayGame(game);
        playGame2.playGame();


         comparisonOfSolutions = new ComparisonOfSolutions(game);
        comparisonOfSolutions.deleteBothIfTheyAreSame(playGame.comparisonOfSolutions.copyModel, playGame2.comparisonOfSolutions.copyModel);*/
        System.out.println("----------------");


    }

}

