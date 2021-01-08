package play;

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
    Compass compass = new KeyboardCompass();
    Validation validation = new Validation();

    SwitchDirection switchDirection = new SwitchDirection(compass);

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
        UpdateGameModel updateGameModel = new UpdateGameModel(gameModel);

        SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(gameModel);

        selectFirstSqaureToStart.selectSquareStart(0, 0);

        updateGameModel.moveForward(selectFirstSqaureToStart);

        Compass compass = new KeyboardCompass();

        SwitchDirection switchDirection = new SwitchDirection(compass);

        // System.out.println(gameModel);
        Scanner scanner = new Scanner(System.in);

        while (!new GameOver().isGameOver(gameModel)) { // !new GameOver().isGameOver(gameModel)

            printGamelastStuation(gameModel);

            int choose = scanner.nextInt();
            if (isItAvailableToMove(gameModel, choose)) {

                switchDirection.updateCompass(compass);
                updateGameModel.moveForward(switchDirection.choseDirection(choose));

                System.out.println(player.toString());

            }
        }
    }

    void printGamelastStuation(GameModel gameModel) {
        new PrintArray<String>().printMultipleArray(gameModel.getGameSquares());

    }

    boolean isItAvailableToMove(GameModel gameModel, int choose) {
        validation.setCompass(compass);
        CheckSquare checkSquare = new CheckSquare();
        checkSquare.setCompass(compass);
        if (validation.isInputValidForArray(gameModel, choose)
                && checkSquare.isSquareAvailableToMoveOnIt(gameModel, choose)) {
            return true;
        }
        return false;
    }
}
