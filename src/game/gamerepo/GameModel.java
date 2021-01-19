package game.gamerepo;

import game.gamerepo.player.Player;

public class GameModel {

    private Player player; //= new Player();

    private boolean ThereIsADeadEndLocation = false;
    private int gameSquares[][];  // alan olusturacak
    private boolean visitedAreas[][]; // 10 10 da bakilacak
//    private boolean visitedDirections[][];

    public GameModel(Player player) {
        this.player = player;
    }

    public int[][] getGameSquares() {
        return gameSquares;
    }

    public void setGameSquares(int[][] gameSquares) {
        this.gameSquares = gameSquares;
    }

    public boolean[][] getVisitedAreas() {
        return visitedAreas;
    }

    public void setVisitedAreas(boolean[][] visitedAreas) {
        this.visitedAreas = visitedAreas;
    }
//
//    public boolean[][] getVisitedDirections() {
//        return visitedDirections;
//     }
//
//    public void setVisitedDirections(boolean[][] visitedDirections) {
//        this.visitedDirections = visitedDirections;
//    }

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

}
