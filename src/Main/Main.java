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


public class Main {

    public static void main(String[] args) throws InterruptedException {
        int squareEdge = 5;
        BuildGame buildGameModel = new BuildGame(squareEdge, squareEdge);
        Game game = buildGameModel.createGame();

//        Player person = new Person(game);


        BaseSolution firstSolution = new SecondSolution_CalculateForwardAvailableWays(game);
        Player robot = new Robot(game, firstSolution);
        firstSolution.buildRobotMove();


        System.out.println("Enter even number to play\n"
                + "Enter odd number to see solution");
     /*   if (new Scanner(System.in).nextInt() % 2 == 0) {
            game.setPlayer(person);
        } else {
            game.setPlayer(robot);
        }*/
//        game.setPlayer(robot);
        buildGameModel.createVisitedArea();
        PlayGame playGame = new PlayGame(game);
        playGame.playGame();
        System.out.println("----------------");
        long firstSolutionRoundCounter = 4_809_119;
        long secondSolution___JustNextStep_DoesHaveAnyRelationWithOtherSquares___RoundCounter = 1_859_227;
        System.out.println("First Solution algorithm roundCounter : " + firstSolutionRoundCounter + " Time >  " + " 0:0:2:646");
        System.out.println("Second Solution algorithm (Just check about does next Square have any relations) roundCounter : " + secondSolution___JustNextStep_DoesHaveAnyRelationWithOtherSquares___RoundCounter + " Time >  " + " 0:0:2:507");
        System.out.println("Round Counter Difference : " + (firstSolutionRoundCounter - secondSolution___JustNextStep_DoesHaveAnyRelationWithOtherSquares___RoundCounter));
    }

}
