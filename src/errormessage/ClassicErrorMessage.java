package errormessage;

import java.awt.Toolkit;

public class ClassicErrorMessage extends BaseErrorMessage {

    @Override
    public void showMessage(String error) {
        Toolkit.getDefaultToolkit().beep();
        System.out.println(error);
    }

}
