package game.play;

import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.location.DirectionLocation;
import game.move.Move;
import print.EasylyReadNumber;
import print.FileWriteProcess;
import printarray.StringFormat;

public class PlayGame {

    Game game;
    Player player;
    PrepareGame prepareGame;
    public ComparisonOfSolutions comparisonOfSolutions;
    StringFormat stringFormat = new StringFormat();
    TimeCalcuation timeCalcuation;
    //    int startLocationX, startLocationY;
    FileWriteProcess printFileProcess;

    public PlayGame(Game game) {
        this.game = game;
        player = game.getPlayer();
        printFileProcess = new FileWriteProcess(game.getPlayer().getName());
    }


    void compareSolutions() {
        comparisonOfSolutions.compareSolution();
    }

    public void playGame() {

        prepareGame = new PrepareGame(game);
        Move moveForwardOrBack;

//        printGamelastStuation(game);
//        appendFileSolutionName();
//        startLocationX = game.getPlayer().getLocation().getX();
//        startLocationY = game.getPlayer().getLocation().getY();

        while (!player.getGameRule().isGameOver(game)) {

            game.increaseRoundCounter();
            int choose = player.getInput(game);
            moveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack.move(
                    new DirectionLocation().
                            getLocationValueAccordingToEnteredValue(game, choose));

            calculatePlayerTotalWinScore();

//            System.out.println(game.getPlayer().getLocation().getX());
//            System.out.println(game.getPlayer().getLocation().getY());

//            if (game.getModel().getGameSquares()[0][0] != 1)
//                break;
//            if (player.isPrintableStepSituation() == true) {
//                printGamelastStuation(game);
//            }

//                printGamelastStuation(game);
//            printGamelastStuation(game);
//            if(player.getStep()==25){
//                ShowPanel.show(getClass()," 25 e ulasti");
//            }

        }

        System.out.println("Total Number Solved " + getEasyReadyNumber(player.getScore().getTotalGameFinishedScore()));
        saveGameResultToScore();
    }


    void appendFileSquareTotalSolvedValue() {

        int locationX = game.getPlayer().getLocation().getX();
        int locationY = game.getPlayer().getLocation().getY();
        int squareTotalSolvedValue = game.getPlayer().getSquareTotalSolvedValue();


        String scoreValue = new EasylyReadNumber().getReadableNumberInStringFormat(squareTotalSolvedValue);

//        game.getPlayer().getPrintableFileScore().append(scoreValue);


        String text = "[" + locationX + "]" + "[" + locationY + "] = " + scoreValue + "\n";

//        game.getPlayer().getPrintableFileScore().append(text);
        game.getPlayer().resetSquareTotalSolvedValue();

    }

    Move getMoveBackOrForward(int index) {
//        ShowPanel.show(getClass(),"Player Move : "+player.getPlayerMove().toString());
        if (index == player.getCompass().getLastLocation()) {
            return player.getPlayerMove().getMoveBack();
        }
        return player.getPlayerMove().getMoveForward();
    }

    void calculatePlayerTotalWinScore() {
        if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
            player.getScore().increaseTotalGameFinishedScore();
//            System.out.println("Total Solved : " + player.getScore().getTotalGameFinishedScore());
            printGamelastStuation(game);
            player.increaseSquareTotalSolvedValue();


        }
    }


    void saveGameResultToScore() {
        timeCalcuation = new TimeCalcuation();
        player.getScore().updatePlayedTime();
        System.out.println("Elapsed time : " + timeCalcuation.getTotalPassedTime(player));
        System.out.println("Total Back Step : " + getEasyReadyNumber(game.getPlayer().getScore().getCounterTotalBackStep()));
//        System.out.println("Total Dummy Back Step : " + getEasyReadyNumber(game.getPlayer().getScore().getCounterOfDummyBackMove()));
        System.out.println("Total Step : " + getEasyReadyNumber(game.getRoundCounter()));
//        System.out.println(" Total Dummy Back Step)  : " + getEasyReadyNumber(game.getPlayer().getScore().getCounterOfDummyBackMove()));
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
//        game.getPlayer().getPrintableFileScore().append(text);

    }

    String getEasyReadyNumber(long number) {
        return new EasylyReadNumber().getReadableNumberInStringFormat(number);
    }

    void appendFileSolutionName() {
        String text = ">>>>>>>>>>>>>>  " + ((Robot) player).getSolution().getClass().getSimpleName() + " : \n\n";
//        game.getPlayer().getPrintableFileScore().append(text);

    }


    void printGamelastStuation(Game game) {
        String textWillAppendToFile = "Finished totalGame : " + getEasyReadyNumber(player.getScore().getTotalGameFinishedScore()) + "\n";
        textWillAppendToFile += "Total Step : " + getEasyReadyNumber(game.getRoundCounter()) + '\n' + "" +
                "Total Back Step : " + getEasyReadyNumber(game.getPlayer().getScore().getCounterTotalBackStep()) +
                "\nTotal Dummy Back Step : " + getEasyReadyNumber(game.getPlayer().getScore().getCounterOfDummyBackMove())+
                "\nStep : " + player.getStep() + "\n";


        textWillAppendToFile += stringFormat.getStringFormatArray(game.getModel().getGameSquares());//  print game squares
        System.out.println("textWillAppendToFile : " + textWillAppendToFile);
//        System.out.println(textWillAppendToFile);
        printToFile(textWillAppendToFile);
    }
    void printToFile(String text) {
        game.getPlayer().getPrintableFileScore().append(text);
//        printFileProcess.append(text);
    }


}
