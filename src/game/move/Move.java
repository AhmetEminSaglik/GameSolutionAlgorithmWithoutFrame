package game.move;

import errormessage.ErrorMessage;
import errormessage.joptionpanel.ShowPanel;
import game.gamerepo.FillGameSquare;
import game.gamerepo.updategamemodel.UpdateValuesInGameModel;
import compass.Compass;
import game.Game;
import game.location.DirectionLocation;
import game.move.fundamental.MoveBack;
import game.move.fundamental.MoveForward;
import game.move.fundamental.secondsolutionforrobot.MoveBackSecondSolution;
import game.move.fundamental.secondsolutionforrobot.MoveForwardSecondSolution;
import game.play.SelectFirstSqaureToStart;
import validation.Validation;


public abstract class Move implements IMove { // ICalculateMove

    public Game game;
    Compass compass;
    Validation validation = new Validation();
    public UpdateValuesInGameModel updateValuesInGameModel;
    private FillGameSquare fillGameSquare;

    DirectionLocation directionLocation;

    public Move(Game game) {
        this.game = game;
        compass = game.getPlayer().getCompass();
        fillGameSquare = new FillGameSquare(game);
    }

    @Override
    public boolean isRequiredToChangeStartLocation() {
        if (game.getPlayer().getStep() == 1 && getClass().equals(MoveBack.class))
            return true;
        return false;
    }

    public final void move(DirectionLocation directionLocation) {
        prepareAllStuff();


        if (isRequiredToChangeStartLocation()) {
            changeStartLocationSpecialMovement();
        } else {

            setLocation(directionLocation);

//            System.out.println(" MOVE ICI  oncesi degisiklik var mi ?Ilerleme Yonu : " + getDirectionLocation());
            updateBeforeStep();
            updatePlayerStepValue();
            updateAfterStep();
            fillGameSquare.printStepInGameSquare();


        }
    }

    @Override
    public void updatePlayerStepValue() {
        updateValuesInGameModel.updatePlayerStepValue();
    }

    void changeStartLocationSpecialMovement() {
        int locationX = game.getPlayer().getLocation().getX();
        int locationY = game.getPlayer().getLocation().getY();
        locationX++;
        if (locationX >= game.getModel().getGameSquares().length) {
            locationX = 0;
            locationY++;
        }

        if (locationY < game.getModel().getGameSquares().length) {

            try {
                ResetAllDataForGameAndPlayer resetData = new ResetAllDataForGameAndPlayer(game);
                resetData.clearPlayerData(game.getPlayer());
                resetData.clearGameData(game);
                SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
                selectFirstSqaureToStart.selectSquareStart(locationX, locationY);

                selectFirstSqaureToStart.locateThePlayer();
            } catch (InterruptedException e) {
                ErrorMessage.appearFatalError(getClass(), "OYUN SIFIRLAMASINDA SORUN OLDU : " + e.getMessage());

            }
        }/* else {
            ShowPanel.show(getClass(), " Y siniri asti ");
        }*/
    }

    @Override
    public void prepareAllStuff() {

    }

    @Override
    public void updateVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }

    @Override
    public void updatePlayerLocation() {
        updateValuesInGameModel.changePlayerLocation(getDirectionLocation());
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

    public FillGameSquare getFillGameSquare() {
        return fillGameSquare;
    }
}
