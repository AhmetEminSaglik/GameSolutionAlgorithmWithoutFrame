package game.play;

import game.Game;
import game.gamerepo.CreateLocationOfLastStep;
import game.gamerepo.Model;
import game.gamerepo.player.Player;
import game.location.DirectionLocation;
import game.location.Location;
import game.move.Move;
import game.move.MoveBack;
import game.move.MoveForward;
import printarray.PrintArray;
import validation.Validation;


public class PlayGame {

    Game game;
    Player player;
    PrepareGame prepareGame;

    Validation validation = new Validation();

    public PlayGame(Game game) {
        this.game = game;
        player = game.getPlayer();
    }


    public void playGame() {
        prepareGame = new PrepareGame(game);

        Move moveForwardOrBack;

        printGamelastStuation(game);

        long gameFinishTime = 0;

        CopyModel copyModel = new CopyModel();
        while (!player.getGameRule().isGameOver(game)) {
            if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
                gameFinishTime++;
                printGamelastStuation(game);
                System.out.println("OYUN BITIRILDI : " + gameFinishTime);
                copyModel.sendModelToCompareAndAddToList(game.getModel());
               /* Model model = new Model();
                for (int i = 0; i < game.getModel().getGameSquares().length; i++) {
                    for (int j = 0; j < game.getModel().getGameSquares().length; j++) {

                        model.getGameSquares()[i][j] = game.getModel().getGameSquares()[i][j];

                    }
                }*/
//                addModel(model);

//                new Sleep().sleep(100);

            }

            int choose = player.getInput(game);

            moveForwardOrBack = getMoveBackOrForward(choose);
//            System.out.println("SECILEN BOLGE : " + moveForwardOrBack.getClass().getSimpleName());
            moveForwardOrBack.move(
                    new DirectionLocation().
                            getLocationValueAccordingToEnteredValue(game, choose));

            printGamelastStuation(game);
//            new Sleep().sleep(1_000);

        }

    }

   /* ArrayList<Model> modelList = new ArrayList<>();
    static int addModelVal = 0;

    void addModel(Model model) {
        addModelVal++;
        System.out.println("YENIDEN GELINDIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII  beklenen dizi degeri max : " + addModelVal);
        System.out.println("listedeki dizi : ");
        if (modelList.size() == 0) {
            modelList.add(model);
        } else {
            for (int i = 0; i < modelList.size(); i++) {
                int sameSquareValue = 0;

                System.out.println("iiiiiiiiiiiiiiiiiiii");
                for (int a = 0; a < game.getModel().getGameSquares().length; a++) {
                    System.out.println("AAAAAAAAAAAAAA");
                    for (int b = 0; b < game.getModel().getGameSquares().length; b++) {
                        System.out.println("BBBBBBBBBBBBB");
                        if (modelList.get(i).getGameSquares()[a][b] == model.getGameSquares()[a][b]) {
                            System.out.println(" modelList.get(" + i + ").getGameSquares()[a][b]: " + modelList.get(i).getGameSquares()[a][b] + " //// model.getGameSquares()[a][b] " + model.getGameSquares()[a][b]);
                            sameSquareValue++;

                        } else {
                            System.out.println("Farkli olan deger  : " + sameSquareValue);
                            modelList.add(model);
                            System.out.println("BAK BAKAYIM NEREDEN BASLATICAK");
                            new Sleep().sleep(3_000);

                            break;


                        }

                    }
                }
                System.out.println(" AYNI IKI DIZI EKLENMEDIIIII " + sameSquareValue);
                new PrintArray().printMultipleArray(modelList.get(i).getGameSquares());
                System.out.println("888888888888888888888888888");
                new PrintArray().printMultipleArray(model.getGameSquares());


                new Sleep().sleep(20_000);
            }
        }

    }*/

    void printGamelastStuation(Game game) {

        new PrintArray().printMultipleArray(game.getModel().getGameSquares());

    }

    Move getMoveBackOrForward(int index) {
        if (index == player.getCompass().getLastLocation()) {
            //   System.out.println("index : " + index);

//            System.out.println("MOVE BACK ");
            return new MoveBack(game);
        }
//        System.out.println("MOVE FORWARD ");

        return new MoveForward(game);
    }

    Location getLocationValueAccordingToEnteredValue(int choose) {
        if (choose == game.getPlayer().getCompass().getLastLocation()) {
            return new CreateLocationOfLastStep(game).createLastStepLocation();
        }
        return prepareGame.switchDirection.choseDirection(choose);
    }
}
