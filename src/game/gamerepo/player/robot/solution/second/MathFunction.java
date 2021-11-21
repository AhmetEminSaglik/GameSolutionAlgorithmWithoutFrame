package game.gamerepo.player.robot.solution.second;

import check.forwardlocation.ForwardLocation;
import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.second.navigation.ExitSituation;
import game.gamerepo.player.robot.solution.second.navigation.Navigation;
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
    final DirectionLocation lastLocation = locationsList.get(locationsList.size() - 1);
    DirectionLocation selectedDirection = lastLocation;
    SquareProcess squareProcess = new SquareProcess();
    Weight weight = new Weight();
    Robot robot;
    DirectionLocation compulsoryLocation;

    int oneWayNumbersValue;

    public MathFunction(Game game, Location playerLocation) {
        this.game = game;
        this.playerLocation = playerLocation;
        robot = (Robot) game.getPlayer();
    }

    public int calculateFunctionResult(ExitSituation exitSituation) {
        calculateForwardAvailableDirectionsOfCurrentDirection();

        Navigation checkNavigation = null;
        if (robot.getRoadMemory().getOneWayNumbersList().size() >0) {
            checkNavigation = robot.getRoadMemory().getOneWayListLastItem();
        }

        if (checkNavigation != null && checkNavigation.getStep() == robot.getStep()) {
            if (checkNavigation.getCompulsoryLocation() != null &&
                    checkNavigation.getCompulsoryLocation() != lastLocation) {

            selectedDirection = checkNavigation.getCompulsoryLocation();
            checkNavigation.setCompulsoryLocation(lastLocation);
        }

        } else if (calculateDeadlyPoint(exitSituation) > 0) {


            if (oneWayNumbersValue >= 3) {
                selectedDirection = lastLocation;

            } else if (oneWayNumbersValue == 2 && exitSituation.getSituation() == ExitSituation.EXIT_FREE) {

                robot.getRoadMemory().getExitSituation().setSituation(ExitSituation.EXIT_LOCATED);
                Navigation navigation = buildNavigation(robot.getStep(), oneWayNumbersValue, compulsoryLocation, true);
                        /*new Navigation();
                navigation.setStep(robot.getStep());
                navigation.setOneWayNumbersValue(oneWayNumbersValue);
                navigation.setCompulsoryLocation(compulsoryLocation);
                navigation.setExitSituationWasLocatedInThisStep(true);*/

                robot.getRoadMemory().getOneWayNumbersList().add(navigation);
            } else if (oneWayNumbersValue == 1 && exitSituation.getSituation() == ExitSituation.EXIT_LOCATED) {
                compulsoryLocation = lastLocation;
                Navigation navigation = buildNavigation(robot.getStep(), oneWayNumbersValue, compulsoryLocation, false);
                /*navigation.setStep(robot.getStep());
                navigation.setOneWayNumbersValue(oneWayNumbersValue);
                navigation.setCompulsoryLocation(compulsoryLocation);
                navigation.setExitSituationWasLocatedInThisStep(false);*/

            } else if (oneWayNumbersValue == 1 && exitSituation.getSituation() == ExitSituation.EXIT_FREE) {
                Navigation navigation = buildNavigation(robot.getStep(), oneWayNumbersValue, compulsoryLocation, false);
                /*navigation.setStep(robot.getStep());
                navigation.setOneWayNumbersValue(oneWayNumbersValue);
//                navigation.setCompulsoryLocation(compulsoryLocation);
                navigation.setExitSituationWasLocatedInThisStep(false);*/
            }

//            calculateDirectionLocationToMove();
            //Calculate Which will be next SquareMOVE FORWARD
        } else {

            if(checkNavigation!=null &&checkNavigation.getStep()==robot.getStep()){
                robot.getRoadMemory().removeOneWayListLastItem();
            }
            //MOVE BACK
        }
//        System.out.println("secilen direction name : "+selectedDirection.toString());
        return selectedDirection.getId();

    }

    Navigation buildNavigation(int step, int oneWayNumbersValue, DirectionLocation compulsoryLocation, boolean isExitSituationWasLocatedInThisStep) {
        Navigation navigation = new Navigation();
        navigation.setStep(robot.getStep());
        navigation.setOneWayNumbersValue(oneWayNumbersValue);
        if (compulsoryLocation != null) {
            navigation.setCompulsoryLocation(compulsoryLocation);
        }
        navigation.setExitSituationWasLocatedInThisStep(true);
        return  navigation;
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
                    if (oneWayNumbersValue == 2)
                        compulsoryLocation = location;
                }
            }
        }
       /* if(oneWayNumbersValue>=2){
            ShowPanel.show(getClass(),"Step : "+game.getPlayer().getStep()+"oneWayNumbersValue " +oneWayNumbersValue);
        }*/
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
