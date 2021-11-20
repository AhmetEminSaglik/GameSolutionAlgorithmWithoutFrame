package game.gamerepo.updategamemodel;

import game.Game;
import game.gamerepo.player.Player;
import game.location.DirectionLocation;
import game.location.Location;
import game.move.MovePlayer;
import game.move.seal.SealationOfLocation;
import game.move.seal.Signature;

public abstract class UpdateValuesInGameModel {

    Game game;
    Player player;
    MovePlayer movePlayer;

    public UpdateValuesInGameModel(Game game) {
        this.game = game;

        player = game.getPlayer();
        movePlayer = new MovePlayer(player);
    }

    public abstract void updatePlayerStepValue();

    public final void changePlayerLocation(Location location) {
        movePlayer.changePlayerLocationByAdding(location);
    }


    abstract Signature ifMovedForwardThenSealTheLocation();

    public final void updateValueVisitedArea() {
        new SealationOfLocation(game).updateLocationCondition(game.getModel().getVisitedAreas(), ifMovedForwardThenSealTheLocation());

    }
      public abstract void updateValueVisitedDirection(DirectionLocation directionLocation);

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
