package game.move;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.Player;

public class ResetAllDataForGameAndPlayer {
    int squareEdge;
    BuildGame buildGame;

    public ResetAllDataForGameAndPlayer(Game game) throws InterruptedException {
        squareEdge = game.getModel().getGameSquares().length;
        buildGame = new BuildGame(squareEdge, squareEdge);
    }


    public void clearGameData(Game game) throws InterruptedException {
        game.getModel().setGameSquares(new int[squareEdge][squareEdge]);
        game.getModel().setVisitedAreas(new boolean[squareEdge][squareEdge]);
    }

    public void clearPlayerData(Player player) {
        player.clearVisitedDirections();
        player.clearStepValue();
    }

}
