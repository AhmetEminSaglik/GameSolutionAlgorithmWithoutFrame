package game.gamerepo.player.robot;

import errormessage.joptionpanel.ShowPanel;
import game.gamerepo.player.robot.solution.second.navigation.ExitSituation;
import game.gamerepo.player.robot.solution.second.navigation.Navigation;

import java.util.ArrayList;

public class RoadMemory {
    ExitSituation exitSituation = new ExitSituation(ExitSituation.EXIT_FREE);
    ArrayList<Navigation> oneWayNumbersList = new ArrayList<Navigation>();
//    ExitSituation exitSituation = new ExitSituation(ExitSituation.EXIT_FREE);

    public ExitSituation getExitSituation() {
        return exitSituation;
    }

    public void updateExistSituation(int situation) {
        this.exitSituation.setSituation(situation);
    }

    public ArrayList<Navigation> getOneWayNumbersList() {
        return oneWayNumbersList;
    }

    public int getLastIndex() {
        return oneWayNumbersList.size() - 1;
    }

    public Navigation getOneWayListLastItem() {
        if (oneWayNumbersList.size() > 0)
            return oneWayNumbersList.get(getLastIndex());
        return null;
    }

    public Navigation removeOneWayListLastItem() {
        return oneWayNumbersList.remove(getLastIndex());
    }
}
