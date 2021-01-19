package game;

import game.gamerepo.Model;
import game.gamerepo.player.Player;

public class Game {

    private Model model;
    private Player player;

    public Game(Model model, Player player) {
        this.model = model;
        this.player = player;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {

        System.out.println("Model :" + model);
        this.model = model;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
