package validation;

import Game.GameModel;
import Game.player.Player;
import compass.Compass;
import location.Location;
import location.SwitchDirection;
import errormessage.ClassicErrorMessage;
import errormessage.FatalErrorMessage;

public class Validation {

    private Compass compass;
    private SwitchDirection switchDirection;

    public static boolean validateSquareNumbers(int number) {

        final int minimum = 4;

        if (number > minimum) {
            return true;
        }

        return false;
    }

    /**
     * if value is positive return true else return false
     */
    boolean needToCalculateBySum(int value) {

        if (value >= 0) {
            return true;
        }
        return false;
    }

    /**
     * Instead of coding to calculate both X and Y, one code and calculate
     * player.X and direction. X or Y. It is belong to which direction you send
     */
    boolean calculateValidOrNot(int maxSquare, int location, int value) {
        if (needToCalculateBySum(value)) {
            if (location + value < maxSquare) {
                return true;
            }
        } else {
            if (location + value >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param input = Keyboards input direction value
     */
    public boolean isInputValidForArray(GameModel gameModel, int input) {

        Location location;
        Player player = gameModel.getPlayer();
        //  System.out.println("BBBB");
        try {
            /*  System.out.println("Compass : " + compass);
            System.out.println("COMPASS /// " + compass.getClass().getSimpleName());*/

            //  switchDirection = new SwitchDirection(compass);
            //System.out.println("ONEMLIII  " + compass.getClass().getSimpleName());
            switchDirection = new SwitchDirection(compass);
            location = Location.getLocation(compass, input);// switchDirection.choseDirection(input);

            if (calculateValidOrNot(gameModel.getGameSquares().length, player.getLocationX(), location.getX())
                    && calculateValidOrNot(gameModel.getGameSquares().length, player.getLocationY(), location.getY())) {
                return true;
            }
        } catch (Exception ex) {

            new ClassicErrorMessage().showMessage(ex.getMessage());
        }

        // new ClassicErrorMessage().showMessage("entered a number which may cause to  go out ouf borders. Please enter valid value : " +input);
        return false;

    }

    public Compass getCompass() {
        return compass;
    }

    public void setCompass(Compass compass) {
        this.compass = compass;
    }
}
