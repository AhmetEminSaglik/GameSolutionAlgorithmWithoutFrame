package game.gamerepo.player.robot.solution.second;

import check.forwardlocation.ForwardLocation;
import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.second.navigation.ExitSituation;
import game.gamerepo.player.robot.solution.second.navigation.Navigation;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.location.direction.LastLocation;
import print.PrintAble;
import squareprocess.SquareProcess;
import weights.Weight;

import java.util.ArrayList;

public class MathFunction {
    final int IS_DEAD_SO_MOVE_BACK = -1, IS_FREE_SO_MOVE_FORWARD = 1;

    Game game;
    Location playerLocation;
    ArrayList<DirectionLocation> locationsList = new LocationsList().getList();
    final DirectionLocation lastLocation = new LocationsList().getLastLocation();// locationsList.get(locationsList.size() - 1);
    DirectionLocation selectedDirection = lastLocation;
    SquareProcess squareProcess = new SquareProcess();
    Weight weight = new Weight();
    Robot robot;
    final int edgeValue;
    DirectionLocation compulsoryLocation = null;
    Navigation navigation = new Navigation();
    PrintAble printAble;
    int oneWayNumbersValue;
    boolean killRequestByAvailableProcessFunction = false;

    public MathFunction(Game game, Location playerLocation) {
        this.game = game;
        this.playerLocation = playerLocation;
        robot = (Robot) game.getPlayer();
        edgeValue = game.getModel().getGameSquares().length;

    }


    public int calculateFunctionResult() {


        if (isNavigationInRoadMemoryAvailableForThisStep()) {
            if (navigation.getOneWayNumbersValue() == 1 &&
                    robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED
                    && !navigation.isExitSituationWasLocatedInThisStep()) {
                navigation.setCompulsoryLocation(new LastLocation());
            }
            if (navigation.getCompulsoryLocation() != null) {
                selectedDirection = navigation.getCompulsoryLocation();
                return selectedDirection.getId();
            }

        }
        calculateForwardAvailableDirectionsOfCurrentDirection();
        double calculationDeadlyPoint = calculateDeadlyPoint();

        if (calculationDeadlyPoint == IS_FREE_SO_MOVE_FORWARD) {

            navigation = buildNavigation();
            addNavigationToRoadMemoryList();
        } else {
            selectedDirection = lastLocation;
        }

        return selectedDirection.getId();
    }


    boolean isNavigationInRoadMemoryAvailableForThisStep() {
        navigation = getLastNavigationFromRoadMemory();
        if (navigation != null && navigation.getStep() == robot.getStep()) {
            return true;
        }
        return false;
    }

    Navigation getLastNavigationFromRoadMemory() {
        if (robot.getRoadMemory().getOneWayNumbersList().size() > 0) {
            return robot.getRoadMemory().getOneWayListLastItem();
        }
        return null;
    }


    Navigation buildNavigation() {
        Navigation navigation = new Navigation();

        navigation.setStep(robot.getStep());

        navigation.setOneWayNumbersValue(oneWayNumbersValue);

        if (compulsoryLocation != null) {
//            System.out.println("AAAAAAAAAAAAAAAAAAA step : " + robot.getStep());
            navigation.setCompulsoryLocation(compulsoryLocation);
        }


        return navigation;
    }


    void calculateForwardAvailableDirectionsOfCurrentDirection() {

        double weightResult = -1;
        ForwardLocation forwardLocation = new ForwardLocation();

        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {
                DirectionLocation location = locationsList.get(i);

                int availableWayNumber = forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, location);

                if (isAvailableWayEqualsToZero(availableWayNumber) && !isNextStepWillBeEqualsToTotalSquareValue()) {
                    selectedDirection = lastLocation;
                    return;
                }
                if (weight.getWeightOfDirection()[availableWayNumber] > weightResult) {
                    weightResult = calculateWeightResult(availableWayNumber);
                    selectedDirection = location;
                }

                processAccordingToOneWayNumber(availableWayNumber, location);

                if (isRequestedToKillFunctionByOneWayAvailableNumberProcess()) {

                    return;
                }

            }

        }
    }

    boolean isExitSituationLocated() {
        if (robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED)
            return true;
        return false;
    }

    void processAccordingToOneWayNumber(int availableWayNumber, DirectionLocation location) {

        if (availableWayNumber == 1) {
            oneWayNumbersValue++;

            if (isExitSituationLocated()) {
                compulsoryLocation = lastLocation;
            }
            if (oneWayNumbersValue == 2) {
                compulsoryLocation = location;
            }
            if (isOneWayNumberTooMuchToRunHealtyTheAlgorithm()) {
                selectedDirection = lastLocation;
                killRequestByAvailableProcessFunction = true;
                return;
            }
        }
    }

    boolean isRequestedToKillFunctionByOneWayAvailableNumberProcess() {
        return killRequestByAvailableProcessFunction;
    }

    boolean isAvailableWayEqualsToZero(int availableWayNumber) {
        if (availableWayNumber == 0) {
            return true;
        }
        return false;
    }

    boolean isNextStepWillBeEqualsToTotalSquareValue() {
        if (robot.getStep() == (edgeValue * edgeValue) - 1) {
            return true;
        }
        return false;
    }


    double calculateWeightResult(int availableWayNumber) {
        return weight.getWeightOfDirection()[availableWayNumber];
    }

    boolean isOneWayNumberTooMuchToRunHealtyTheAlgorithm() {
        if (oneWayNumbersValue >= 3)
            return true;
        return false;
    }

    int calculateDeadlyPoint() {
        ExitSituation exitSituation = robot.getRoadMemory().getExitSituation();
        double calculation = 1 - (double) (exitSituation.getSituation() + oneWayNumbersValue) / 2;
        return decideDeadlyPointCalculation(calculation);
    }

    int decideDeadlyPointCalculation(double calculation) {
        if (calculation >= 0) {
            return IS_FREE_SO_MOVE_FORWARD;
        }
        return IS_DEAD_SO_MOVE_BACK;
    }

    void addNavigationToRoadMemoryList() {

        if (oneWayNumbersValue >= 1) {
            robot.getRoadMemory().getOneWayNumbersList().add(navigation);
        }
    }

}
