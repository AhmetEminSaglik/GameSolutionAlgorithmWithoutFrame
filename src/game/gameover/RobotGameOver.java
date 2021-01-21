package game.gameover;

import errormessage.ErrorMessage;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;

public class RobotGameOver implements IGameOver {

    Game game;
    RobotMemory robotMemory;

    public RobotGameOver(Game game) {
        this.game = game;
        robotMemory = new RobotMemory(game);
    }

    @Override
    public boolean isGameOver(Game game) {

        if (robotMemory.getVisitedDirections()[0][0] == false
                || robotMemory.getVisitedDirections()[0][1] == false
                || robotMemory.getVisitedDirections()[0][2] == false) {
            return false;
        }
        ErrorMessage.appearClassicError(getClass(), " GECICI OLARAK  YAZILDI DEGISTIRILMESI GEREKIYOR ");
        ErrorMessage.appearClassicError(getClass(), " GECICI OLARAK  YAZILDI DEGISTIRILMESI GEREKIYOR ");
        ErrorMessage.appearClassicError(getClass(), " GECICI OLARAK  YAZILDI DEGISTIRILMESI GEREKIYOR ");

        return true;
    }

}
