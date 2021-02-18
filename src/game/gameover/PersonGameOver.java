package game.gameover;

import check.CheckAroundSquare;
import game.Game;

public class PersonGameOver implements IGameOver {

    @Override
    public boolean isGameOver(Game game) {
//        printGameSquares(game);
        if (new CheckAroundSquare().isThereAnyAvailableSquare(game)) {
            return false;
        }
         return true;
    }

//    void printGameSquares(Game game) {
//        int a[][] = {{2, 3}};
//        System.out.print("{ ");
//        for (int i = 0; i < game.getModel().getGameSquares().length; i++) {
//            System.out.print("{");
//            for (int j = 0; j < game.getModel().getGameSquares()[0].length; j++) {
//                System.out.print(game.getModel().getGameSquares()[j][i] + ",");
//            }
//            System.out.println("}");
//        }
//        System.out.print(" }");
//    }
}
