package game.gamerepo.player.robot.solution;

import check.CheckSquare;
import compass.Compass;
import compass.DirectionCompass;
import game.Game;

public abstract class BaseSolution {

    final Compass compass = new DirectionCompass();
    CheckSquare checkSquare = new CheckSquare();

    public abstract int getInputLocationId(Game game);

    public BaseSolution() {

        checkSquare.setCompass(compass);

    }

}
