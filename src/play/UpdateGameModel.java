package play;

import play.step.FillGameSquare;
import Game.GameModel;
import Game.player.Player;
import location.Location;
import play.step.AfterForwardStep;

public class UpdateGameModel extends GameModel {

    AfterForwardStep afterForwardStep;
    GameModel gameModel;
    Player player;

    FillGameSquare fillGameSquare;

    public UpdateGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();

        fillGameSquare = new FillGameSquare(gameModel);
        afterForwardStep = new AfterForwardStep(gameModel);
    }

    public void moveForward(Location location) {
        afterForwardStep.setLocation(location);
        afterForwardStep.updateBeforeStep();
        afterForwardStep.updateAfterStep();
        fillGameSquare.printStepInGameSquare();
    }

    public void moveBack() {
    }

}
