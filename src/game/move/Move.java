package game.move;

import game.gamerepo.FillGameSquare;
import game.gamerepo.GameModel;
import game.gamerepo.updategamemodel.UpdateValuesInGameModel;
import compass.Compass;
import compass.KeyboardCompass;
import game.location.Location;
import game.play.ICalculateMove;
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
