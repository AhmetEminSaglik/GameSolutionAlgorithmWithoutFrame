package game.move.fundamental.secondsolutionforrobot;

import errormessage.joptionpanel.ShowPanel;
import game.Game;
import game.gamerepo.player.robot.Robot;
import game.gamerepo.player.robot.solution.second.navigation.ExitSituation;
import game.gamerepo.player.robot.solution.second.navigation.Navigation;
import game.location.LocationsList;
import game.move.fundamental.MoveBack;

public class MoveBackSecondSolution extends MoveBack {
    @Override
    public boolean isRequiredToChangeStartLocation() {
        if (game.getPlayer().getStep() == 1 && getClass().equals(MoveBackSecondSolution.class))
            return true;
        return false;
    }

    Robot robot = (Robot) game.getPlayer();
    Navigation navigation;

    @Override
    public void prepareAllStuff() {
        navigation = robot.getRoadMemory().getOneWayListLastItem();
    }

    public MoveBackSecondSolution(Game game) {
        super(game);
    }

    @Override
    public void updateBeforeStep() {
        super.updateBeforeStep();
    }

    @Override
    public void updateAfterStep() {
        super.updateAfterStep();
        doIfThereAreThingsTodoInOneWayNumberProcess();
        clearLastIndexInNavigationList();
    }

    void clearLastIndexInNavigationList() {
        if (robot.getRoadMemory().getOneWayListLastItem() != null)
            if (robot.getStep() < robot.getRoadMemory().getOneWayListLastItem().getStep()) {

//            ShowPanel.show(getClass(), "Las item SILINMEDEN ONCE : " + robot.getRoadMemory().getOneWayNumbersList().size());
                robot.getRoadMemory().removeOneWayListLastItem();
                if(navigation.isExitSituationWasLocatedInThisStep())
                robot.getRoadMemory().getExitSituation().setSituation(ExitSituation.EXIT_FREE);
//            ShowPanel.show(getClass(), "Las item SILINDKTEWN SONRAAA  : " + robot.getRoadMemory().getOneWayNumbersList().size());
            }
    }

    void doIfThereAreThingsTodoInOneWayNumberProcess() {
        if (!isNavigationNull() && navigation.getStep() == robot.getStep()) {
//            System.out.println(navigation.toString());
//            ShowPanel.show(getClass(), robot.getStep() + " Step = last item " + navigation.getStep());
            processAccordingToOneWayNumber();
        }
    }

    void processAccordingToOneWayNumber() {
        if (robot.getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_FREE) {
            if (navigation.getOneWayNumbersValue() == 1) {
                robot.getRoadMemory().getExitSituation().setSituation(ExitSituation.EXIT_LOCATED);
                navigation.setExitSituationWasLocatedInThisStep(true);
            }
        }


        /*if (navigation.getOneWayNumbersValue() == 2) {

//            freeExitSituation();
//            navigation.setCompulsoryLocation(new LocationsList().getLastLocation());
        }*/
    }

    void freeExitSituation() {
        robot.getRoadMemory().getExitSituation().setSituation(ExitSituation.EXIT_FREE);
//        navigation.setExitSituationWasLocatedInThisStep(true);
    }

    boolean isNavigationNull() {
        if (navigation == null)
            return true;
        return false;
    }

}
