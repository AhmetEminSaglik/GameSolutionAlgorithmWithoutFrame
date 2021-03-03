package game.move;

import game.gamerepo.FillGameSquare;
import game.gamerepo.updategamemodel.UpdateValuesInGameModel;
import compass.Compass;
import compass.KeyboardCompass;
import game.Game;
import game.location.DirectionLocation;
import game.location.Location;
import validation.Validation;

public abstract class Move implements IMove { // ICalculateMove 

    Game game;
    Compass compass; //= new KeyboardCompass();
    Validation validation = new Validation();
    UpdateValuesInGameModel updateValuesInGameModel;
    FillGameSquare fillGameSquare;

    DirectionLocation proceedLocation;
    private Location location;

    public Move(Game game) {//, DirectionLocation proceedLocation
        this.game = game;
        compass=game.getPlayer().getCompass();
        fillGameSquare = new FillGameSquare(game);
    }

    public final void move(DirectionLocation location) {

        // System.out.println("Chose Location : " + location.toString());
        setLocation(location);
        updateBeforeStep(location);
        updateAfterStep();
        fillGameSquare.printStepInGameSquare();

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Move{" + "game=" + game + ", compass=" + compass + ", validation=" + validation + ", updateValuesInGameModel=" + updateValuesInGameModel + ", fillGameSquare=" + fillGameSquare + ", location=" + location + '}';
    }

}
