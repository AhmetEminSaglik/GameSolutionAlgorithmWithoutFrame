package game.rule;

import game.Game;

import game.gameover.IGameOver;

public class BaseGameRule implements IGameOver {

    int remainStepBack = 10; // Kisi icin gerekli bir bilgi ve geri adim atma atabilme sayisini tutar. Robot icin sinirsiz geri adim vardir
    IGameOver gameOver;

    public BaseGameRule(IGameOver gameOver) {
        this.gameOver = gameOver;
    }

//    public int getRemainStepBack() { 
//
//        return remainStepBack;
//    }
//
//    public void setRemainStepBack(int remainStepBack) {
//        this.remainStepBack = remainStepBack;
//    }
    @Override
    public boolean isGameOver(Game game) {

        return gameOver.isGameOver(game);
    }

}
