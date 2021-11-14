package game.move;

import game.Game;
import game.gamerepo.GameModelProcess;
import game.gamerepo.updategamemodel.UpdateForMovedBack;
import game.location.DirectionLocation;
import game.location.Location;
import game.location.LocationsList;
import game.move.seal.SealationOfLocation;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.util.ArrayList;

public class MoveBack extends Move {

    public MoveBack(Game game) { //, DirectionLocation proceedLocation
        super(game);
        updateValuesInGameModel = new UpdateForMovedBack(game);

    }

    //    @Override
//    public boolean isItAvailableToMove(Model gameModel, int choose) {
//        return (gameModel.getPlayer().getStep() > 1) ? true : false;
//    }
    @Override
    public void updatePlayerStepValue() {
        decreasePlayerStepValue();
    }

    @Override
    public void updateVisitedDirection(DirectionLocation location) {
//        updateValuesInGameModel.updateValueVisitedDirection();
//        game.getPlayer().updateVisitedDirection();
//        new SealationOfLocation(game).updateLocationCondition(
//                game.getPlayer().updateVisitedDirection();
//        );
    }

   /* @Override
    public void updateVisitedArea() {
        updateValuesInGameModel.updateValueVisitedArea();
    }*/
//
//    @Override
//    public void updateVisitedDirection(Location location) {
//        updateValuesInGameModel.changeVisitedDirection(location);
//    }


    @Override
    public void updatePlayerLocation(Location location) {
        System.out.println("MUHTEMELEN 0 LANINCA GUNCELLENECEK KONUM : " + location);
        updateValuesInGameModel.changePlayerLocation(location);
    }


    void clearAllDirectionBeforeGoBack() {
        ArrayList<DirectionLocation> directionLocationList = new LocationsList().getList();
        for (int i = 0; i < directionLocationList.size(); i++) {
            updateValuesInGameModel.updateValueVisitedDirection(directionLocationList.get(i));
        }

    }

    @Override
    public void updateBeforeStep(DirectionLocation location) {
//        System.out.println(getClass().getSimpleName() + " -->  before > update visited direction");
//        updateVisitedDirection(getLocation());
        updateVisitedArea();
        clearAllDirectionBeforeGoBack();
        removeMaxStepBeforeGoingLastStep();
    }

    @Override
    public void updateAfterStep() {


//        updatePlayerStepValue();
        /*JOptionPane.showMessageDialog(null, "Aslinda buraya  geri adim atarken (Mesela 10 dan kuzey,dogu 2 yon muhurlu olacak\n" +
                "ve geri adim atarken 10. adimin muhurleri silinecek cunku zaten 9. adimda 10. adim yeri muhurlu olacak ve yeniden 10 adim olusacak baska bir konumda\n" +
                "boylece geri adim atarken muhurler silinmeli, ileri adim atarken muhurlenmeli");*/
//        System.out.println(" !!!!!!!!!!!!!!!!!!    BURAYA MUHURLE SONRA GERI ADIM AT YAPABILRIM ONCEKI ADIMA DOGRU");
//        System.out.println(getClass().getSimpleName() + "getLocation()   :::  >>>>>>>> " + getDirectionLocation());
//        System.out.println(getClass().getSimpleName() + "PLAYER .getLocation()   :::  >>>>>>>> " + game.getPlayer().getLocation());
        updatePlayerLocation(getDirectionLocation());


    }

    /**
     * Moveback icin bu fonk dolu
     */


    void decreasePlayerStepValue() {
        //getPlayer().increaseStep();
        updateValuesInGameModel.updatePlayerStepValue();
    }

    void removeMaxStepBeforeGoingLastStep() {
//        int maxValueInTable = new GameModelProcess(game).findMaxStep();

        new GameModelProcess(game).deleteMaxStep(game.getPlayer().getStep());
        //System.out.println("Max Value in Table  << "+maxValueInTable+" >> value is deleted. ");
    }
}
