package game.gamerepo.player.robot.solution.second.navigation;

public class ExitSituation {
    //    EXIT_FREE(0), EXIT_LOCATED(1);
    public static final int EXIT_FREE = 0, EXIT_LOCATED = 1;

    int situation;

    public ExitSituation(int situation) {
        this.situation = situation;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }
}
