package sleep;

import errormessage.ErrorMessage;
import game.gamerepo.player.robot.solution.FirstSolution;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sleep {

    public void sleep() {

        try {
            showWarningMessage();
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FirstSolution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sleep(int time) {
        try {
            showWarningMessage();
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(FirstSolution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void showWarningMessage() {
        ErrorMessage.appearWarnings(getClass(), " 404 ");
    }

//    public void deneme(int value) {
//        System.out.println("=====> " + value);
//        sleep(3000);
//    }
//
//    public void deneme(String value) {
//        System.out.println("=====> " + value);
//        sleep(3000);
//    }
}
