package move.seal;

import Game.GameModel;
import Game.player.Player;

public class SealVisitedAreas implements ISeal {

    GameModel gameModel;
    Player player;

    public SealVisitedAreas(GameModel gameModel) {
        this.gameModel = gameModel;
        this.player = gameModel.getPlayer();
    }

    public void updateSealOfCurrentLocation(boolean seal) {
        gameModel.getVisitedAreas()[player.getLocationX()][player.getLocationY()] = seal;
    }

}
