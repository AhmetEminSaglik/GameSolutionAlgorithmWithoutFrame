package game.move;

import game.gamerepo.FillGameSquare;
import game.gamerepo.updategamemodel.UpdateValuesInGameModel;
import compass.Compass;
import game.Game;
import game.location.DirectionLocation;
import validation.Validation;

public abstract class Move implements IMove { // ICalculateMove 

    Game game;
    Compass compass; //= new KeyboardCompass();
    Validation validation = new Validation();
    UpdateValuesInGameModel updateValuesInGameModel;
    FillGameSquare fillGameSquare;

    DirectionLocation directionLocation;
//    private Location location;

    public Move(Game game) {//, DirectionLocation proceedLocation
        this.game = game;
        compass = game.getPlayer().getCompass();
        fillGameSquare = new FillGameSquare(game);
    }

    public final void move(DirectionLocation directionLocation) {

        // System.out.println("Chose Location : " + location.toString());
        setLocation(directionLocation);
        updateBeforeStep(directionLocation);
        updatePlayerStepValue();
        updateAfterStep();
        fillGameSquare.printStepInGameSquare();

    }

    @Override
    public void updateVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }

    public DirectionLocation getDirectionLocation() {
        return directionLocation;
    }

    public void setLocation(DirectionLocation directionLocation) {
        this.directionLocation = directionLocation;
    }

    @Override
    public String toString() {
        return "Move{" + "game=" + game + ", compass=" + compass + ", validation=" + validation + ", updateValuesInGameModel=" + updateValuesInGameModel + ", fillGameSquare=" + fillGameSquare + ", directionLocation=" + directionLocation + '}';
    }


}
