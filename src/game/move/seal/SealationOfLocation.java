package game.move.seal;

import game.Game;
import game.gamerepo.player.Player;

public class SealationOfLocation implements UpdateableLocation {
    Game game;
    Player player;

    public SealationOfLocation(Game game) {
        this.game = game;
        player = game.getPlayer();
    }

    @Override
    public void updateLocationCondition(boolean[][] area, Signature signature) {
        area[game.getPlayer().getLocation().getX()][game.getPlayer().getLocation().getY()] = signature.isSealed();
    }
}
