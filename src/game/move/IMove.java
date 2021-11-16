package game.move;


public interface IMove {

    void updatePlayerStepValue();

    void updateVisitedArea();

    void updateVisitedDirection();

    void updatePlayerLocation( );

    void updateBeforeStep();

    void updateAfterStep();


}
