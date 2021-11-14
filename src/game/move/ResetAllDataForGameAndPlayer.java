package game.move;

import game.Game;
import game.gamerepo.BuildGame;
import game.gamerepo.player.Player;

import javax.swing.*;

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
//        return player;
    }

   /* public void resetGameAndPlayerData(Game game, Player player) throws InterruptedException {
        game = clearGameData(game);

        clearPlayerData(player);
        game.setPlayer(player);

        JOptionPane.showMessageDialog(null, "SUanki game  adress  RESET SONRASI: " + game.toString());
    }*/
}
