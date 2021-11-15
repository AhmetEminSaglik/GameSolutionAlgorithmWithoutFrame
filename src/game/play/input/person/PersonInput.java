package game.play.input.person;

import check.CheckSquare;
import compass.Compass;
import compass.KeyboardCompass;
import game.Game;
import game.play.input.BaseControlInput;
import validation.Validation;

import javax.swing.*;

public class PersonInput extends BaseControlInput implements IPlayerInput {

    CheckSquare checkSquare = new CheckSquare();
    Compass compass = new KeyboardCompass();

    private SafeScannerInput scannerInput = new SafeScannerInput();

    public PersonInput(Game game) {
        super(game);
    }

    
    @Override
    public int getInput() {
        while (true) {

            int choose = scannerInput.getInput();
            if (isMoveableDirectionInput(choose)) {
                return choose;
            } else {
                System.out.println("You can not  go that direction, please choose another direction");// + new Location().getLocationFromCompass(compass, choose).toString()
            }
        }
    }

    @Override
    public boolean isInputSuitableToMoveForward(Game game, int choose) {
        return checkInputForForward(game, choose);
    }

    boolean checkInputForForward(Game game, int choose) {
        Validation validation = new Validation();
        Compass compass = new KeyboardCompass();

        validation.setCompass(compass);
        CheckSquare checkSquare = new CheckSquare();
        checkSquare.setCompass(compass);

        if (validation.isInputValidForArray(game, choose)
                && checkSquare.isSquareFreeFromVisitedArea(game, choose)) {
            return true;

        }
//        JOptionPane.showMessageDialog(null," 1 : "+validation.isInputValidForArray(game, choose));
//        JOptionPane.showMessageDialog(null," 1 : "+checkSquare.isSquareFreeFromVisitedArea(game, choose));
        return false;
    }

    @Override
    public boolean isInputSuitableToMoveBack(Game game, int choose) {
        return checkInputForBack(game, choose);
    }

    boolean checkInputForBack(Game game, int choose) {
        if (choose == new KeyboardCompass().getLastLocation() && game.getPlayer().getStep() > 1) {
            //System.out.println("geldi");
            return true;
        }
        return false;
    }

    public boolean isMoveableDirectionInput(int choose) {
        if (isInputSuitableToMoveForward(game, choose) || isInputSuitableToMoveBack(game, choose)) {
            return true;
        }
        return false;
    }
//    @Override
//    public int getSafeInput(Model gameModel) {
//        while (true) {
//            int input = scannerInput.getInput();
//            if (checkSquare.isSquareFreeFromVisitedArea(gameModel, input)) {
//
//                return input;
//            }
//        }
//
//    }

}
