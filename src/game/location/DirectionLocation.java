package game.location;

import compass.Compass;
import game.Game;
import game.gamerepo.CreateLocationOfLastStep;
import game.location.direction.DirectionCompassValues;

public class DirectionLocation extends Location {

    public DirectionCompassValues directionCompassValue = new DirectionCompassValues();

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Location getLocationFromCompass(Compass compass, int directionIndex) {
        return new SwitchDirection(compass).choseDirection(directionIndex);
    }

    public Location getLocationValueAccordingToEnteredValue(Game game, int choose) {
        if (choose == game.getPlayer().getCompass().getLastLocation()) {
            System.out.println("IF DEEEEE ");
            return new CreateLocationOfLastStep(game).createLastStepLocation();
        }

        System.out.println("ELSE DEE E");
        return new SwitchDirection(game.getPlayer().getCompass()).choseDirection(choose);

    }

}
