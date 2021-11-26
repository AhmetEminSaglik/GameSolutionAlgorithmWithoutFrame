package Main;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.gamerepo.player.robot.solution.first.FirstSolution_Combination;
import game.gamerepo.player.robot.solution.second.SecondSolution_CalculateForwardAvailableWays;
import game.play.PlayGame;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        int squareEdge = 10;
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

        double firstSolutionRoundCounter = 4_809_118;
        double secondSolution___JustNextStep_DoesHaveAnyRelationWithOtherSquares___RoundCounter = 717_742;
        System.out.println("First Solution algorithm roundCounter : (4_809_119) ><" + firstSolutionRoundCounter + "     Time : " + " 0:0:2:646");
        System.out.println("Second Solution algorithm (Just check about does next Square have any relations) roundCounter : (717_742) >< " + secondSolution___JustNextStep_DoesHaveAnyRelationWithOtherSquares___RoundCounter + "  Time :  " + " 1:234");
        System.out.println("Round Counter Difference : " + (firstSolutionRoundCounter - secondSolution___JustNextStep_DoesHaveAnyRelationWithOtherSquares___RoundCounter));
        System.out.println("Speed increase ration : " + ((firstSolutionRoundCounter / secondSolution___JustNextStep_DoesHaveAnyRelationWithOtherSquares___RoundCounter)));
        System.out.println("-----");
    }

}

