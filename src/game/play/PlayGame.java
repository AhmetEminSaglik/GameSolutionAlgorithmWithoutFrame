package game.play;


import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.location.DirectionLocation;
import game.move.Move;
import print.FileWriteProcess;
import print.PrintAble;
import printarray.PrintArray;
import printarray.StringFormat;


public class PlayGame {

    long roundCounter = 0;

    Game game;
    Player player;
    PrepareGame prepareGame;
    ComparisonOfSolutions comparisonOfSolutions;
    long totalGameFinishedScore = 0;
    //    Validation validation = new Validation();
    PrintAble printable;
    StringFormat stringFormat = new StringFormat();

    public PlayGame(Game game) {
        this.game = game;
        player = game.getPlayer();
        printable = new FileWriteProcess(game.getModel().getGameSquares().length);
    }


    void compareSolutions() {
        comparisonOfSolutions.compareSolution();
    }

    public void playGame() {

        prepareGame = new PrepareGame(game);
        Move moveForwardOrBack;
//        printGamelastStuation(game);


        comparisonOfSolutions = new ComparisonOfSolutions(game);

        while (!player.getGameRule().isGameOver(game)) {
            roundCounter++;
//            printGamelastStuation(game);
            calculatePlayerTotalWinScore();


            int choose = player.getInput(game);

            moveForwardOrBack = getMoveBackOrForward(choose);

            moveForwardOrBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose));
            printGamelastStuation(game);

//            new Sleep().sleep(500);
        }

        saveGameResultToScore();
    }

    void calculatePlayerTotalWinScore() {
        if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
            totalGameFinishedScore++;
//            printGamelastStuation(game);

            System.out.println("Toplam Bulunulan Cozum Sayisi: " + totalGameFinishedScore);
//                compareSolutions();
        }
    }


    void saveGameResultToScore() {
        TimeCalcuation timeCalcuation = new TimeCalcuation();
        player.getScore().updatePlayedTime();
        System.out.println(" Total played time : " + timeCalcuation.getTotalPassedTime(player));
    }

    void printArrays(Game game) {
        new PrintArray().printMultipleArrayBoolean(game.getModel().getVisitedAreas());
        new PrintArray().printMultipleArrayBoolean(game.getPlayer().getVisitedDirections());
    }

    void printGamelastStuation(Game game) {

        System.out.println("ADIM SAYISI : " + game.getPlayer().getStep());
        new PrintArray().printMultipleArray(game.getModel().getGameSquares());

        String textWillAppendToFile = "Step : " + player.getStep() + " Finished totalGame : " + totalGameFinishedScore + "\n";
        textWillAppendToFile += "RoundCounter : " + roundCounter + '\n';
        textWillAppendToFile += stringFormat.getStringFormatArray(game.getModel().getGameSquares());
        if (roundCounter > 294) {
            System.out.println("Round couter : "+roundCounter);
            for(int i=0;i<((Robot)player).getRoadMemory().getOneWayNumbersList().size();i++){
                System.out.println("index : "+i+"  >>> " +((Robot)player).getRoadMemory().getOneWayNumbersList().get(i).toString());;
            }
            ShowPanel.show(getClass(),roundCounter+" yaziliyor");
        }

        System.out.println();
//        printToFile(textWillAppendToFile);


    }

    void printToFile(String text) {
        printable.append(text);
    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return player.getPlayerMove().getMoveBack();
        }
        return player.getPlayerMove().getMoveForward();
    }


}
