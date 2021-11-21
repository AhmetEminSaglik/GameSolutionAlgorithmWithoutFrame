package game.gamerepo.player.robot.solution.second;

import check.forwardlocation.ForwardLocation;
import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.move.fundamental.MoveBack;
import game.move.fundamental.MoveForward;
import game.move.fundamental.secondsolutionforrobot.MoveBackSecondSolution;
import game.move.fundamental.secondsolutionforrobot.MoveForwardSecondSolution;

import java.util.ArrayList;

public class SecondSolution_CalculateForwardAvailableWays extends BaseSolution {
    public SecondSolution_CalculateForwardAvailableWays(Game game) {
        super(game);

    }

    @Override
    public int getLocationInput(Game game) {//, RobotMemory robotMemory

        ArrayList<DirectionLocation> locationsList = new LocationsList().getList();
        ForwardLocation forwardLocation = new ForwardLocation();
        Location playerLocation = checkSquare.getPlayerLocation(game);

        MathFunction mathFunction = new MathFunction(game, playerLocation);

        int newLocation = mathFunction.calculateFunctionResult(((Robot) game.getPlayer()).getRoadMemory().getExitSituation());
//        ShowPanel.show(getClass(), "newLocation : " + newLocation);
        return newLocation;

  /*      for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {//, robotMemory
           *//*     System.out.println("Available location  for  " +
                        locationsList.get(i).getClass().getSimpleName() + " : " + locationsList.get(i) + " : "
                        + forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, locationsList.get(i))       );*//*
//                return locationsList.get(i).getId();
            }
        }*/

   /*     ShowPanel.show(getClass(), "islemler bitti");
        ErrorMessage.appearFatalError(getClass(),"ISLEMLER BURADA BITTI O YUZDEN PROGRAM DURDURULACKTIR");
        return 0;*/
    }

    @Override
    public void buildRobotMove() {
        setMoveForward(new MoveForwardSecondSolution(getGame()));
        setMoveBack(new MoveBackSecondSolution(getGame()));
    }
}
