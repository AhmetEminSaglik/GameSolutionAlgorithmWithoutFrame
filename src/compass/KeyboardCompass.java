package compass;

public class KeyboardCompass extends Compass {

    public KeyboardCompass() {
        fillValues();
    }

    @Override
    void fillValues() {
        setNorth(8);
        setNorthEast(9);
        setEast(6);
        setSouthEast(3);
        setSouth(2);
        setSouthWest(1);
        setWest(4);
        setNorthWest(7);
    }

    /*  int NORTH_Move_Int = 8;
    int NORTH_EAST_Move_Int = 9;
    int EAST_Move_Int = 6;
    int SOUTH_EAST_Move_Int = 3;
    int SOUTH_Move_Int = 2;
    int SOUTH_WEST_Move_Int = 1;
    int WEST_Move_Int = 4;
    int NORTH_WEST_Move_Int = 7;

    char NORTH_Move_Char = 'y';
    char NORTH_EAST_Move_Char = 'u';
    char EAST_Move_Char = 'j';
    char SOUTH_EAST_Move_Char = 'm';
    char SOUTH_Move_Char = 'n';
    char SOUTH_WEST_Move_Char = 'b';
    char WEST_Move_Char = 'g';
    char NORTH_WEST_Move_Char = 't';*/
}
