package play;

import Game.CreateLocationOfLastStep;
import move.MoveBack;
import move.MoveForward;
import move.Move;
import play.gameover.GameOver;
import Game.GameModel;
import Game.player.Player;
import compass.KeyboardCompass;
import errormessage.ErrorMessage;

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

    /*
    
    location change class    -->      OK
    FillGamesquared   class -->         OK
    changeVisitedArea class
    chnageVisitedThisArea class
      
     */
    public void playGame() {

        prepareGame = new PrepareGame(gameModel);
        Move moveForwardOrBack;
        //  CreateLocationOfLastStep createLocationOfLastStep = new CreateLocationOfLastStep(gameModel);

        printGamelastStuation(gameModel);
        while (!new GameOver().isGameOver(gameModel)) { // !new GameOver().isGameOver(gameModel)

            int choose = prepareGame.scanInput.getInput();
            //   moveForwardOrBack = getMoveBackOrForward(choose);

           
            if (choose == 5) {
                if (gameModel.getPlayer().getStep() > 1) {
                    //createLocationOfLastStep.setGameModel(gameModel);
                    prepareGame.updateGameModel.moveBack(new CreateLocationOfLastStep(gameModel).createLastStepLocation()); //new CreateLocationOfLastStep(gameModel).createLastStepLocation()
                } else {
                    ErrorMessage.appearClassicError("Step must be bigger than 1 ");
                }
            } else if (isItAvailableToMove(gameModel, choose)) {

                //moveForwardOrBack.isItAvailableToMove(gameModel, choose);
                prepareGame.switchDirection.updateCompass(prepareGame.compass);
                // moveForwardOrBack.move(prepareGame.switchDirection.choseDirection(choose));
                prepareGame.updateGameModel.moveForward(prepareGame.switchDirection.choseDirection(choose));

            }
            printGamelastStuation(gameModel);
            /*
            new PrintArray().printMultipleArrayBoolean(gameModel.getVisitedAreas());
            new PrintArray().printMultipleArrayBoolean(gameModel.getVisitedDirections());*/

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
        } else {
            System.out.println("OLMADI index : " + index + "   / new KeyboardCompass().getLastLocation()" + new KeyboardCompass().getLastLocation());
        }
        return new MoveForward(gameModel);
    }
}
