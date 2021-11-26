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
import game.location.direction.LastLocation;
import print.PrintAble;
import squareprocess.SquareProcess;
import weights.Weight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

//        printAble = new FileWriteProcess(robot.getName(), 404);
    }


    public int calculateFunctionResult() {


        if (isNavigationInRoadMemoryAvailableForThisStep()) {
            if (navigation.getOneWayNumbersValue() == 1 &&
                    robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED
                    && !navigation.isExitSituationWasLocatedInThisStep()) {
                navigation.setCompulsoryLocation(new LastLocation());
//                System.out.println("LAST LOCATION BURADAN EKLENDI ???? + step : " + robot.getStep() + " >>>> " + robot.getRoadMemory().getExitSituation().getSituation());
            } else if (navigation.getCompulsoryLocation() != null) {
//                System.out.println("BURAYA GELDI VE SELECTEDDIRECTION DEGISTI 11111111111111111111111111111111111111"+selectedDirection.toString());
                selectedDirection = navigation.getCompulsoryLocation();
//                System.out.println("BURAYA GELDI VE SELECTEDDIRECTION DEGISTI 11111111111111111111111111111111111111"+selectedDirection.toString());
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


//        printNavigation();
//        System.out.println( ">>>>>>>>>>>>>>>>SECILEN  bolge : " + selectedDirection.toString());
//        ShowPanel.show(getClass(),"Secilen bolge : "+selectedDirection);
        /*ShowPanel.show(getClass(), " Teker teker izle : " + robot.getStep()+"\n" +
                "verilen karar : "+selectedDirection.toString());*/

        return selectedDirection.getId();

        /*if (isCompulsoryLocationNullInNavigation() == true) {

            calculateForwardAvailableDirectionsOfCurrentDirection();

            if (!isRequestedToKillFunctionByOneWayAvailableNumberProcess()) {


                double calculationDeadlyPoint = calculateDeadlyPoint();
                if (calculationDeadlyPoint == IS_FREE_SO_MOVE_FORWARD) {
                    navigation = buildNavigation();
                    addNavigationToRoadMemoryList();
                }
            }
        } else {
            if (navigation.getCompulsoryLocation() != null) {
                ShowPanel.show(getClass(), "getCompulsoryLocation NUL DEGILLL " + navigation.getCompulsoryLocation().toString());
                selectedDirection = navigation.getCompulsoryLocation();
                navigation.setCompulsoryLocation(lastLocation);
                if (robot.getStep() == 12) {
                    ShowPanel.show(getClass(), "get adim sayisi " + robot.getStep());
                    ShowPanel.show(getClass(), selectedDirection.toString());
                }
            }
        }
        printNavigation();
        DirectionLocation nullMu = null;
        if (compulsoryLocation != null) {
            selectedDirection = compulsoryLocation;
        }
        ShowPanel.show(getClass(), "\nlast locatrion " + lastLocation.toString() + "\n" +
                "selectedDirection " + selectedDirection.toString() + "\nstep : " + robot.getStep() + "\n" +
                "zorunlu olan : " + nullMu);


        ;*/


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

//        Map<DirectionLocation, Integer> forwardLocationMap = new HashMap<>();

        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {//, robotMemory
                DirectionLocation location = locationsList.get(i);
//                System.out.println("+++++++++++++++++++++++++++++ GELEN LOCATION LISTEDEN ALINDI : "+locationsList.get(i).toString());

                int availableWayNumber = forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, location);

                if (isAvailableWayEqualsToZero(availableWayNumber) && !isNextStepWillBeEqualsToTotalSquareValue()) {
//                    System.out.println("LAST LOCATIONDAN GELIYORRRRRRRRRRRRRRRRRRRRRRRRRRR"+selectedDirection.toString());
                    selectedDirection = lastLocation;
                    return;
                } /*else*/
                if (weight.getWeightOfDirection()[availableWayNumber] > weightResult) {
//                    System.out.println("Onceki weightResult : "+weightResult);
                    weightResult = calculateWeightResult(availableWayNumber);
//                    System.out.println("Yenisi  weightResult : "+weightResult);
                    selectedDirection = location;
//                    System.out.println("<<<<<<<<<<selectedDirection == ESITLENIYOR : "+selectedDirection.toString() + " Location : "+location.toString());
                }
//                forwardLocationMap.put(location, availableWayNumber);

                processAccordingToOneWayNumber(availableWayNumber, location);

                if (isRequestedToKillFunctionByOneWayAvailableNumberProcess()) {

                    return;
                }

            }

        }
//        printMap(forwardLocationMap);

       /* if(oneWayNumbersValue>=2){
            ShowPanel.show(getClass(),"Step : "+game.getPlayer().getStep()+"oneWayNumbersValue " +oneWayNumbersValue);
        }*/
//        printMap(forwardLocationMap);


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
//                ShowPanel.show(getClass(), "BURADA ZORUNLU ALANBELIRLENIYOR" + oneWayNumbersValue + " \nzorunlu alan : " + compulsoryLocation.toString());
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
//            ShowPanel.show(getClass(), "available Way Number : " + availableWayNumber);
            return true;
        }
        return false;
    }

    boolean isNextStepWillBeEqualsToTotalSquareValue() {
        if (robot.getStep() == (edgeValue * edgeValue) - 1) {
//            ShowPanel.show(getClass(), "robot.getStep() == (edgeValue * edgeValue) - 1 :  steP  :" + robot.getStep());
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


    void printMap(Map<DirectionLocation, Integer> map) {
        for (Map.Entry<DirectionLocation, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().getId() + " : " + entry.getValue());
        }
//        ShowPanel.show(getClass(), "Map yazdirildi");
        System.out.println("================================");
    }


    int calculateDeadlyPoint() {
        ExitSituation exitSituation = robot.getRoadMemory().getExitSituation();
//        System.out.println("exitSituation.getSituation()  :");
        double calculation = 1 - (double) (exitSituation.getSituation() + oneWayNumbersValue) / 2;
//        double calculation = 1 - (double)(1 + 2) / 2;
//        double result = 1-(double) (1+2)/2;

//        System.out.println("Adim : " + robot.getStep());
//        System.out.println("SONUC : " + calculation + " exitSituation.getSituation() : " + exitSituation.getSituation() + " OWN : " + oneWayNumbersValue);
//        System.out.println("Exit Siutation : " + exitSituation.getSituation() + " OWN : " + oneWayNumbersValue);
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
//            System.out.println("EKLINMIS OLANLAR ::::");
            robot.getRoadMemory().getOneWayNumbersList().add(navigation);

        }
    }

    void printNavigation() {
        for (Navigation tmp : robot.getRoadMemory().getOneWayNumbersList()) {
            System.out.println(tmp);
        }
        System.out.println("---------------------------- Exit suitaion : " + robot.getRoadMemory().getExitSituation().getSituation());
    }


}
