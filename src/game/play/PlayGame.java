package game.play;

import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.Player;
import game.location.DirectionLocation;
import game.move.Move;
import print.FileWriteProcess;
import print.PrintAble;
import printarray.StringFormat;

public class PlayGame {

    Game game;
    Player player;
    PrepareGame prepareGame;
    public ComparisonOfSolutions comparisonOfSolutions;
    long totalGameFinishedScore = 0;
    PrintAble printable;
    StringFormat stringFormat = new StringFormat();

    public PlayGame(Game game) {
        this.game = game;
        player = game.getPlayer();
        printable = new FileWriteProcess(game.getPlayer().getName());
    }


    void compareSolutions() {
        comparisonOfSolutions.compareSolution();
    }

    public void playGame() {

        prepareGame = new PrepareGame(game);
        Move moveForwardOrBack;

//        comparisonOfSolutions = new ComparisonOfSolutions(game);
        printGamelastStuation(game);
        while (!player.getGameRule().isGameOver(game)) {
//            printGamelastStuation(game);
            game.increaseRoundCounter();
            int choose = player.getInput(game);
            moveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose));
printGamelastStuation(game);
            calculatePlayerTotalWinScore();

        }
        System.out.println("Total Number Solved " + totalGameFinishedScore);
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
            totalGameFinishedScore++;
            System.out.println("Total Solved : " + totalGameFinishedScore);
            printGamelastStuation(game);
        }
    }


    void saveGameResultToScore() {
        TimeCalcuation timeCalcuation = new TimeCalcuation();
        player.getScore().updatePlayedTime();
        System.out.println(" Total played time : " + timeCalcuation.getTotalPassedTime(player));
        System.out.println(" RoundCounter (while loop)  : " + game.getRoundCounter());
    }

    void printGamelastStuation(Game game) {

        String textWillAppendToFile = " Finished totalGame : " + totalGameFinishedScore + "\n";
        textWillAppendToFile += "RoundCounter : " + game.getRoundCounter() + '\n';


        textWillAppendToFile += stringFormat.getStringFormatArray(game.getModel().getGameSquares());
        System.out.println(textWillAppendToFile);
        System.out.println();
//        printToFile(textWillAppendToFile);
    }

    void printToFile(String text) {
        printable.append(text);
    }


}
