package game.location;

import errormessage.ErrorMessage;

public class CreateLocation extends DirectionLocation {

    @Override
    public int getId() {
        ErrorMessage.appearClassicError(getClass(),"Undefined value");
        return -1;
    }

}
