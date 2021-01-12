package game.move.seal;

import game.gamerepo.GameModel;
import game.gamerepo.player.Player;

public class SealVisitedAreas implements ISeal {

    GameModel gameModel;
    Player player;

    public SealVisitedAreas(GameModel gameModel) {
        this.gameModel = gameModel;
        this.player = gameModel.getPlayer();
    }

    @Override
    public void updateSeal(boolean seal) {
        gameModel.getVisitedAreas()[player.getLocationX()][player.getLocationY()] = seal;
    }

}
