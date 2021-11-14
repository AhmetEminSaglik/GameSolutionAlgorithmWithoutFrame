package game.gamerepo.player.robot.solution;

import check.CheckSquare;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;
import game.location.DirectionLocation;

public abstract class BaseSolution {

    CheckSquare checkSquare = new CheckSquare();

    public abstract int getLocationInput(Game game, RobotMemory robotMemory);

    public boolean isSquareAvailableToMoveOnIt(Game game, DirectionLocation location, RobotMemory robotMemory) {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> BAKILACAK ADIM SAYUISI : " + game.getPlayer().getStep());
//        System.out.println("game.getPlayer().getVisitedDirections()[game.getPlayer().getStep()] > >>> " + game.getPlayer().getVisitedDirections()[game.getPlayer().getStep()].length);
//        System.out.println("location.getId() :::::> ?>>> " + location.getId());
//        if (game.getPlayer().getStep() < (int) Math.pow(game.getModel().getGameSquares().length, 2)) {
        if (checkSquare.isSquareFreeFromVisitedArea(game, location.getId())
                && checkSquare.isSquareFreeFromVisitedDirection(game, location.getId()))
            return true;

        return false;
//        }
        /*else {
            System.out.println("BEKLEMEEEEEEEEEEEEEEEEEEEEEE Adim sayisi : " + game.getPlayer().getStep());
            new Sleep().sleep(3_000);
        }*/
//        System.out.println("SUAN TEST ASAMASI  step : "+game.getPlayer().getStep()+ "   >>>>>>  gidilebilecek yer yok "+location.getClass().getSimpleName());


    }


}
