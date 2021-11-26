package game.move.fundamental.secondsolutionforrobot;

import errormessage.ErrorMessage;
import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.second.navigation.ExitSituation;
import game.gamerepo.player.robot.solution.second.navigation.Navigation;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.location.direction.LastLocation;
import game.location.direction.South;
import game.move.fundamental.MoveForward;

public class MoveForwardSecondSolution extends MoveForward {
    public MoveForwardSecondSolution(Game game) {
        super(game);
    }

    Robot robot = (Robot) game.getPlayer();
    Navigation navigation;
//    Navigation navigation;

    DirectionLocation lastLocation = new LocationsList().getLastLocation();

    @Override
    public void prepareAllStuff() {
        navigation = robot.getRoadMemory().getOneWayListLastItem();
//        System.out.println("SECILMISSSSSSSSSS : "+getDirectionLocation());
    }

    @Override
    public void updateBeforeStep() {
        doIfThereAreThingsTodoInOneWayNumberProcess();      /*
         * Simdi burada  Navigationdan durumu alip ona gore Islemler yapicaz, located vs.;..*/
    }

    @Override
    public void updateAfterStep() {
//        ShowPanel.show(getClass(), "SSS Adim : " + robot.getStep());
//        updateCompulsorylocationToLastLocation();
        super.updateAfterStep();

    }

    void doIfThereAreThingsTodoInOneWayNumberProcess() {
        if (!isNavigationNull() && navigation.getStep() == robot.getStep()) {
//            System.out.println(navigation.toString());
//            ShowPanel.show(getClass(), robot.getStep() + " Step = last item " + navigation.getStep());
            processAccordingToOneWayNumber();
        }
    }


    boolean isDirectionSame(DirectionLocation d1, DirectionLocation d2) {

        if (d1.getX() == d2.getX() && d1.getY() == d2.getY()) {
//            ShowPanel.show(getClass(), " Zorunlu adim ile ilerlenecek yon ayni  x-y cordinatlara sahip");
            return true;
        }
        return false;

    }

    void processAccordingToOneWayNumber() {

//        System.out.println("adim : sayisi : " + robot.getStep());
//        System.out.println("OWN: sayisi : " + navigation.getOneWayNumbersValue());
//        System.out.println(" ShowPanel oncesi degisiklik var mi ?Ilerleme Yonu : " + getDirectionLocation());
        if (navigation.getOneWayNumbersValue() == 2) {
            if (robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_FREE) {
                locateExitSituation();
            }

            if (isDirectionSame(getDirectionLocation(), navigation.getCompulsoryLocation())) {
//                ShowPanel.show(getClass(), "\n>>> !!!!!!!!!! ILERLENECEK ALAN = ZORUNLU ALAN !!!!!!!    ");
                navigation.setCompulsoryLocation(new LocationsList().getLastLocation());

            }
           /* if (navigation.getCompulsoryLocation() == getDirectionLocation()) {
                ShowPanel.show(getClass(), "ZORUNLU ALAN " + navigation.getCompulsoryLocation().toString() + "\n" +
                        "Suanki Location : " + getDirectionLocation());
            } else {

                System.out.println("zorunlu : " + navigation.getCompulsoryLocation());
                System.out.println("Suanki : " + getDirectionLocation());
                System.out.println("-------1");
            }*/

        } else if (navigation.getOneWayNumbersValue() == 1 &&
                robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED &&
                !navigation.isExitSituationWasLocatedInThisStep()) {
            navigation.setCompulsoryLocation(new LocationsList().getLastLocation());
        }

//        ShowPanel.show(getClass(), "Ilerleme Yonu : " + getDirectionLocation());
    }

   /* void updateCompulsorylocationToLastLocation() {
        if (!isNavigationNull()) {
            navigation.setCompulsoryLocation(lastLocation);
        }
    }*/

    void locateExitSituation() {
        robot.getRoadMemory().getExitSituation().setSituation(ExitSituation.EXIT_LOCATED);
        navigation.setExitSituationWasLocatedInThisStep(true);

    }

    boolean isNavigationNull() {
        if (navigation == null)
            return true;
        return false;
    }
}
