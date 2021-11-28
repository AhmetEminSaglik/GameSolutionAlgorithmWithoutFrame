package game.play;

import game.Game;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.location.DirectionLocation;
import game.move.Move;
import print.EasylyReadNumber;
import printarray.StringFormat;

public class PlayGame {

    Game game;
    Player player;
    PrepareGame prepareGame;
    public ComparisonOfSolutions comparisonOfSolutions;
    //    long totalGameFinishedScore = 0;
//    PrintAble printable;
    StringFormat stringFormat = new StringFormat();

    TimeCalcuation timeCalcuation;

    public PlayGame(Game game) {
        this.game = game;
        player = game.getPlayer();
//        printable = new FileWriteProcess(game.getPlayer().getName());
    }


    void compareSolutions() {
        comparisonOfSolutions.compareSolution();
    }

    public void playGame() {

        prepareGame = new PrepareGame(game);
        Move moveForwardOrBack;

//        comparisonOfSolutions = new ComparisonOfSolutions(game);
        printGamelastStuation(game);
        appendFileSolutionName();
        while (!player.getGameRule().isGameOver(game)) {
//            printGamelastStuation(game);
            game.increaseRoundCounter();
            int choose = player.getInput(game);
            moveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose));
//            printGamelastStuation(game);
            calculatePlayerTotalWinScore();

        }
        System.out.println("Total Number Solved " + player.getScore().getTotalGameFinishedScore());
        saveGameResultToScore();
    }


    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return player.getPlayerMove().getMoveBack();
        }
        return player.getPlayerMove().getMoveForward();
    }

    void calculatePlayerTotalWinScore() {
        if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
            player.getScore().increaseTotalGameFinishedScore();
            System.out.println("Total Solved : " + player.getScore().getTotalGameFinishedScore());
            printGamelastStuation(game);
            player.increaseSquareTotalSolvedValue();
        }
    }

    void saveGameResultToScore() {
        timeCalcuation = new TimeCalcuation();
        player.getScore().updatePlayedTime();
        System.out.println(" Total played time : " + timeCalcuation.getTotalPassedTime(player));
        System.out.println(" RoundCounter (while loop)  : " + game.getRoundCounter());
        appendFileTotalSolvedValue();
//        printable
    }

    void appendFileTotalSolvedValue() {


        long totalFinishedScore = player.getScore().getTotalGameFinishedScore();
        String scoreValue = getEasyReadyNumber(totalFinishedScore);
        calculatePlayerTotalWinScore();

        String text = "--------------";/*= ">>>>>>>>>>>>>>  "+ ((Robot) player).getSolution().getClass().getSimpleName()+"\n";*/
        text += "\nSolution :" + ((Robot) player).getSolution().getClass().getSimpleName();
        text += "\nTotal played time :" + timeCalcuation.getTotalPassedTime(player);
        text += "\ntotal Solved : " + scoreValue;
        if (game.getPlayer().getScore().getOverLongTotalGameFinishedScore() > 0) {
            text += "\nOverLong Solved " + game.getPlayer().getScore().getOverLongTotalGameFinishedScore() + "   (this means that==> "
                    + game.getOverLongRoundCounter() + " * " + Long.MAX_VALUE + " + " + game.getRoundCounter() + ")";
        }

        text += "\nRound Counter (While loop)  : " + getEasyReadyNumber(game.getRoundCounter());
        if (game.getOverLongRoundCounter() > 0) {
            text += "OverLongRoundCounter : " + game.getOverLongRoundCounter() + "   (this means that==> "
                    + game.getOverLongRoundCounter() + " * " + Long.MAX_VALUE + " + " + game.getRoundCounter() + ")";
        }


        text += "\n\n ========================================================== \n\n\n";
        game.getPlayer().getPrintableFileScore().append(text);

    }

    String getEasyReadyNumber(long number) {
        return new EasylyReadNumber().getReadableNumberInStringFormat(number);
    }

    void appendFileSolutionName() {
        String text = ">>>>>>>>>>>>>>  " + ((Robot) player).getSolution().getClass().getSimpleName() + " : \n\n";
        game.getPlayer().getPrintableFileScore().append(text);

    }


    void printGamelastStuation(Game game) {

        String textWillAppendToFile = " Finished totalGame : " + player.getScore().getTotalGameFinishedScore() + "\n";
        textWillAppendToFile += "RoundCounter : " + game.getRoundCounter() + '\n';


        textWillAppendToFile += stringFormat.getStringFormatArray(game.getModel().getGameSquares());
        System.out.println(textWillAppendToFile);
        System.out.println();
//        printToFile(textWillAppendToFile);
    }

    /*void printToFile(String text) {
        printable.append(text);
    }*/


}
