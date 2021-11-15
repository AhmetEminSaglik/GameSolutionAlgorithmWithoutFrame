package game.gamerepo.player.robot;

import compass.Compass;
import compass.DirectionCompass;
import errormessage.ErrorMessage;
import game.Game;
import game.gameover.RobotGameOver;
import game.gamerepo.player.Player;
import game.gamerepo.player.robot.solution.BaseSolution;
import game.location.DirectionLocation;
import game.location.LocationsList;
import game.play.input.robot.RobotInput;
import game.rule.BaseGameRule;

import java.util.ArrayList;

public class Robot extends Player {

    private RobotMemory robotMemory;

    private BaseSolution solution;

    public Robot(Game game, BaseSolution solution) {
        super(game);
        this.solution = solution;

    }

    @Override
    public Compass getCompass() {
        return new DirectionCompass();
    }

    public RobotMemory getRobotMemory() {

        if (robotMemory == null) {
            if (getGame() == null) {
                new ErrorMessage().appearFatalError(getClass(), "Robot -> GAME = NULL");
            } else {
                robotMemory = new RobotMemory(getGame());
            }
        }
        return robotMemory;
    }

    public void setRobotMemory(RobotMemory robotMemory) {
        this.robotMemory = robotMemory;
    }

    @Override
    public int getInput(Game game) {
        return new RobotInput(solution, game).getInput(getRobotMemory());
    }

    public BaseSolution getSolution() {
        return solution;
    }

    public void setSolution(BaseSolution solution) {
        this.solution = solution;
    }

  /*  public Game getGame() {
        return getGame();
    }*/

//    public void setGame(Game game) {
//        this.game = game;
//    }

    @Override
    public BaseGameRule getGameRule() {
        if (gameRule == null) {
            gameRule = new BaseGameRule(new RobotGameOver(getGame()));
        }
        return gameRule;
    }


    @Override
    public void updateVisitedDirection(boolean movedFordward, DirectionLocation location) {// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! BURASI REFACTOR EDILECEK adim sayisi eklenecek
//        System.out.println("location.getId() -> " + location.getId());

        if (getStep() > 1) {//location.getId() >=0
//        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//        new Sleep().sleep(3000);
            if (movedFordward == true) {
//            System.out.println("Forward Step " + getStep());

            /*getRobotMemory()
                    .*/
                getVisitedDirections()[getStep() - 1][location.getId()] = true;
//            System.out.println(" MOVEFORWARRDD  STEPPPP " + getStep() + " /./" +/* getRobotMemory()
//                    .*/getVisitedDirections()[getStep()][location.getId()]);
            } else {
                ArrayList<DirectionLocation> locationsList = new LocationsList().getList();

//            System.out.println("Back Step : " + getStep());

                if (getStep() < Math.pow(getGame().getModel().getGameSquares().length, 2)) {

//                System.out.println(" X : " + getGame().getPlayer().getLocation().getX() + " Y : " + getGame().getPlayer().getLocation().getY());

//                    new PrintArray().printMultipleArrayBoolean(getRobotMemory().getVisitedDirections());
//                    System.out.println("-----");
//                System.out.println("GUNCEL ADIM SAYISIIIIIIIIIIIIIIII : " + getStep());
                    for (int i = 0; i < locationsList.size() - 1; i++) {//last locationu almamak icin  < size -1 dedim
//                    System.out.println(" getRobotMemory().getVisitedDirections()[" + getStep() + "][locationsList.get(" + i + ").getId()] " +/* getRobotMemory().*/getVisitedDirections()[getStep()][locationsList.get(i).getId()]);
                        /*getRobotMemory().*/
                        getVisitedDirections()[getStep()][locationsList.get(i).getId()] = false;

                    }
//                JOptionPane.showMessageDialog(null, "Sorun su 19. adimda geri adim atmadan once cevresindeki muhurleri temizliyoruz  ama,\n" +
//                        "18. adimdan 19. adima giderken muhurlenmedigi icin tum alanlar muhursuz gorunuyor. ");
//                    System.out.println("-----");
//                    new PrintArray().printMultipleArrayBoolean(getRobotMemory().getVisitedDirections());

//                    new Sleep().sleep(20_000);
                }
            }
        }
//        System.out.println("Islem yapildi robot tarafindan");
//        new Sleep().sleep(5000);
    }

}
