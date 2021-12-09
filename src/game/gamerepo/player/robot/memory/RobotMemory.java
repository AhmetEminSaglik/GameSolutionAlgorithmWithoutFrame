package game.gamerepo.player.robot.memory;

import game.Game;

public class RobotMemory {
    Game game;

    private RoadMemory roadMemory = new RoadMemory();
    private GraphMemory graphMemory;

    public RobotMemory(Game game) {
        this.game = game;
        graphMemory = new GraphMemory(game);
    }


    public RoadMemory getRoadMemory() {
        return roadMemory;
    }

    public GraphMemory getGraphMemory() {
        return graphMemory;
    }
}
