package validation;

import validation.Validation;
import game.gamerepo.GameModel;
import errormessage.ErrorMessage;

public class SquareValidationGame {

    int horizontalSquares;
    int verticalSquares;
    GameModel gameModel;

    public SquareValidationGame(int verticalSquares, int horizontalSquares) {

        if (new Validation().validateSquareNumbers(verticalSquares) && new Validation().validateSquareNumbers(horizontalSquares)) {
            this.verticalSquares = verticalSquares;
            this.horizontalSquares = horizontalSquares;

        } else {

            String message = "For both squares must be bigger than 4";
            new ErrorMessage().appearFatalError(message);

        }

    }

}
