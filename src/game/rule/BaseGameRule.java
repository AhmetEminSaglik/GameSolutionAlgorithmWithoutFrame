package game.rule;

import errormessage.ErrorMessage;
import game.Game;

import game.gameover.IGameOver;
import sleep.Sleep;

public class BaseGameRule implements IGameOver {

    int remainStepBack;
    IGameOver gameOver;

    public BaseGameRule(IGameOver gameOver) {
        this.gameOver = gameOver;
    }

    public int getRemainStepBack() {
        System.out.println("UYARI  ::: Eger remainStepBack degeri  0 ise override edilmek zorundadir ki 9 degerini kullanabiliyor olalim" + remainStepBack);
        ErrorMessage.appearClassicError(getClass(), " Ust satirdaki ciktiyi buradan silebilirsin");
        new Sleep().sleep(3000);

        return remainStepBack;
    }

    public void setRemainStepBack(int remainStepBack) {
        this.remainStepBack = remainStepBack;
    }

    @Override
    public boolean isGameOver(Game game) {
        return gameOver.isGameOver(game);
    }

}
