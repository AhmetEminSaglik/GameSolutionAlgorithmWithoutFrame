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

  /*  void printList(ArrayList<Navigation> list) {
        int i = 0;
        for (Navigation tmp : list) {
            System.out.println(i + "-) " + tmp);
            i++;
        }
    }*/


    public int calculateFunctionResult() {
//        ShowPanel.show(getClass(), "adim ? " + robot.getStep());

        if (isCompulsoryLocationNullInNavigation() == true) {
            ShowPanel.show(getClass(),"adim ? "+robot.getStep());
//                    "  "+compulsoryLocation.toString());


            calculateForwardAvailableDirectionsOfCurrentDirection();

            if (!isRequestedToKillFunctionByOneWayAvailableNumberProcess()) {


                double calculationDeadlyPoint = calculateDeadlyPoint();
//            System.out.println("GELEN SONUCCCCCCCCCC  "+calculationDeadlyPoint);
                if (calculationDeadlyPoint == IS_FREE_SO_MOVE_FORWARD) {
//                selectedDirection = lastLocation;
//                if (oneWayNumbersValue == 2 && robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED)
//                ShowPanel.show(getClass(), robot.getStep() + " >>AAAAAAAAAAAAAAAA  Adim  OWN : " + oneWayNumbersValue);
                    navigation = buildNavigation();
                    addNavigationToRoadMemoryList();
                } else {
//                setDefaultValueToSelectedLocationAsLastLocation();

                }
            }
            /* */
        } else {
//            if (robot.getStep() == 12) {
//                ShowPanel.show(getClass(), "get adim sayisi " + robot.getStep());
//                ShowPanel.show(getClass(), selectedDirection.toString());
//            }
//            selectedDirection = navigation.getCompulsoryLocation();
//            System.out.println("Sewlected Direction" + selectedDirection);
//            System.out.println("navigaton" + navigation.getCompulsoryLocation());
            if (navigation.getCompulsoryLocation() != null) {
                ShowPanel.show(getClass(), "getCompulsoryLocation NUL DEGILLL " + navigation.getCompulsoryLocation().toString());
                selectedDirection = navigation.getCompulsoryLocation();
                navigation.setCompulsoryLocation(lastLocation);
                if (robot.getStep() == 12) {
                    ShowPanel.show(getClass(), "get adim sayisi " + robot.getStep());
                    ShowPanel.show(getClass(), selectedDirection.toString());
                }
            } /*else {
                if (robot.getStep() == 12) {
                    ShowPanel.show(getClass(), "get adim sayisi " + robot.getStep());
                    ShowPanel.show(getClass(), selectedDirection.toString());
                }
//                selectedDirection = lastLocation;
            }*/
//            selectedDirection = lastLocation;
//            navigation.setCompulsoryLocation(lastLocation);
//            System.out.println("Sewlected Direction" + selectedDirection);
//            System.out.println("navigaton" + navigation.getCompulsoryLocation());
//            ShowPanel.show(getClass(),"LOCATION DEGISMIS MI ?");
        }
        printNavigation();
        DirectionLocation nullMu=null;
        if (compulsoryLocation != null) {
            selectedDirection = compulsoryLocation;
        }
        ShowPanel.show(getClass(), "\nlast locatrion " + lastLocation.toString() + "\n" +
                "selectedDirection " + selectedDirection.toString() + "\nstep : " + robot.getStep()+"\n" +
                "zorunlu olan : "+nullMu);


        return selectedDirection.getId();

    }

    boolean isCompulsoryLocationNullInNavigation() {
        System.out.println("OWN list item size : " + robot.getRoadMemory().getOneWayNumbersList().size());
        System.out.println("OWN list last item : " + robot.getRoadMemory().getOneWayListLastItem());
        Navigation navigation = robot.getRoadMemory().getOneWayListLastItem();
        if (navigation != null && robot.getStep() == navigation.getStep()) {
            if (navigation.getCompulsoryLocation() != null) {
                System.out.println(navigation);
//                ShowPanel.show(getClass(), "zorunlu alan : " + navigation.getCompulsoryLocation()+" ");
                selectedDirection = navigation.getCompulsoryLocation();
                return false;
            }
        }


        return true;
    }

    void setDefaultValueToSelectedLocationAsLastLocation() {
        selectedDirection = lastLocation;
    }

    /*int oneWayNumbersValue, DirectionLocation compulsoryLocation*/
    Navigation buildNavigation() {
        Navigation navigation = new Navigation();

        navigation.setStep(robot.getStep());

        navigation.setOneWayNumbersValue(oneWayNumbersValue);

        if (compulsoryLocation != null) {
            System.out.println("AAAAAAAAAAAAAAAAAAA step : " + robot.getStep());
            navigation.setCompulsoryLocation(compulsoryLocation);
        }
        /*if (oneWayNumbersValue == 2) {  ----> Bu ileri adim , before step'te yapilacak
            robot.getRoadMemory().getExitSituation().setSituation(ExitSituation.EXIT_LOCATED);
            navigation.setExitSituationWasLocatedInThisStep(true);
        }*/

        return navigation;
    }


    void calculateForwardAvailableDirectionsOfCurrentDirection() {

        double weightResult = -1;
        ForwardLocation forwardLocation = new ForwardLocation();

        Map<DirectionLocation, Integer> forwardLocationMap = new HashMap<>();

        for (int i = 0; i < locationsList.size() - 1; i++) {
            if (squareProcess.isSquareAvailableToMoveOnIt(game, playerLocation, locationsList.get(i))) {//, robotMemory
                DirectionLocation location = locationsList.get(i);

                int availableWayNumber = forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, location);

                if (isAvailableWayEqualsToZero(availableWayNumber) && !isNextStepWillBeEqualsToTotalSquareValue()) {
                    selectedDirection = lastLocation;
                    return;
                } /*else*/
                if (weight.getWeightOfDirection()[availableWayNumber] > weightResult) {
                    weightResult = calculateWeightResult(availableWayNumber);
                    selectedDirection = location;
                }
//                forwardLocationMap.put(location, availableWayNumber);

                processAccordingToOneWayNumber(availableWayNumber, location);

                if (isRequestedToKillFunctionByOneWayAvailableNumberProcess()) {

                    return;
                }

//                forwardLocation.inspectLocationAndGetAvailableSquareNumbers(game, locationsList.get(i));
           /*     if (availableWayNumber == 1) {
                    oneWayNumbersValue++;
                    if (isOneWayNumberTooMuchToRunHealtyTheAlgorithm(availableWayNumber)) {
                        selectedDirection = lastLocation;
                        return;
                    }
                  *//*  if (compulsoryLocation != null)
                        ShowPanel.show(getClass(), "SUAN  compulsory location 2 kere gelindi :\n" +
                                "i : " + i + " oneWayNumbersValue : +1 ekle " + oneWayNumbersValue);*//*

                    if (oneWayNumbersValue == 2)
                        setCompulsoryLocationToNavigationItem(location);
                }*/
            }

        }
//        printMap(forwardLocationMap);

       /* if(oneWayNumbersValue>=2){
            ShowPanel.show(getClass(),"Step : "+game.getPlayer().getStep()+"oneWayNumbersValue " +oneWayNumbersValue);
        }*/
//        printMap(forwardLocationMap);


     /*   System.out.println("Selected Direction : " + selectedDirection.getId());
        System.out.println("weightResult : " + weightResult);*/
//        ShowPanel.show(getClass(), " Map ekleme islemi bitti  directionlar ve degerleri yazdirilmis olmali >>>> Toplam OWN : " + oneWayNumbersValue);


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
            } else if (oneWayNumbersValue == 2) {
                ShowPanel.show(getClass(), "BURADA ZORUNLU ALANBELIRLENIYOR" + oneWayNumbersValue);
                compulsoryLocation = location;
            }
            if (isOneWayNumberTooMuchToRunHealtyTheAlgorithm()) {
                selectedDirection = lastLocation;
                killRequestByAvailableProcessFunction = true;
                return;
            }
                  /*  if (compulsoryLocation != null)
                        ShowPanel.show(getClass(), "SUAN  compulsory location 2 kere gelindi :\n" +
                                "i : " + i + " oneWayNumbersValue : +1 ekle " + oneWayNumbersValue);*/

//            oneWayNumbersValue == 2 ---> olacak zaten o zaman direk zorunluBolgeryi =location yapmak yeterli olacaktir
//            ShowPanel.show(getClass(),"BURADAN KAYNAKLI MI step : "+robot.getStep());


            /*if (oneWayNumbersValue == 2) {
                compulsoryLocation = location;
                *//*if (robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED) {
                    killRequestByAvailableProcessFunction = true;
                    return;
                }*//*
            }*/

        }

//        updateStepValueInNavigation();
//        addNavigationToRoadMemoryList();
    }

    /* void updateOneWayNumberValueInNavigation() {
         navigation.setOneWayNumbersValue();
     }
 */
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
//ShowPanel.show(getClass(),"edgeValue * edgeValue : "+edgeValue * edgeValue);
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
        ShowPanel.show(getClass(), "Map yazdirildi");
        System.out.println("================================");
    }

   /* void decideDeadlyPointOrNot(ExitSituation exitSituation, int oneWayNumbersValue) {
        double result = 1 - (exitSituation.getSituation() + oneWayNumbersValue) / 2;
        if (result >= 0)
            deadlyPoint = false;
        deadlyPoint = true;
    }*/

    int calculateDeadlyPoint() {
        ExitSituation exitSituation = robot.getRoadMemory().getExitSituation();
//        System.out.println("exitSituation.getSituation()  :");
        double calculation = 1 - (double) (exitSituation.getSituation() + oneWayNumbersValue) / 2;
//        double calculation = 1 - (double)(1 + 2) / 2;
//        double result = 1-(double) (1+2)/2;

        System.out.println("Adim : " + robot.getStep());
        System.out.println("SONUC : " + calculation);
        System.out.println("Exit Siutation : " + exitSituation.getSituation() + " OWN : " + oneWayNumbersValue);
        return decideDeadlyPointCalculation(calculation);

    }

    int decideDeadlyPointCalculation(double calculation) {
        if (calculation >= 0) {
            return IS_FREE_SO_MOVE_FORWARD;
        }
        return IS_DEAD_SO_MOVE_BACK;
    }

//    boolean isDeadlyPoint() {
//        return deadlyPoint;
//    }

    void addNavigationToRoadMemoryList() {

        if (oneWayNumbersValue >= 1) {
            System.out.println("EKLINMIS OLANLAR ::::");
            robot.getRoadMemory().getOneWayNumbersList().add(navigation);

//            ShowPanel.show(getClass(), "Navigasyon yazdirildi");
        }
    }

    void printNavigation() {
        for (Navigation tmp : robot.getRoadMemory().getOneWayNumbersList()) {
            System.out.println(tmp);
        }
        System.out.println("---------------------------- Exit suitaion : " + robot.getRoadMemory().getExitSituation().getSituation());
    }

    /*void setCompulsoryLocationToNavigationItem(DirectionLocation directionLocation) {
        navigation.setCompulsoryLocation(directionLocation);
    }*/
   /*

       void updateStepValueInNavigation() {
        navigation.setStep(robot.getStep());
    }
    */

}

  /*
        System.out.println("FUNCTION GIRISI KAYITLAR : ");
        if (robot.getRoadMemory().getOneWayNumbersList().size() > 0) {

            System.out.println("list size  :" + robot.getRoadMemory().getOneWayNumbersList().size());
//            System.out.println("son index  :" + robot.getRoadMemory().getOneWayListLastItem().toString());
            printList(robot.getRoadMemory().getOneWayNumbersList());
        }
        System.out.println("");
*/
      /*  Navigation checkNavigation = null;
        if (robot.getRoadMemory().getOneWayNumbersList().size() > 0) {
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
                        *//*new Navigation();
                navigation.setStep(robot.getStep());
                navigation.setOneWayNumbersValue(oneWayNumbersValue);
                navigation.setCompulsoryLocation(compulsoryLocation);
                navigation.setExitSituationWasLocatedInThisStep(true);*//*

                robot.getRoadMemory().getOneWayNumbersList().add(navigation);
            } else if (oneWayNumbersValue == 1 && exitSituation.getSituation() == ExitSituation.EXIT_LOCATED) {
                compulsoryLocation = lastLocation;
                Navigation navigation = buildNavigation(robot.getStep(), oneWayNumbersValue, compulsoryLocation, false);
                *//*navigation.setStep(robot.getStep());
                navigation.setOneWayNumbersValue(oneWayNumbersValue);
                navigation.setCompulsoryLocation(compulsoryLocation);
                navigation.setExitSituationWasLocatedInThisStep(false);*//*

            } else if (oneWayNumbersValue == 1 && exitSituation.getSituation() == ExitSituation.EXIT_FREE) {
                Navigation navigation = buildNavigation(robot.getStep(), oneWayNumbersValue, compulsoryLocation, false);
                *//*navigation.setStep(robot.getStep());
                navigation.setOneWayNumbersValue(oneWayNumbersValue);
//                navigation.setCompulsoryLocation(compulsoryLocation);
                navigation.setExitSituationWasLocatedInThisStep(false);*//*
            }

//            calculateDirectionLocationToMove();
            //Calculate Which will be next SquareMOVE FORWARD
        } else {            //MOVE BACK
        }*/
//        System.out.println("secilen direction name : "+selectedDirection.toString());
      /*  if (selectedDirection == lastLocation) {
            System.out.println("list size  :" + robot.getRoadMemory().getOneWayNumbersList().size());
            System.out.println("son index  :" + robot.getRoadMemory().getOneWayListLastItem().toString());
            if (checkNavigation != null && checkNavigation.getStep() == robot.getStep()) {
                robot.getRoadMemory().removeOneWayListLastItem();
                ShowPanel.show(getClass(), "GERI ADIM ATILDI LISTEDEN SON ITEM SILINDIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
            }
            System.out.println("checkNavigation.getStep() > " + checkNavigation.getStep());
            System.out.println("checkNavigation.getStep() > " + robot.getStep());
            ShowPanel.show(getClass(), "GERI ADIM ATILACAK  LISTE SILINDI MI ????????????????????????? " + robot.getStep());
        }*/

//        ShowPanel.show(getClass(), "Step : " + robot.getStep() + "  gidilecek direction : " + selectedDirection.toString());
