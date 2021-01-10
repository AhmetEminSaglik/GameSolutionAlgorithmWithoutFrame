package move;

import Game.updategamemodel.UpdateGameModel;
import Game.GameModel;
import compass.Compass;
import compass.KeyboardCompass;
import location.Location;
import play.ICalculateMove;
import validation.Validation;

public abstract class Move implements ICalculateMove {

    GameModel gameModel;
    UpdateGameModel updateGameModel;
    Compass compass = new KeyboardCompass();
    Validation validation = new Validation();

    public Move(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public abstract void move(Location location);

}
