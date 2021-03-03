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

        while (!player.getGameRule().isGameOver(game)) {

            int choose = player.getInput(game);

            moveForwardOrBack = getMoveBackOrForward(choose);
            moveForwardOrBack.move(
                    new DirectionLocation().
                            getLocationValueAccordingToEnteredValue(game, choose));
            printGamelastStuation(game);
        }

    }

    void printGamelastStuation(Game game) {

        new PrintArray().printMultipleArray(game.getModel().getGameSquares());

    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            //   System.out.println("index : " + index);

            System.out.println("MOVE BACK ");
            return new MoveBack(game);
        }
        System.out.println("MOVE FORWARD ");

        return new MoveForward(game);
    }

    Location getLocationValueAccordingToEnteredValue(int choose) {
        if (choose == game.getPlayer().getCompass().getLastLocation()) {
            return new CreateLocationOfLastStep(game).createLastStepLocation();
        }
        return prepareGame.switchDirection.choseDirection(choose);
    }
}
