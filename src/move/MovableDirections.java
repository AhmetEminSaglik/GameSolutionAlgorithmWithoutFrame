package move;

import Game.BuildGameModel;
import Game.GameModel;

public class MovableDirections {

    GameModel gameModel;
    GameModel copyOfGameModel;

    int wayCounter = 0;
    int playerMainTotalStep = 0;

    int arrayWayCounters[][];

    public MovableDirections(GameModel gameModel) {

        this.gameModel = gameModel;
        arrayWayCounters = new int[gameModel.getGameSquares().length * gameModel.getGameSquares()[0].length][8];
        copyGameModel(gameModel);// calculateTheWays(gameModel);
        /*    System.out.println(canGoNorth(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
        System.out.println(canGoNorthEast(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
        System.out.println(canGoEast(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
        System.out.println(canGoSouthEast(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
        System.out.println(canGoSouth(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
        System.out.println(canGoSouthWest(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
        System.out.println(canGoWest(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
        System.out.println(canGoNorthWest(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas()));
         */
    }

    public void copyGameModel(GameModel gameModel) {
        /*  FillGameModelArrays fillGameModelArrays = new FillGameModelArrays(copyOfGameModel);
        fillGameModelArrays.fillVisitedAreas();*/

        try {
            BuildGameModel buildGameModel = new BuildGameModel(gameModel.getGameSquares().length,
                    gameModel.getGameSquares()[0].length);
            copyOfGameModel = buildGameModel.getGameModel();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        copyOfGameModel.
                setVisitedAreas(
                        gameModel.getVisitedAreas());

    }

    /*
    1 adim ilerle yeni duzene gore kontrol et 2 den fazla cikis yolu varsa geri gel kaldigin yerden devam et 
    
    kuzey, dogu, bati 3 yon olsa    birinci ilerlemede kuzeyi hesapladi kuzeye girse baksa 
    2lik algoritma ya gore devam eder veya fonk bitirilip geri donduruurl
    
     */
 /*                                                                        1. [] //bizim 1. adimimiz oluyor adim sayisi
                                                                           2. [] //bizim 2. dizimiz oluyor kuzey guney vs yon sayisi
    mesela 11. adimdayiz 12. adim icin kontrol calismalari yapiyoruz.   [11][0] 
     */
    public void calculateTheWays(GameModel gameModel) {
// yeni bir game Model olusturup degerleri kopya, ardindan
        resetWayCounter();
        System.out.println(" way counter : " + wayCounter);
        canGoNorth(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
        System.out.println(" >> way counter : " + wayCounter);
        canGoNorthEast(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
        System.out.println(" |>> way counter : " + wayCounter);
        canGoEast(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
        canGoSouthEast(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
        canGoSouth(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
        canGoSouthWest(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
        canGoWest(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
        canGoNorthWest(gameModel.getPlayer().getLocationX(), gameModel.getPlayer().getLocationY(), gameModel.getVisitedAreas());
    }
    int deneme = 0;

    public boolean canGoNorth(int x, int y, boolean visitedArea[][]) {
        if (!isNull(x, y + 3)
                && visitedArea[x][y + 3] == false) { // if it is true then  player visit there before
            increaseWayCounter();
            if (deneme < 2) {
                System.out.println("if (wayCounter < 2)  oldugundan tekrar calculateTheWays fonk una girdi -->   way counter : " + wayCounter);
                deneme++;

                calculateTheWays(gameModel);
                //
            }
            return true;

        }
        return false;
    }

    public boolean canGoNorthEast(int x, int y, boolean visitedArea[][]) {
        if (!isNull(x + 2, y + 2) && visitedArea[x + 2][y + 2] == false) { // if it is true then  player visit there before
            increaseWayCounter();
            return true;
        }
        return false;
    }

    public boolean canGoEast(int x, int y, boolean visitedArea[][]) {

        if (!isNull(x + 3, y) && visitedArea[x + 3][y] == false) { // if it is true then  player visit there before
            increaseWayCounter();
            return true;
        }
        return false;
    }

    public boolean canGoSouthEast(int x, int y, boolean visitedArea[][]) {

        if (!isNull(x + 2, y - 2) && visitedArea[x + 2][y - 2] == false) { // if it is true then  player visit there before
            increaseWayCounter();
            return true;
        }
        return false;
    }

    public boolean canGoSouth(int x, int y, boolean visitedArea[][]) {

        if (!isNull(x, y - 2) && visitedArea[x][y - 3] == false) { // if it is true then  player visit there before
            increaseWayCounter();
            return true;
        }
        return false;
    }

    public boolean canGoSouthWest(int x, int y, boolean visitedArea[][]) {

        if (!isNull(x - 2, y - 2) && visitedArea[x - 2][y - 2] == false) { // if it is true then  player visit there before
            increaseWayCounter();
            return true;
        }
        return false;
    }

    public boolean canGoWest(int x, int y, boolean visitedArea[][]) {

        if ((!isNull(x - 3, y)) && (visitedArea[x - 3][y] == false)) { // if it is true then  player visit there before
            System.out.println("5555");
            increaseWayCounter();
            return true;
        }
        return false;
    }

    public boolean canGoNorthWest(int x, int y, boolean visitedArea[][]) {

        if (!isNull(x - 2, y + 2) && visitedArea[x - 2][y + 2] == false) { // if it is true then  player visit there before
            increaseWayCounter();
            return true;
        }
        return false;
    }

    public boolean isNull(int x, int y) {
        if (0 <= x && x < gameModel.getGameSquares().length
                && 0 <= y && y < gameModel.getGameSquares()[x].length) {
            return false;

        }
        return true;
    }

    /**
     * getWayCounter() shows us the calculated total way numbers
     *
     * @param wayCounter = show us the calculated total way numbers
     */
    public int getWayCounter() {
        return wayCounter;
    }

    public void resetWayCounter() {
        wayCounter = 0;
    }

    void increaseWayCounter() {
        wayCounter++;
    }

    void decreaseWayCounter() {
        wayCounter++;
    }
}
