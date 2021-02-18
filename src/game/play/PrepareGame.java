package game.play;

import compass.Compass;
import compass.KeyboardCompass;
import game.Game;
import game.location.SwitchDirection;
import game.move.MoveForward;

public class PrepareGame {

    Game game;

    Compass compass;
    SwitchDirection switchDirection;
    PlayGame playGame;
    SelectFirstSqaureToStart selectFirstSqaureToStart;
    //ScanInput scanInput = new ScanInput();
//    IBaseInput baseInput;

    public PrepareGame(Game game) {

        fillNullReferans(game);
        prepareToPlay();

    }

    void fillNullReferans(Game game) {
        this.game = game;

        //  updateGameModel = new UpdateGameModel(gameModel);
        selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
        compass = new KeyboardCompass();
    }

    void prepareToPlay() {
        //updateGameModel.moveForward(selectFirstSqaureToStart);
        //updateGameModel.moveForward(selectFirstSqaureToStart);
        switchDirection = new SwitchDirection(compass);
        selectFirstSqaureToStart.selectSquareStart(0, 0);
        //  updateGameModel.moveForward(selectFirstSqaureToStart);
        
        new MoveForward(game).move(selectFirstSqaureToStart);

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
          void printGamelastStuation(Model gameModel) {
        new PrintArray<String>().printMultipleArray(gameModel.getGameSquares());

    }
         
    }*/
}
