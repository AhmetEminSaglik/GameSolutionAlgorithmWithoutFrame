package game.play.input;

import SILINECEK.Yapilacaklar;
import errormessage.ErrorMessage;

public class RobotInput implements IBaseInput {

    @Override
    public int getInput() {
        Yapilacaklar.stickNote("Robotun ilerlemesi musait olan alanlar hesaplanip input seklinde alinacaktir\n"
                + " once bos alana ardindan gidilmemis alana gore hesaplanacaktir.");
        return -1;
    }
}
