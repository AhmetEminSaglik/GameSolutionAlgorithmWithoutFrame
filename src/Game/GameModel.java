package Game;

import Game.player.Player;

public class GameModel {

    private Player player = new Player();

    private boolean ThereIsADeadEndLocation = false;
    private String gameSquares[][];  // alan olusturacak
    private boolean visitedAreas[][]; // 10 10 da bakilacak
    private boolean visitedDirections[][];

    private int totalStep = 1;

    public String[][] getGameSquares() {
        return gameSquares;
    }

    public void setGameSquares(String[][] gameSquares) {
        this.gameSquares = gameSquares;
    }

    public boolean[][] getVisitedAreas() {
        return visitedAreas;
    }

    public void setVisitedAreas(boolean[][] visitedAreas) {
        this.visitedAreas = visitedAreas;
    }

    public boolean[][] getVisitedDirections() {
        return visitedDirections;
    }

    public void setVisitedDirections(boolean[][] visitedDirections) {
        this.visitedDirections = visitedDirections;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isThereIsADeadEndLocation() {
        return ThereIsADeadEndLocation;
    }

    public void setThereIsADeadEndLocation(boolean ThereIsADeadEndLocation) {
        this.ThereIsADeadEndLocation = ThereIsADeadEndLocation;
    }

    public int getTotalStep() {
        return totalStep;
    }

    public void setTotalStep(int totalStep) {
        this.totalStep = totalStep;
    }

    public void increaseTotalStep() {
        totalStep++;

    }

}
