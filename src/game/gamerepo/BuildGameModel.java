package game.gamerepo;

import game.gamerepo.player.Player;
import validation.SquareValidationGame;

public class BuildGameModel {

    private int horizontalSquare;
    private int verticalSquare;
    private GameModel gameModel;

    public BuildGameModel(Player player, int verticalSquare, int horizontalSquare) throws InterruptedException {
        new SquareValidationGame(verticalSquare, horizontalSquare);
        this.horizontalSquare = horizontalSquare;
        this.verticalSquare = verticalSquare;
        gameModel = fillGameModel(player);

    }

    public GameModel fillGameModel(Player player) throws InterruptedException {
        GameModel gameModel = new GameModel(player);

        gameModel.setGameSquares(createMultipleArrayFromIntegers(verticalSquare, horizontalSquare));
        //gameModel = prepareNullValues(gameModel);
        gameModel = creatVisitArea(gameModel);
//        gameModel = setVisitedDirectionsArray(gameModel);

        return gameModel;
    }

//    public GameModel setVisitedDirectionsArray(GameModel gameModel) {
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

    public GameModel creatVisitArea(GameModel gameModel) {
        boolean visitedAreas[][] = new boolean[verticalSquare][horizontalSquare];
        gameModel.setVisitedAreas(visitedAreas);
        clearVisitedAreas(gameModel);
        return gameModel;
    }

    public GameModel clearVisitedAreas(GameModel gameModel) {

        for (int i = 0; i < gameModel.getPlayer().getLocationX(); i++) {

            for (int j = 0; j < gameModel.getPlayer().getLocationY(); j++) {
                gameModel.getVisitedAreas()[i][j] = false;
            }
        }
        return gameModel;
    }

    public GameModel getGameModel() {

        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

}