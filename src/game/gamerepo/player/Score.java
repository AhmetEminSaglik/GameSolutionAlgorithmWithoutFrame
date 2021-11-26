package game.gamerepo.player;

import game.Game;

public class Score {
    Game game;
    Player player;
    String playedTime;

    public Score(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    public void updatePlayedTime() {
        playedTime = player.getTimeKeeper().getTotalPassedTimeDuringPlayingGame();
    }

}
