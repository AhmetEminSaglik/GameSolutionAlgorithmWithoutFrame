package game.location;

import compass.Compass;
import compass.DirectionCompass;
import game.Game;
import game.gamerepo.CreateLocationOfLastStep;

public class DirectionLocation extends Location {

    private Compass compass = new DirectionCompass();//= new KeyboardCompass();

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Location getLocationFromCompass(Compass compass, int directionIndex) {
        // System.out.println("" + compass.toString()+" / "+compass);
        //System.out.println(">>>|||  directionIndex " + directionIndex + " compass :" + compass);
        return new SwitchDirection(compass).choseDirection(directionIndex);
    }

    public DirectionLocation getLocationValueAccordingToEnteredValue(Game game, int choose) {
        if (choose == game.getPlayer().getCompass().getLastLocation()) {
//            System.out.println("IF DEEEEE ");
            return new CreateLocationOfLastStep(game).createLastStepLocation();
        }

//        System.out.println("ELSE DEE E");
        return new SwitchDirection(game.getPlayer().getCompass()).choseDirection(choose);

    }

    /**
     * Eger burada pusulayi oyuncu pusulasina gore ayarlayabilirsem her sey cok
     * guzel olacak
     */
    public Compass getCompass() {
        return compass;
    }

    public void setCompass(Compass compass) {
        this.compass = compass;
    }

    @Override
    public String toString() {
        return "DirectionLocation{" +
                "id=" + id +" X "+getX()+"" +
                "Y "+getY()+
                '}';
    }
}
