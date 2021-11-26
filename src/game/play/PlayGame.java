package game.play;


import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.second.navigation.Navigation;
import game.location.DirectionLocation;
import game.move.Move;
import print.FileWriteProcess;
import print.PrintAble;
import printarray.PrintArray;
import printarray.StringFormat;


public class PlayGame {

//    long roundCounter = 0;

    Game game;
    Player player;
    PrepareGame prepareGame;
    public ComparisonOfSolutions comparisonOfSolutions;
    long totalGameFinishedScore = 0;
    //    Validation validation = new Validation();
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
//        printGamelastStuation(game);


        comparisonOfSolutions = new ComparisonOfSolutions(game);

        while (!player.getGameRule().isGameOver(game)) {
            /*if (game.getRoundCounter() > 188146) {
                ShowPanel.show(getClass(), "2194 civari te sorun oluyor : " + totalGameFinishedScore + " get step : " + player.getStep());
                printGamelastStuation(game);
            }*/
            game.increaseRoundCounter();
//            printGamelastStuation(game);
            calculatePlayerTotalWinScore();


            int choose = player.getInput(game);

            moveForwardOrBack = getMoveBackOrForward(choose);

            moveForwardOrBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose));

//            if(game.getPlayer().getStep()>20)
//            printGamelastStuation(game);

//            new Sleep().sleep(500);
//            ShowPanel.show(getClass(),"adim : "+ player.getStep());
        }

        System.out.println("Toplam Bulunulan Cozum Sayisi: " + totalGameFinishedScore);
        saveGameResultToScore();
    }

    void calculatePlayerTotalWinScore() {
        if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
            totalGameFinishedScore++;
            printGamelastStuation(game);

            System.out.println("Toplam Bulunulan Cozum Sayisi: " + totalGameFinishedScore);
            compareSolutions();
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

//        System.out.println("ADIM SAYISI : " + game.getPlayer().getStep() +
//                " > Round Counter : " + game.getRoundCounter());
        new PrintArray().printMultipleArray(game.getModel().getGameSquares());

        String textWillAppendToFile = "Step : " + player.getStep() + " Finished totalGame : " + totalGameFinishedScore + "\n";
        textWillAppendToFile += "RoundCounter XXX : " + game.getRoundCounter() + '\n';

//        ShowPanel.show(getClass(), "Incele adim " +player.getStep());
        for (Navigation tmp : ((Robot) (player)).getRoadMemory().getOneWayNumbersList()) {
            textWillAppendToFile += tmp;
            textWillAppendToFile += "\n";
        }
        textWillAppendToFile += stringFormat.getStringFormatArray(game.getModel().getGameSquares());
        textWillAppendToFile += "\n" +
                "exit Situation : " + ((Robot) player).getRoadMemory().getExitSituation().getSituation() + "     <<<<< 0: Free, 1 Located";

      /*  if (game.getRoundCounter() > 294) {
            System.out.println("Round couter : " + game.getRoundCounter());
            for (int i = 0; i < ((Robot) player).getRoadMemory().getOneWayNumbersList().size(); i++) {
                System.out.println("index : " + i + "  >>> " + ((Robot) player).getRoadMemory().getOneWayNumbersList().get(i).toString());
                ;
            }
//            ShowPanel.show(getClass(),roundCounter+" yaziliyor");
        }*/

        System.out.println(textWillAppendToFile);
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
