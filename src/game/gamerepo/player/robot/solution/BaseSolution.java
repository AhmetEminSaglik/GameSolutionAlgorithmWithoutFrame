package game.gamerepo.player.robot.solution;

import check.CheckSquare;
import game.Game;
import game.gamerepo.player.robot.RobotMemory;
import game.location.DirectionLocation;

public abstract class BaseSolution {

    CheckSquare checkSquare = new CheckSquare();

    public abstract int getLocationInput(Game game, RobotMemory robotMemory);

    public boolean isThereAnySquareToMoveInIt(Game game, DirectionLocation location, RobotMemory robotMemory) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> BAKILACAK ADIM SAYUISI : "+game.getPlayer().getStep());
        if (checkSquare.isSquareAvailableToMoveOnIt(game, location.getId())
            && !robotMemory.getVisitedDirections()[game.getPlayer().getStep()][location.getId()]) {
            return true;
        }
        System.out.println("SUAN TEST ASAMASI  step : "+game.getPlayer().getStep()+ "   >>>>>>  gidilebilecek yer yok "+location.getClass().getSimpleName());
        return false;

    }

}
