package game.gamerepo.player.robot;

import utility.ConvertNanoTimeToTime;

import java.util.concurrent.TimeUnit;

public class TimeKeeper {
    long start;
    long totalTimePassed;

    public TimeKeeper() {
        start = System.nanoTime();
    }

    public void finishTime() {
        long finish = System.nanoTime() - start;
        totalTimePassed = TimeUnit.MILLISECONDS.convert(finish, TimeUnit.NANOSECONDS);
    }

    public long getTotalTimePassed() {
        return totalTimePassed;
    }

    public String getTotalPassedTimeDuringPlayingGame() {
        finishTime();
        ConvertNanoTimeToTime convertNanoTimeToTime = new ConvertNanoTimeToTime(this);
        return convertNanoTimeToTime.getTimeInStringFormat();
    }


}
