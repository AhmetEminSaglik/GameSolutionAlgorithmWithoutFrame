package move;

import Game.FillGameSquare;
import Game.GameModel;
import Game.updategamemodel.UpdateValuesInGameModel;
import compass.Compass;
import compass.KeyboardCompass;
import location.Location;
import play.ICalculateMove;
import validation.Validation;

public abstract class Move implements IMove, ICalculateMove {

    GameModel gameModel;
    Compass compass = new KeyboardCompass();
    Validation validation = new Validation();
    UpdateValuesInGameModel updateValuesInGameModel;
    FillGameSquare fillGameSquare;
    private Location location;

    public Move(GameModel gameModel) {
        this.gameModel = gameModel;
        fillGameSquare = new FillGameSquare(gameModel);
    }

    public final void move(Location location) {
        System.out.println("Chose Location : " + location.toString());
        setLocation(location);
        updateBeforeStep();
        updateAfterStep();
        fillGameSquare.printStepInGameSquare();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
