package game.play;

import game.move.fundamental.MoveBack;
import game.move.fundamental.MoveForward;

public class PlayerMove {
    //    private Player player;
    private MoveForward moveForward;
    private MoveBack moveBack;

    public PlayerMove(MoveForward moveForward, MoveBack moveBack) {
//        this.player = player;
        this.moveForward = moveForward;
        this.moveBack = moveBack;
    }

    public MoveForward getMoveForward() {
        return moveForward;
    }


    public MoveBack getMoveBack() {
        return moveBack;
    }


}
