package game.gamerepo;

import game.Game;
import game.location.CreateLocation;
import game.location.Location;

public class CreateLocationOfLastStep {

    Game game;

    public CreateLocationOfLastStep(Game game) {
        this.game = game;
    }

    public Location createLastStepLocation() {
        GameModelProcess gameModelProcess = new GameModelProcess(game);
        gameModelProcess.calculateIndexOfGivenStepInGameSquareArrays(game.getPlayer().getStep() - 1);
        // System.out.println("ARANAN STEP >>>> " + (gameModel.getPlayer().getStep() - 1));
        CreateLocation createLocation = new CreateLocation();
        /*    System.out.println("/////////////////////////");
        System.out.println("player X : " + gameModel.getPlayer().getLocationX() + "  islem X : " + (-gameModelProcess.getX()));
        System.out.println("player Y : " + gameModel.getPlayer().getLocationY() + "  islem Y : " + (-gameModelProcess.getY()));
        System.out.println(" Sonuc X : " + getOppositeValue(gameModel.getPlayer().getLocationX(), gameModelProcess.getX())); //(gameModel.getPlayer().getLocationX() - gameModelProcess.getX())
        System.out.println(" Sonuc Y : " + getOppositeValue(gameModel.getPlayer().getLocationY(), gameModelProcess.getY()));
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\ ");
         */ createLocation.setX(getOppositeValue(game.getPlayer().getLocationX(), gameModelProcess.getX()));
        createLocation.setY(getOppositeValue(game.getPlayer().getLocationY(), gameModelProcess.getY()));
        return createLocation;

    }

    int getOppositeValue(int a, int b) {
        return -(a - b);

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
