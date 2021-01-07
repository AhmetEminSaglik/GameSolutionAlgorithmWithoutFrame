package play.step;

import Game.GameModel;
import Game.player.Player;
import location.Location;
import move.MovePlayer;

public abstract class AfterStep implements IStep {

    private GameModel gameModel;
    private Player player;
    private Location location;
    private MovePlayer movePlayer;
    private FillGameSquares fillGameSquares;

    public AfterStep(GameModel gameModel) {
        this.gameModel = gameModel;

        this.player = gameModel.getPlayer();

        movePlayer = new MovePlayer(gameModel);
        fillGameSquares = new FillGameSquares(gameModel);

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

    public FillGameSquares getFillGameSquares() {
        return fillGameSquares;
    }

    public void setFillGameSquares(FillGameSquares fillGameSquares) {
        this.fillGameSquares = fillGameSquares;
    }

}
