package WILL_REMOVE;

import Game.GameModel;
import printarray.PrintArray;
import WILL_REMOVE.MovableDirections;

public class Solution {

    int locationX = 0;
    int locationY = 0;
    GameModel gameModel;

    public Solution(GameModel gameModel) {
        this.gameModel = gameModel;
        runTheSolution(gameModel);
    }

    public void runTheSolution(GameModel gameModel) {
        //  WaysToGo waysToGo = new WaysToGo();

      //  PrintArray<String> p = new PrintArray<>();

        MovableDirections movableDirections = new MovableDirections(gameModel);
        System.out.println(movableDirections.getWayCounter());


        /*
        Etrafina baksin kac yol var 
        3 tane rahat ilerleyebilecegi yol var .  siradan ilerlesin.   */
    }

}
