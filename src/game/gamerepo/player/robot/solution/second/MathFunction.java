package game.gamerepo.player.robot.solution.second;

import check.forwardlocation.ForwardLocation;
import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.robot.solution.second.navigation.ExitSituation;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import squareprocess.SquareProcess;
import weights.Weight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MathFunction {
    final int MOVE_BACK = -1, MOVE_FORWARD = 1;

    Game game;
    Location playerLocation;
    ArrayList<DirectionLocation> locationsList = new LocationsList().getList();
    DirectionLocation selectedDirection=locationsList.get(locationsList.size()-1);
    SquareProcess squareProcess = new SquareProcess();
    Weight weight = new Weight();

    int oneWayNumbersValue;

    public MathFunction(Game game, Location playerLocation) {
        this.game = game;
        this.playerLocation = playerLocation;
    }

    public int calculateFunctionResult(ExitSituation exitSituation) {
        calculateForwardAvailableDirectionsOfCurrentDirection();


        if (calculateDeadlyPoint(exitSituation) > 0) {
//            calculateDirectionLocationToMove();
            //Calculate Which will be next SquareMOVE FORWARD
        } else {
            //MOVE BACK
        }
//        System.out.println("secilen direction name : "+selectedDirection.toString());
        return selectedDirection.getId();

    }

    int calculateDeadlyPoint(ExitSituation exitSituation) {
        int calculation = 1 - (exitSituation.getSituation() + oneWayNumbersValue) / 2;
        return decideDeadlyPointCalculation(calculation);

    }

    int decideDeadlyPointCalculation(int calculation) {
        if (calculation >= 0)
            return MOVE_FORWARD;
        return MOVE_BACK;
    }

    void calculateForwardAvailableDirectionsOfCurrentDirection() {

        double weightResult = -1;
        ForwardLocation forwardLocation = new ForwardLocation();

        Map<DirectionLocation, Integer> forwardLocationMap = new HashMap<>();
        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {//, robotMemory
                DirectionLocation location = locationsList.get(i);

                int availableWayNumber = forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, location);
                if (weight.getWeightOfDirection()[availableWayNumber] > weightResult) {
                    weightResult = weight.getWeightOfDirection()[availableWayNumber];
                    selectedDirection = location;
                }

                forwardLocationMap.put(location, availableWayNumber);
//                forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, locationsList.get(i));
                if (availableWayNumber == 1) {
                    oneWayNumbersValue++;
                }
            }
        }
//        printMap(forwardLocationMap);


     /*   System.out.println("Selected Direction : " + selectedDirection.getId());
        System.out.println("weightResult : " + weightResult);*/
//        ShowPanel.show(getClass(), " Map ekleme islemi bitti  directionlar ve degerleri yazdirilmis olmali >>>> Toplam OWN : " + oneWayNumbersValue);


    }


    void printMap(Map<DirectionLocation, Integer> map) {
        for (Map.Entry<DirectionLocation, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().getId() + " : " + entry.getValue());
        }
    }
}
