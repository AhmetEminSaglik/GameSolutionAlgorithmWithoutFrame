package play;

import Game.GameModel;
import compass.Compass;
import compass.KeyboardCompass;
import java.util.Scanner;
import location.SwitchDirection;

public class PrepareGame {

    GameModel gameModel;

    Compass compass;
    SwitchDirection switchDirection;
    PlayGame playGame;

    UpdateGameModel updateGameModel;
    SelectFirstSqaureToStart selectFirstSqaureToStart;
    ScanInput scanInput = new ScanInput();

    public PrepareGame(GameModel gameModel) {

        fillNullReferans(gameModel);
        prepareToPlay();

    }

    void fillNullReferans(GameModel gameModel) {
        this.gameModel = gameModel;

        updateGameModel = new UpdateGameModel(gameModel);
        selectFirstSqaureToStart = new SelectFirstSqaureToStart(gameModel);
        compass = new KeyboardCompass();
    }

    void prepareToPlay() {
        //updateGameModel.moveForward(selectFirstSqaureToStart);
        //updateGameModel.moveForward(selectFirstSqaureToStart);
        switchDirection = new SwitchDirection(compass);
        selectFirstSqaureToStart.selectSquareStart(0, 0);
        updateGameModel.moveForward(selectFirstSqaureToStart);

    }


    /*   public void start() {

       while (!new GameOver().isGameOver(gameModel)) {
            printGamelastStuation(gameModel);

            int choose = scanner.nextInt();

            if (playGame.isItAvailableToMove(gameModel, choose)) {

                switchDirection.updateCompass(compass);
                updateGameModel.moveForward(switchDirection.choseDirection(choose));

                //   System.out.println(player.toString());
            }
        }
          void printGamelastStuation(GameModel gameModel) {
        new PrintArray<String>().printMultipleArray(gameModel.getGameSquares());

    }
         
    }*/
}
