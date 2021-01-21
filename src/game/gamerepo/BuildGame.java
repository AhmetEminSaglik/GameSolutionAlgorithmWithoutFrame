package game.gamerepo;

import game.Game;
import validation.SquareValidationGame;

public class BuildGame {

    private int horizontalSquare;
    private int verticalSquare;
    private Game game;

    public BuildGame(int verticalSquare, int horizontalSquare) throws InterruptedException { //Model model, Player player,
        new SquareValidationGame(verticalSquare, horizontalSquare);
        this.horizontalSquare = horizontalSquare;
        this.verticalSquare = verticalSquare;
        game = new Game();

    }

    public Game fillGame() throws InterruptedException {//Model model, Player player
//        Model gameModel = new Model(player);
        //Game(model, player);
        //game.setModel(model);
        // game.setPlayer(player);

        System.out.println("game " + game);

        game.setModel(new Model());

        game.getModel().setGameSquares(createMultipleArrayFromIntegers(verticalSquare, horizontalSquare));
        //gameModel = prepareNullValues(gameModel);

//        gameModel = setVisitedDirectionsArray(gameModel);
        return game;
    }

    public Game clearAreas() {
        return game = creatVisitArea(game);
    }
//    public Model setVisitedDirectionsArray(Model gameModel) {
//        boolean visitedDirection[][] = new boolean[verticalSquare * horizontalSquare][8];
//        gameModel.setVisitedDirections(visitedDirection);
//
//        for (int i = 0; i < gameModel.getVisitedDirections().length; i++) {
//            for (int j = 0; j < 8; j++) {
//                gameModel.getVisitedDirections()[i][j] = false;
//
//            }
//        }
//        return gameModel;
//    }

    public int[][] createMultipleArrayFromIntegers(int verticalSquare, int horizontalSquare) {
        return new int[verticalSquare][horizontalSquare];
    }

    public String[] prepareNullArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = "   ";
        }

        return array;
    }

    Game creatVisitArea(Game game) {
        boolean visitedAreas[][] = new boolean[verticalSquare][horizontalSquare];
        game.getModel().setVisitedAreas(visitedAreas);
        clearVisitedAreas(game);
        return game;
    }

    Game clearVisitedAreas(Game game) { 
        for (int i = 0; i < game.getPlayer().getLocation().getX(); i++) {

            for (int j = 0; j < game.getPlayer().getLocation().getY(); j++) {
                game.getModel().getVisitedAreas()[i][j] = false;
            }
        }
        return game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
