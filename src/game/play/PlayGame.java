package game.play;

import compass.KeyboardCompass;
import game.Game;
import game.gameover.GameOver;
import game.gamerepo.player.Player;
import game.location.Location;
import game.move.Move;
import game.move.MoveBack;
import game.move.MoveForward;
import printarray.PrintArray;
import validation.Validation;

public class PlayGame {

    Game game;
    Player player;
    PrepareGame prepareGame;

    Validation validation = new Validation();

    public PlayGame(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    public void playGame() {

        prepareGame = new PrepareGame(game);
        Move moveForwardOrBack;

        printGamelastStuation(game);

        while (!new GameOver().isGameOver(game)) {

            int choose = player.getInput(game);// Player a at kisi icin input alma, robot icin kosullara gore yonlendirme yaz

            moveForwardOrBack = getMoveBackOrForward(choose);

//            if (moveForwardOrBack.isItAvailableToMove(gameModel, choose)) {
            moveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack.move(new Location().getLocationValueAccordingToEnteredValue(game, choose));
//            }
            printGamelastStuation(game);

        }
    }

    void printGamelastStuation(Game game) {

        new PrintArray().printMultipleArray(game.getModel().getGameSquares());

    }
//
//    public boolean isItAvailableToMove(Model gameModel, int choose) {
//
//        validation.setCompass(prepareGame.compass);
//        CheckSquare checkSquare = new CheckSquare();
//        checkSquare.setCompass(prepareGame.compass);
//
//        if (validation.isInputValidForArray(gameModel, choose)
//                && checkSquare.isSquareAvailableToMoveOnIt(gameModel, choose)) {
//            return true;
//
//        }
//        return false;
//    }

    Move getMoveBackOrForward(int index) {
        if (index == new KeyboardCompass().getLastLocation()) {
            return new MoveBack(game);
        }
        /*else {
            System.out.println("OLMADI index : " + index + "   / new KeyboardCompass().getLastLocation()" + new KeyboardCompass().getLastLocation());
        }*/
        return new MoveForward(game);
    }

//    Location getLocationValueAccordingToEnteredValue(int choose) {
//        if (choose == new KeyboardCompass().getLastLocation()) {
//            return new CreateLocationOfLastStep(gameModel).createLastStepLocation();
//        }
//        return prepareGame.switchDirection.choseDirection(choose);
//    }
}
