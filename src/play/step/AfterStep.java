package play.step;

import Game.GameModel;
import Game.UpdateForMovedForward;
import Game.UpdateValuesInGameModel;
import Game.player.Player;
import location.Location;
import move.MovePlayer;

public abstract class AfterStep implements IStep {

    private GameModel gameModel;
    private Player player;
    private Location location;
    private MovePlayer movePlayer;
    private FillGameSquare fillGameSquare;
    private UpdateValuesInGameModel updateValuesInGameModel;

    public AfterStep(GameModel gameModel) {
        this.gameModel = gameModel;

        this.player = gameModel.getPlayer();

        movePlayer = new MovePlayer(gameModel);
        fillGameSquare = new FillGameSquare(gameModel);
        updateValuesInGameModel = new UpdateForMovedForward(gameModel);

    }

    /* @Override
    public void updateAfterStep() {
        System.out.println("BURAYI DENEMEK LAZIM");
        updatePlayerLocation(location);
        updatePlayerStepValue();
        updateVisitedArea();
        updateVisitedDirection(location);
    }*/
    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public MovePlayer getMovePlayer() {
        return movePlayer;
    }

    public void setMovePlayer(MovePlayer movePlayer) {
        this.movePlayer = movePlayer;
    }

    public FillGameSquare getFillGameSquare() {
        return fillGameSquare;
    }

    public void setFillGameSquare(FillGameSquare fillGameSquares) {
        this.fillGameSquare = fillGameSquares;
    }

    public UpdateValuesInGameModel getUpdateValuesInGameModel() {
        return updateValuesInGameModel;
    }

    public void setUpdateValuesInGameModel(UpdateValuesInGameModel updateValuesInGameModel) {
        this.updateValuesInGameModel = updateValuesInGameModel;
    }

}
