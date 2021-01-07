package move;

import Game.GameModel;
import Game.player.Player;

public class SealTheVisitedAreas {

    GameModel gameModel;
    Player player;

    public SealTheVisitedAreas(GameModel gameModel) {
        this.gameModel = gameModel;
        this.player = gameModel.getPlayer();
    }

    public void sealCurrentLocation() {
        gameModel.getVisitedAreas()[player.getLocationX()][player.getLocationY()] = true;
    }
}
