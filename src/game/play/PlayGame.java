package game.play;

import Main.Main;
import errormessage.ErrorMessage;
import game.Game;
import game.gamerepo.player.Player;
import game.location.DirectionLocation;
import game.move.Move;
import game.move.MoveBack;
import game.move.MoveForward;
import printarray.PrintArray;


public class PlayGame {

    Game game;
    Player player;
    PrepareGame prepareGame;
    ComparisonOfSolutions comparisonOfSolutions;
    long gameFinishTime = 0;
//    Validation validation = new Validation();

    public PlayGame(Game game) {
        this.game = game;
        player = game.getPlayer();
    }


    void compareSolutions() {
        comparisonOfSolutions.compareSolution();
    }

    public void playGame() {
        prepareGame = new PrepareGame(game);
        Move moveForwardOrBack;
        printGamelastStuation(game);

        comparisonOfSolutions = new ComparisonOfSolutions(game);

        while (!player.getGameRule().isGameOver(game)) {
            printGamelastStuation(game);
            calculatePlayerTotalWinScore();

            int choose = player.getInput(game);

            moveForwardOrBack = getMoveBackOrForward(choose);

            moveForwardOrBack.move(new DirectionLocation().getLocationValueAccordingToEnteredValue(game, choose));
//            printGamelastStuation(game);
        }

        saveGameResultToScore();
    }

    void calculatePlayerTotalWinScore() {
        if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
            gameFinishTime++;
            printGamelastStuation(game);

            System.out.println("Toplam Bulunulan Cozum Sayisi: " + gameFinishTime);
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
        System.out.println("----------------------------------");
    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            return new MoveBack(game);
        }
        return new MoveForward(game);
    }

}
