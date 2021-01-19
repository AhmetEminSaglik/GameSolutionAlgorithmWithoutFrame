package game.gamerepo.player;

import game.play.input.IBaseInput;

public abstract class Player implements IPlayer {

    private int locationX = 0;
    private int locationY = 0;
    private int step = 0;
    private IBaseInput input;

    public void func() {
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void printToString() {
        System.out.println(toString());
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void increaseStep() {
        step++;
    }

    public void decreaseStep() {
        step--;
    }

    @Override
    public String toString() {
        return "Player{" + "locationX=" + locationX + ", locationY=" + locationY + ", step=" + step + '}';
    }

    public void printPlayer() {
        System.out.println("******************");
        System.out.println(toString());
    }

    public abstract int getInput();

}
