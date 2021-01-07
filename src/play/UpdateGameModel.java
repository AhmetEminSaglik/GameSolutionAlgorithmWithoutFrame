package play;

import play.step.FillGameSquares;
import Game.GameModel;
import Game.player.Player;
import location.Location;
import play.step.AfterForwardStep;

public class UpdateGameModel extends GameModel {

    AfterForwardStep afterForwardStep;
    GameModel gameModel;
    Player player;

    FillGameSquares fillGameSquares;

    public UpdateGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();

        fillGameSquares = new FillGameSquares(gameModel);
        afterForwardStep = new AfterForwardStep(gameModel);
    }

    public void moveForward(Location location) {
        afterForwardStep.setLocation(location);
        afterForwardStep.updateAfterStep();
        fillGameSquares.printStepInGameSquare();
    }

    public void moveBack() {
    }

}
