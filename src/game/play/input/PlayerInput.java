package game.play.input;

public class PlayerInput implements IBaseInput {

    private SafeScannerInput scannerInput = new SafeScannerInput();

    @Override
    public int getInput() {

        return scannerInput.getInput();

    }

}
