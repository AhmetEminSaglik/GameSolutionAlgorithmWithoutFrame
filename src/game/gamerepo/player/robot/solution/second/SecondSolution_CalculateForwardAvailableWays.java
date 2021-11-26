package game.gamerepo.player.robot.solution.second;

import check.forwardlocation.ForwardLocation;
import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.move.fundamental.secondsolutionforrobot.MoveBackSecondSolution;
import game.move.fundamental.secondsolutionforrobot.MoveForwardSecondSolution;

import java.util.ArrayList;

public class SecondSolution_CalculateForwardAvailableWays extends BaseSolution {
    public SecondSolution_CalculateForwardAvailableWays(Game game) {
        super(game);
    }

    @Override
    public int getLocationInput(Game game) {

        Location playerLocation = checkSquare.getPlayerLocation(game);

        MathFunction mathFunction = new MathFunction(game, playerLocation);

        int newLocation = mathFunction.calculateFunctionResult();
        return newLocation;
    }

    @Override
    public void buildRobotMove() {
        setMoveForward(new MoveForwardSecondSolution(getGame()));
        setMoveBack(new MoveBackSecondSolution(getGame()));
    }
}
