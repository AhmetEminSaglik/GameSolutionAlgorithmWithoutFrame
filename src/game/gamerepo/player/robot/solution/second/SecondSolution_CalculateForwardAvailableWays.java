package game.gamerepo.player.robot.solution.second;

import game.Game;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.Location;
import game.move.fundamental.secondsolutionforrobot.MoveBackSecondSolution;
import game.move.fundamental.secondsolutionforrobot.MoveForwardSecondSolution;

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
