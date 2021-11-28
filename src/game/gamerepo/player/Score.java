package game.gamerepo.player;

import game.Game;

public class Score {
    Game game;
    Player player;
    String playedTime;
    long totalGameFinishedScore = 0;
    int overLongTotalGameFinishedScore = 0;


    public Score(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    public void updatePlayedTime() {
        playedTime = player.getTimeKeeper().getTotalPassedTimeDuringPlayingGame();
    }


    public long getTotalGameFinishedScore() {
        return totalGameFinishedScore;
    }

    public void increaseTotalGameFinishedScore() {
        totalGameFinishedScore++;
        if (totalGameFinishedScore == Long.MAX_VALUE) {
            totalGameFinishedScore = 0;
            overLongTotalGameFinishedScore++;
        }
    }

    public int getOverLongTotalGameFinishedScore() {
        return overLongTotalGameFinishedScore;
    }
}
