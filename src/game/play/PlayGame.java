package game.play;

import game.Game;
import game.gamerepo.CreateLocationOfLastStep;
import game.gamerepo.player.Player;
import game.location.DirectionLocation;
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

        long gameFinishTime = 0;

//        CopyModel copyModel = new CopyModel();
        while (!player.getGameRule().isGameOver(game)) {
            if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
                gameFinishTime++;
                printGamelastStuation(game);
                System.out.println("OYUN BITIRILDI : " + gameFinishTime);
//                copyModel.sendModelToCompareAndAddToList(game.getModel());
            }
            int choose = player.getInput(game);

            moveForwardOrBack = getMoveBackOrForward(choose);

            moveForwardOrBack.move(
                    new DirectionLocation().
                            getLocationValueAccordingToEnteredValue(game, choose));
        }

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

 /*   Location getLocationValueAccordingToEnteredValue(int choose) {
        if (choose == game.getPlayer().getCompass().getLastLocation()) {
            return new CreateLocationOfLastStep(game).createLastStepLocation();
        }
        return prepareGame.switchDirection.choseDirection(choose);
    }*/
}
