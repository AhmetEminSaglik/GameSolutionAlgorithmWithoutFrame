package game;

import game.gamerepo.Model;
import game.gamerepo.player.Player;

public class Game {
    long roundCounter = 0;
    private Model model;
    private Player player;

    public Game(Model model, Player player) {
        this.model = model;
        this.player = player;
    }

    public Game() {
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {

        this.model = model;
    }

    public Player getPlayer() {
        return player;
    }

    public void resetRoundCounter() {
        roundCounter = 0;
    }

    public void increaseRoundCounter() {
        roundCounter++;
    }

    public long getRoundCounter() {
        return roundCounter;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
