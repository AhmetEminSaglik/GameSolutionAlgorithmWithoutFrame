package play;

import Game.GameModel;
import Game.player.Player;
import compass.Compass;
import location.SwitchDirection;

public class StartGame {

    GameModel gameModel;
    Player player;
    Compass compass;

    UpdateGameModel updateGameModel = new UpdateGameModel(gameModel);
    SelectFirstSqaureToStart selectFirstSqaureToStart = new SelectFirstSqaureToStart(gameModel);

    public StartGame(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void startGame() {

    }

    void getReady() {
        selectFirstSqaureToStart.selectSquareStart(0, 0);

        updateGameModel.moveForward(selectFirstSqaureToStart);

        SwitchDirection switchDirection = new SwitchDirection(compass);
    }
}
