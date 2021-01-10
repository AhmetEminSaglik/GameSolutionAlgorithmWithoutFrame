package play.step;

import Game.FillGameSquare;
import Game.GameModel;
import Game.updategamemodel.UpdateValuesInGameModel;
import location.Location;
import move.MovePlayer;

public class GetStep extends Step {

    GameModel gameModel;
    MovePlayer movePlayer;
    FillGameSquare fillGameSquare;
    UpdateValuesInGameModel updateValuesInGameModel;
    private Location location;

    public GetStep(GameModel gameModel, UpdateValuesInGameModel updateValuesInGameModel) {
        this.gameModel = gameModel;
        movePlayer = new MovePlayer(gameModel);
        fillGameSquare = new FillGameSquare(gameModel);
        this.updateValuesInGameModel = updateValuesInGameModel;
    }

    @Override
    void updatePlayerStepValue() {
        updateValuesInGameModel.changePlayerStepValue();
    }

    @Override
    void updateVisitedArea() {
        System.out.println(getClass().getSimpleName() + "  Burada ileri adim atarken area muhurlemede sorun yok ama GERI ADIM aterken AREA MUHUR lemede sorun olabilir");
        updateValuesInGameModel.changeValueVisitedArea();
    }

    @Override
    void updateVisitedDirection(Location location) {
        updateValuesInGameModel.changeVisitedDirection(location);
    }

    @Override
    void updatePlayerLocation(Location location) {
        updateValuesInGameModel.changePlayerLocation(location);
    }

    @Override
    void updateAfterStep() {
        updatePlayerStepValue();
        updatePlayerLocation(getLocation());
        updateVisitedArea();
    }

    @Override
    void updateBeforeStep() {
        updateVisitedDirection(getLocation());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
