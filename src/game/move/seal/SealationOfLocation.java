package game.move.seal;

import game.Game;
import game.gamerepo.player.Player;

import javax.swing.*;

public class SealationOfLocation implements UpdateableLocation {
    Game game;
    Player player;

    public SealationOfLocation(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    @Override
    public void updateLocationCondition(boolean[][] area, Signature signature) {
        try {
            area[game.getPlayer().getLocation().getX()][game.getPlayer().getLocation().getY()] = signature.isSealed();

        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()+"\n game.getPlayer().getLocation().getX(): "+game.getPlayer().getLocation().getX()+"\n" +
                    "game.getPlayer().getLocation().getY()"+game.getPlayer().getLocation().getY()+" step :"+game.getPlayer().getStep());
            ex.printStackTrace();
        }

    }
}
