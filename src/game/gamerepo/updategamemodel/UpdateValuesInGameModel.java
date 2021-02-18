package game.gamerepo.updategamemodel;

import game.Game;
import game.gamerepo.player.Player;
import game.location.DirectionLocation;
import game.location.Location;
import game.move.MovePlayer;
import game.move.seal.SealVisitedAreas;

public abstract class UpdateValuesInGameModel {

    Game game;
    Player player;
    MovePlayer movePlayer;

    public UpdateValuesInGameModel(Game game) {
        this.game = game;

        player = game.getPlayer();
        movePlayer = new MovePlayer(game);
    }

    public abstract void updatePlayerStepValue();

    public final void changePlayerLocation(Location location) {
        movePlayer.changePlayerLocation(location);
    }

    /**
     * if player moved forward then return true else return false;
     */
    abstract boolean isMovedForward();

    public final void updateValueVisitedArea() {
        new SealVisitedAreas(game).updateSeal(game.getModel().getVisitedAreas(), isMovedForward());

    }

    public final void updateValueVisitedDirection(DirectionLocation location) {
        player.updateVisitedDirection(isMovedForward(), location);
    }

    final boolean isSuitableForConditionsToChangeVisitedDirection() {

        return (player.getStep() > 1) ? true : false;

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
