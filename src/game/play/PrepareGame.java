package game.play;

import compass.Compass;
import compass.KeyboardCompass;
import game.Game;
import game.location.SwitchDirection;
import game.move.MoveForward;

public class PrepareGame {

    Game game;
    Compass compass;
    SwitchDirection switchDirection;
    SelectFirstSqaureToStart selectFirstSqaureToStart;

    public PrepareGame(Game game) {

        fillNullReferans(game);
        prepareToPlay();

    }

    void fillNullReferans(Game game) {
        this.game = game;

        selectFirstSqaureToStart = new SelectFirstSqaureToStart(game);
        compass = game.getPlayer().getCompass();
    }

    void prepareToPlay() {
        switchDirection = new SwitchDirection(compass);
        selectFirstSqaureToStart.selectSquareStart(0, 0);
        selectFirstSqaureToStart.locateThePlayer();
    }

}
