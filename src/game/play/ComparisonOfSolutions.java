package game.play;

import game.Game;

public class ComparisonOfSolutions {
    private Game game;
    private CopyModel copyModel;

    public ComparisonOfSolutions(Game game) {
        this.game = game;
        copyModel = new CopyModel();
    }

    public void compareSolution() {
        copyModel.sendModelToCompareAndAddToList(game.getModel());
    }
}
