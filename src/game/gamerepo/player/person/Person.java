package game.gamerepo.player.person;

import compass.Compass;
import compass.KeyboardCompass;
import game.Game;
import game.gameover.PersonGameOver;
import game.gamerepo.player.Player;
import game.play.input.person.PersonInput;
import game.rule.BaseGameRule;

public class Person extends Player {

    @Override
    public Compass getCompass() {
        return new KeyboardCompass();
    }

    public final Compass compass = new KeyboardCompass();

    @Override
    public int getInput(Game game) {
        return new PersonInput(game).getInput();
    }

//    @Override
//    public Location getLocationValueAccordingToInputValue(Game game, int choose) {
//        if (choose == game.getPlayer().getCompass().getLastLocation()) {
//            System.out.println(">>>>>>>>>>>>>>>>> IF DE  PERSON");
//            System.out.println("choose : " + choose);
//            return new CreateLocationOfLastStep(game).createLastStepLocation();
//        }
//        System.out.println(">>>>>>>>>>>>>>>>> ELSE DE  PERSON ");
//        return new SwitchDirection(new KeyboardCompass()).choseDirection(choose);
//    }
    @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new PersonGameOver());

        }
        return gameRule;
    }

}
