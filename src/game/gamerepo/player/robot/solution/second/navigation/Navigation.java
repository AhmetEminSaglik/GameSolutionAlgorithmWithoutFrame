package game.gamerepo.player.robot.solution.second.navigation;

import game.location.DirectionLocation;

public class Navigation {
    int step, OneWayNumbersValue;
    DirectionLocation compulsoryLocation;
    boolean ExitSituationWasLocatedInThisStep;
    ExitSituation exitSituation = new ExitSituation(ExitSituation.EXIT_FREE);
}
