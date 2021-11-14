package game.move;

import errormessage.ErrorMessage;
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
    FillGameSquare fillGameSquare;

    DirectionLocation directionLocation;
//    private Location location;

    public Move(Game game) {//, DirectionLocation proceedLocation
        this.game = game;
        compass = game.getPlayer().getCompass();
        fillGameSquare = new FillGameSquare(game);
    }

    void changeStartLocationSpecialMovement() {
        int locationX = game.getPlayer().getLocation().getX();
        int locationY = game.getPlayer().getLocation().getY();
        JOptionPane.showMessageDialog(null," AAA locasyonlar X:"+locationX+" / Y :"+locationY);
        locationX++;
        JOptionPane.showMessageDialog(null," BBB locasyonlar X:"+locationX+" / Y :"+locationY);
        if (locationX >= game.getModel().getGameSquares().length) {
            locationX = 0;
            locationY++;
            JOptionPane.showMessageDialog(null," CCC locasyonlar X:"+locationX+" / Y :"+locationY);
            if (locationY >= game.getModel().getGameSquares().length) {
                JOptionPane.showMessageDialog(null," DDD locasyonlar X:"+locationX+" / Y :"+locationY);
                ErrorMessage.appearFatalError(getClass(), " butun bolgeler denenmistir program kapanacaktir");
            }
        }
        JOptionPane.showMessageDialog(null,"EEE locasyonlar X:"+locationX+" / Y :"+locationY);
        try {
//            JOptionPane.showMessageDialog(null, "SUanki game  adress  RESET ONCESI: " + game.toString());
            ResetAllDataForGameAndPlayer resetData = new ResetAllDataForGameAndPlayer(game);

//            resetData.clearPlayerData(game.getPlayer());
            resetData.clearPlayerData(game.getPlayer());
            resetData.clearGameData(game);


            SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);

            selectFirstSqaureToStart.selectSquareStart(locationX, locationY);
            JOptionPane.showMessageDialog(null," HEsaplanilan yeni locasyonlar X:"+locationX+" / Y :"+locationY);

            new MoveForward(game).move(selectFirstSqaureToStart);
//            JOptionPane.showMessageDialog(null, "SUanki game  adress  RESET SONRASI ILERLENILEN GAME : " + game.toString());
        } catch (InterruptedException e) {
            ErrorMessage.appearFatalError(getClass(), "OYUN SIFIRLAMASINDA SORUN OLDU : " + e.getMessage());
//            e.printStackTrace();
        }
        System.out.println("LOCATION DEGISTIIIIIIIIIIIIIII");
        new Sleep().sleep(5_000);

    }

//static int counter=0;
    public final void move(DirectionLocation directionLocation) {

        if (game.getPlayer().getStep() == 1 && getClass().equals(MoveBack.class)) {
//            counter++;
//            JOptionPane.showMessageDialog(null," adim sayisi 1 ve geri adim istegi gelme sayisi : "+counter);
//            changeStartLocationSpecialMovement();
//            JOptionPane.showMessageDialog(null, " MOVE.move() a ozel duruma  GIRDIIIIIIIIIIIIIIIII bak bakayim ne halde yeni durumu");
            System.out.println("s");
        } else {
//            System.out.println("Chose Location : " + directionLocation.toString());
            setLocation(directionLocation);
            updateBeforeStep(directionLocation);
            updatePlayerStepValue();
            updateAfterStep();
            fillGameSquare.printStepInGameSquare();
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


}
