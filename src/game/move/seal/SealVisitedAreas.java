package game.move.seal;

import game.Game;
import game.gamerepo.player.Player;

public class SealVisitedAreas implements ISeal {

    Game game;
    Player player;

    public SealVisitedAreas(Game game) {
        this.game = game;
        this.player = game.getPlayer();
    }

    @Override
    public void updateSeal(boolean seal) {
        game.getModel().getVisitedAreas()[player.getLocation().getX()][player.getLocation().getY()] = seal;
    }

}
