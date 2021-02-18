package validation;

import game.gamerepo.player.Player;
import compass.Compass;
import errormessage.ErrorMessage;
import game.Game;
import game.location.DirectionLocation;
import game.location.Location;

public class Validation {

    private Compass compass;
    //   private SwitchDirection switchDirection;

    public boolean validateSquareNumbers(int number) {

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
     *
     * @param input = Keyboards input direction value
     */
    public boolean isInputValidForArray(Game game, int input) {

        Location location;
        Player player = game.getPlayer();
        compass = game.getPlayer().getCompass();
        location = DirectionLocation.getLocationFromCompass(compass, input);
        try {

            // ??? HATA CIKARSA BUNU AKTIFLESTIR  switchDirection = new SwitchDirection(compass); 
            // switchDirection.choseDirection(input);
            if (calculateValidOrNot(game.getModel().getGameSquares().length, player.getLocation().getX(), location.getX())
                    && calculateValidOrNot(game.getModel().getGameSquares().length, player.getLocation().getY(), location.getY())) {

                return true;
            }
        } catch (Exception ex) {
            System.out.println("HATAAAAAAAAAAAAAAAAAAAAAAAAAAAA : ::::: " + ex.getMessage());

            System.out.println("player.getLocation().getX() : " + player.getLocation().getX() + " location.getX() : " + location.getX());

            System.out.println("player.getLocation().getY() : " + player.getLocation().getY() + " location.getY() : " + location.getY());
            ErrorMessage.appearClassicError(getClass(), ex.getMessage());
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
