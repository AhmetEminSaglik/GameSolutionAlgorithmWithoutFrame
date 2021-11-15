package game.move;

import errormessage.ErrorMessage;
import errormessage.joptionpanel.ShowPanel;
import game.gamerepo.FillGameSquare;
import game.gamerepo.updategamemodel.UpdateValuesInGameModel;
import compass.Compass;
import game.Game;
import game.location.DirectionLocation;
import game.play.SelectFirstSqaureToStart;
import sleep.Sleep;
import validation.Validation;

import javax.swing.*;


public abstract class Move implements IMove { // ICalculateMove 

    Game game;
    Compass compass; //= new KeyboardCompass();
    Validation validation = new Validation();
    UpdateValuesInGameModel updateValuesInGameModel;
    private FillGameSquare fillGameSquare;

    DirectionLocation directionLocation;
//    private Location location;

    public Move(Game game) {//, DirectionLocation proceedLocation
        this.game = game;
        compass = game.getPlayer().getCompass();
        fillGameSquare = new FillGameSquare(game);
    }
    public final void move(DirectionLocation directionLocation) {
        if (game.getPlayer().getStep() == 1 && getClass().equals(MoveBack.class)) {
            changeStartLocationSpecialMovement();
        } else {
            setLocation(directionLocation);
            updateBeforeStep();
            updatePlayerStepValue();
            updateAfterStep();
            fillGameSquare.printStepInGameSquare();
        }
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
//            e.printStackTrace();
            }
        }else{
//            JOptionPane.showMessageDialog(null, " Y siniri asti ");
            ShowPanel.show(getClass(), " Y siniri asti ");
        }

    }

    void printLocationOfStep1() {
        for (int j = game.getModel().getGameSquares().length - 1; j >= 0; j--) {
            for (int i = 0; i < game.getModel().getGameSquares()[j].length; i++) {
                if (game.getModel().getGameSquares()[j][i] == 1) {
                    JOptionPane.showMessageDialog(null, "ADIM 1 LOCASIYONU : " + j + " " + i);
                    return;
                }
            }
            System.out.println();
        }
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

    public FillGameSquare getFillGameSquare() {
        return fillGameSquare;
    }
}
