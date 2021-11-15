package game.gamerepo.player.robot;

import errormessage.joptionpanel.ShowPanel;
import utility.ConvertNanoTimeToTime;

import java.util.concurrent.TimeUnit;

public class TimeKeeper {
    long start;
    long totalTimePassed;

    public TimeKeeper() {
        start = System.nanoTime();
//        System.out.println("time " + TimeUnit.MICROSECONDS.convert(d, TimeUnit.NANOSECONDS));

    }

    public void finishTime() {
//         = System.nanoTime() - start;
        long finish = System.nanoTime() - start;
        totalTimePassed = TimeUnit.MILLISECONDS.convert(finish, TimeUnit.NANOSECONDS);

 /*       ShowPanel.show(getClass(),"TotalTImePassed : "+totalTimePassed+ " \n" +
                " TimeUnit.MILLISECONDS.convert(finish, TimeUnit.NANOSECONDS) :"+ TimeUnit.MILLISECONDS.convert(finish, TimeUnit.NANOSECONDS));*/
    }

    public long getTotalTimePassed() {
        return totalTimePassed;
    }

    public String getTotalPassedTimeDuringPlayingGame() {
        finishTime();
        ConvertNanoTimeToTime convertNanoTimeToTime = new ConvertNanoTimeToTime(this);
        return convertNanoTimeToTime.getTimeInStringFormat();
    }

    /*public long getResult() {
        return totalTimePassed;
    }*/

}
