package check;

import compass.Compass;
import compass.DirectionCompass;
import game.Game;
import game.location.DirectionLocation;

import java.util.ArrayList;

import game.location.LocationsList;

public class CheckAroundSquare {

    Compass compass = new DirectionCompass();
    CheckSquare checkSquare = new CheckSquare();
    ArrayList<DirectionLocation> locationList = new LocationsList().getList();

 /*   public int getNumberOfHowManySquaresAreAvailable(Game game) {

        int availableDirectionCounter = 0;

        for (int i = 0; i < locationList.size(); i++) {
            if (isLocationAvailable(game, locationList.get(i).getId())) {

                availableDirectionCounter++;
            }
        }
        return availableDirectionCounter;
    }*/

    public boolean isThereAnyAvailableSquare(Game game) {
        compass = game.getPlayer().getCompass();
        checkSquare.setCompass(compass); // bu normalde isLocationAvailable() fonksiyonunun ilk satiriydi

//        locationList = getLocationList(game.getPlayer());

//        new Sleep().sleep(3000);
        //  System.out.println("locationList.size() " + locationList.size());
        for (int i = 0; i < locationList.size(); i++) {
//            System.out.println("forrr L:LLLLL " + locationList.get(i).getId());
            if (isLocationAvailable(game, locationList.get(i).getId())) {
                //System.out.println(" Available direction : " + locationList.get(i).getClass().getSimpleName());
                return true;
            }
        }
        return false;
    }

    boolean isLocationAvailable(Game game, int directionIndex) {

        return checkSquare.isSquareFreeFromVisitedArea(game, directionIndex);
    }

//    public ArrayList<DirectionLocation> getLocationList(Player player) {
//        if (locationList == null) {
//            locationList = new LocationsList(player.getCompass()).getList();
//        }
//        return locationList;
//    }
//
//    public ArrayList<DirectionLocation> getLocationList() {
//        if (locationList == null) {
//            ErrorMessage.appearFatalError(getClass(), "Daha once tanimlanmamis yon lokasyonundan yon almaya calisiyorsunuz");
//        }
//        return locationList;
//    }
//
//    public void setLocationList(ArrayList<DirectionLocation> locationList) {
//        this.locationList = locationList;
//    }
}
