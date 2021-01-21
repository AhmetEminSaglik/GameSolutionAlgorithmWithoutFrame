package sleep;

import game.gamerepo.player.robot.solution.FirstSolution;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sleep {

    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FirstSolution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(FirstSolution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
