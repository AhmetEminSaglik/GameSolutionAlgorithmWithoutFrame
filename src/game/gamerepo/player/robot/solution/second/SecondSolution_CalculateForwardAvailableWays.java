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

        MathFunctionSecondSolution mathFunctionSecondSolution = new MathFunctionSecondSolution(game, playerLocation);

        return mathFunctionSecondSolution.calculateFunctionResult();
    }

    @Override
    public void buildRobotMove() {
        setMoveForward(new MoveForwardSecondSolution(getGame()));
        setMoveBack(new MoveBackSecondSolution(getGame()));
    }
}
