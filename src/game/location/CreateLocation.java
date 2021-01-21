package game.location;

public class CreateLocation extends DirectionLocation {

    @Override
    public int getId() {
      //  ErrorMessage.appearClassicError("Undefined value");
        return -1;
    }

    public CreateLocation create(int x, int y) {
        setX(x);
        setY(y);
        return this;
    }
}
