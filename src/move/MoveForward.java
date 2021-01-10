package move;

import Game.updategamemodel.UpdateGameModel;
import Game.GameModel;
import location.Location;
import play.CheckSquare;

public class MoveForward extends Move {

    GameModel gameModel;
    UpdateGameModel updateGameModel;

    public MoveForward(GameModel gameModel) {
        super(gameModel);
        updateGameModel = new UpdateGameModel(gameModel);

    }

    @Override
    public void move(Location location) {

        updateGameModel.moveForward(location);
    }

    @Override
    public boolean isItAvailableToMove(GameModel gameModel, int choose) {
        validation.setCompass(compass);

        CheckSquare checkSquare = new CheckSquare();
        checkSquare.setCompass(compass);

        if (validation.isInputValidForArray(gameModel, choose)
                && checkSquare.isSquareAvailableToMoveOnIt(gameModel, choose)) {
            return true;
        }
        return false;
    }

}
