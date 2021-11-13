/*
package game.move.seal;

import game.Game;
import game.gamerepo.player.Player;

public class SealVisitedArea implements UpdateableLocation {

    Game game;
    Player player;
//    RobotMemory robotMemory;

    public SealVisitedArea(Game game) {//, RobotMemory robotMemory
        this.game = game;
        this.player = game.getPlayer();
//        this.robotMemory = robotMemory;
    }

  */
/*  @Override
    public void updateSeal(boolean area[][], Signature signature) {
//        game.getModel().getVisitedAreas()[player.getLocation().getX()][player.getLocation().getY()] = seal;
        area[game.getPlayer().getLocation().getX()][game.getPlayer().getLocation().getY()] = signature.isSealed();
    }*//*


    @Override
    public void updateLocationCondition(boolean[][] area, Signature signature) {
//        ErrorMessage.appearFatalError(getClass(), "updateLocationCondition()   -->   function is empty  ");
//        game.getModel().getVisitedAreas()[player.getLocation().getX()][player.getLocation().getY()] = signature.isSealed();
        area[game.getPlayer().getLocation().getX()][game.getPlayer().getLocation().getY()] = signature.isSealed();
        System.out.println("AAAAAAAAAAA");
    }
}
*/
