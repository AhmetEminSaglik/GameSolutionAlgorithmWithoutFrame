package game.play.input;

import check.CheckSquare;
import compass.Compass;
import compass.KeyboardCompass;
import game.Game;
import game.gamerepo.Model;
import validation.Validation;

public class PersonInput extends BaseControlInput {

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
                System.out.println("You cant go that direction, please choose another direction");// + new Location().getLocationFromCompass(compass, choose).toString()
            }
        }
    }

    @Override
    public boolean isInputSuitableToMoveForward(Game game, int choose) {

        Validation validation = new Validation();
        Compass compass = new KeyboardCompass();

        validation.setCompass(compass);
        CheckSquare checkSquare = new CheckSquare();
        checkSquare.setCompass(compass);

        if (validation.isInputValidForArray(game, choose)
                && checkSquare.isSquareAvailableToMoveOnIt(game, choose)) {
            return true;

        }
        return false;
    }

    @Override
    boolean isInputSuitableToMoveBack(Game game, int choose) {
        if (choose == new KeyboardCompass().getLastLocation() && game.getPlayer().getStep() > 1) {
            System.out.println("geldi");
            return true;
        }
        return false;
    }

    boolean isMoveableDirectionInput(int choose) {
        if (isInputSuitableToMoveForward(game, choose) || isInputSuitableToMoveBack(game, choose)) {
            return true;
        }
        return false;
    }
//    @Override
//    public int getSafeInput(Model gameModel) {
//        while (true) {
//            int input = scannerInput.getInput();
//            if (checkSquare.isSquareAvailableToMoveOnIt(gameModel, input)) {
//
//                return input;
//            }
//        }
//
//    }

}
