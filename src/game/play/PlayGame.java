package game.play;

import check.CheckSquare;
import game.gamerepo.CreateLocationOfLastStep;
import game.move.MoveBack;
import game.move.MoveForward;
import game.move.Move;
import game.gameover.GameOver;
import game.gamerepo.GameModel;
import game.gamerepo.player.Player;
import compass.KeyboardCompass;
import game.location.Location;
import printarray.PrintArray;
import validation.Validation;

public class PlayGame {

    GameModel gameModel;
    Player player;
    PrepareGame prepareGame;

    Validation validation = new Validation();

    public PlayGame(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();
    }

    public void playGame() {

        prepareGame = new PrepareGame(gameModel);
        Move moveForwardOrBack;

        printGamelastStuation(gameModel);

        while (!new GameOver().isGameOver(gameModel)) {

            int choose = player.getInput();// Player a at kisi icin input alma, robot icin kosullara gore yonlendirme yaz

            moveForwardOrBack = getMoveBackOrForward(choose);

            if (moveForwardOrBack.isItAvailableToMove(gameModel, choose)) {
                moveForwardOrBack.move(new Location().getLocationValueAccordingToEnteredValue(gameModel, choose));
            }
            printGamelastStuation(gameModel);

        }
    }

    void printGamelastStuation(GameModel gameModel) {

        new PrintArray().printMultipleArray(gameModel.getGameSquares());

    }

    public boolean isItAvailableToMove(GameModel gameModel, int choose) {

        validation.setCompass(prepareGame.compass);
        CheckSquare checkSquare = new CheckSquare();
        checkSquare.setCompass(prepareGame.compass);

        if (validation.isInputValidForArray(gameModel, choose)
                && checkSquare.isSquareAvailableToMoveOnIt(gameModel, choose)) {
            return true;

        }
        return false;
    }

    Move getMoveBackOrForward(int index) {
        if (index == new KeyboardCompass().getLastLocation()) {
            return new MoveBack(gameModel);
        }
        /*else {
            System.out.println("OLMADI index : " + index + "   / new KeyboardCompass().getLastLocation()" + new KeyboardCompass().getLastLocation());
        }*/
        return new MoveForward(gameModel);
    }

//    Location getLocationValueAccordingToEnteredValue(int choose) {
//        if (choose == new KeyboardCompass().getLastLocation()) {
//            return new CreateLocationOfLastStep(gameModel).createLastStepLocation();
//        }
//        return prepareGame.switchDirection.choseDirection(choose);
//    }
}