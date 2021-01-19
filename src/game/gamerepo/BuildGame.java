package game.gamerepo;

import game.Game;
import game.gamerepo.player.Player;
import validation.SquareValidationGame;

public class BuildGame {

    private int horizontalSquare;
    private int verticalSquare;
    private Game game;

    public BuildGame(Model model, Player player, int verticalSquare, int horizontalSquare) throws InterruptedException {
        new SquareValidationGame(verticalSquare, horizontalSquare);
        this.horizontalSquare = horizontalSquare;
        this.verticalSquare = verticalSquare;
        game = fillGame(model, player);

    }

    Game fillGame(Model model, Player player) throws InterruptedException {
//        Model gameModel = new Model(player);
        game = new Game(model, player);

        System.out.println("game " + game);

        game.setModel(new Model());

        game.getModel().setGameSquares(createMultipleArrayFromIntegers(verticalSquare, horizontalSquare));
        //gameModel = prepareNullValues(gameModel);
        game = creatVisitArea(game);
//        gameModel = setVisitedDirectionsArray(gameModel);

        return game;
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

    public Game creatVisitArea(Game game) {
        boolean visitedAreas[][] = new boolean[verticalSquare][horizontalSquare];
        game.getModel().setVisitedAreas(visitedAreas);
        clearVisitedAreas(game);
        return game;
    }

    public Game clearVisitedAreas(Game game) {

        for (int i = 0; i < game.getPlayer().getLocationX(); i++) {

            for (int j = 0; j < game.getPlayer().getLocationY(); j++) {
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
