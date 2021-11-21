package game.gamerepo.player.robot;

import game.gamerepo.player.robot.solution.second.navigation.ExitSituation;

public class RoadMemory {
    ExitSituation exitSituation = new ExitSituation(ExitSituation.EXIT_FREE);

    public ExitSituation getExitSituation() {
        return exitSituation;
    }

    public void updateExistSituation(int situation) {
        this.exitSituation.setSituation(situation);
    }
}
