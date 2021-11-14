package game.gamerepo;

public class Model {

//    private Player player; //= new Player(); 
    private int gameSquares[][];  // alan olusturacak
    private boolean visitedAreas[][]; // 10 10 da bakilacak
//    private boolean visitedDirections[][];

//    public Model(Player player) {
//        this.player = player;
//    }


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

//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }

}
