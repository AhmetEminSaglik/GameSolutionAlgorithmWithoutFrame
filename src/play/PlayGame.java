package play;

import play.gameover.GameOver;
import Game.GameModel;
import Game.player.Player;
import compass.Compass;
import compass.KeyboardCompass;
import location.SwitchDirection;
import java.util.Scanner;

import printarray.PrintArray;
import validation.Validation;

public class PlayGame {

    GameModel gameModel;
    Player player;
    // Compass compass = new KeyboardCompass();
    Validation validation = new Validation();
    PrepareGame prepareGame;
    //SwitchDirection switchDirection = new SwitchDirection(compass);

    public PlayGame(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();
    }

    /*
    
    location change class    -->      OK
    FillGamesquared   class -->         OK
    changeVisitedArea class
    chnageVisitedThisArea class
      
     */
    public void playGame() {

        //UpdateGameModel updateGameModel = new UpdateGameModel(gameModel);
        //SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(gameModel);
        //selectFirstSqaureToStart.selectSquareStart(0, 0);
        // updateGameModel.moveForward(prepareGame.selectFirstSqaureToStart);
        // System.out.println(gameModel);
        prepareGame = new PrepareGame(gameModel);

        while (!new GameOver().isGameOver(gameModel)) { // !new GameOver().isGameOver(gameModel)

            printGamelastStuation(gameModel);

            int choose = prepareGame.scanInput.getInput();
            
            if (isItAvailableToMove(gameModel, choose)) {

                prepareGame.switchDirection.updateCompass(prepareGame.compass);
                prepareGame.updateGameModel.moveForward(prepareGame.switchDirection.choseDirection(choose));

                System.out.println(player.toString());

            }
        }
    }

    void printGamelastStuation(GameModel gameModel) {
        new PrintArray<String>().printMultipleArray(gameModel.getGameSquares());

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
}
