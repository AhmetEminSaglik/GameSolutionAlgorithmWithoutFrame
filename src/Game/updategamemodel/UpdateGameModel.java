package Game.updategamemodel;

import Game.FillGameSquare;
import Game.GameModel;
import Game.player.Player;
import location.Location;
import play.step.StepBack;
import play.step.StepForward;

public class UpdateGameModel {

    StepForward stepForward;
    StepBack stepBack;
    // AfterStep afterStep;

    /*
    AfterForwardStep
    BeforeForwardStep
    AfterBackStep
    BeforeBackStep 
    
    yerine 
    
    afterStep
    BeforeStep yazmak istiyorum
    
    forward ya da back oldugunu interface ya da extendler le halletmem lazim
     */
    GameModel gameModel;
    Player player;

    FillGameSquare fillGameSquare;

    public UpdateGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        player = gameModel.getPlayer();

        fillGameSquare = new FillGameSquare(gameModel);
        stepForward = new StepForward(gameModel);
        stepBack = new StepBack(gameModel);
    }

    public void move(Location location) {
        stepForward.setLocation(location);
        stepForward.updateBeforeStep();
        stepForward.updateAfterStep();
        fillGameSquare.printStepInGameSquare();

    }

    public void moveForward(Location location) {
        System.out.println("Chose Location : " + location.toString());
        // gameModel.getPlayer().printPlayer();
        // location.printLocation();
        stepForward.setLocation(location);
        stepForward.updateBeforeStep();
        stepForward.updateAfterStep();
        fillGameSquare.printStepInGameSquare();
    }

    public void moveBack(Location location) {
        System.out.println("Chose Location : " + location.toString());
        stepBack.setLocation(location);
        stepBack.updateBeforeStep();
        stepBack.updateAfterStep();
        fillGameSquare.printStepInGameSquare();

    }

}
