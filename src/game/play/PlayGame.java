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
import sleep.Sleep;
import validation.Validation;

import javax.swing.*;


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
//        boolean oyunbitirildi = false;

        CopyModel copyModel = new CopyModel();
        while (!player.getGameRule().isGameOver(game)) {
            /*if (game.getModel().getGameSquares()[0][0] != 1) {
                System.out.println("1 in yeri degisti");
                new Sleep().sleep(10_000);
            }*/
            if (player.getStep() == Math.pow(game.getModel().getGameSquares().length, 2)) {
                gameFinishTime++;
                printGamelastStuation(game);
                System.out.println("OYUN BITIRILDI : " + gameFinishTime);


//                copyModel.sendModelToCompareAndAddToList(game.getModel());
//                if(gameFinishTime>1000)
//                new Sleep().sleep(5_000);
//                oyunbitirildi = true;

               /* Model model = new Model();
                for (int i = 0; i < game.getModel().getGameSquares().length; i++) {
                    for (int j = 0; j < game.getModel().getGameSquares().length; j++) {

                        model.getGameSquares()[i][j] = game.getModel().getGameSquares()[i][j];

                    }
                }*/
//                addModel(model);

//                new Sleep().sleep(100);
//                System.out.println("Oyun tamamlandi bundan sonraki adim nasil isleniyor onemli");
//                new Sleep().sleep(3_000);

//                System.out.println();
            }

            int choose = player.getInput(game);

            moveForwardOrBack = getMoveBackOrForward(choose);

            /*JOptionPane.showMessageDialog(null,
                    " moveForwardOrBack.getClass().getTypeName() "
                            + moveForwardOrBack.getClass().equals(MoveForward.class));*/

//            if (game.getPlayer().getStep() == 1 && moveForwardOrBack.getClass().equals(MoveForward.class)) {
//                JOptionPane.showMessageDialog(null,"ADIM SAYISI 1 VE GERI ADIM ATILMAK ISTENIYOR");

//            } else {
            /*if (game.getPlayer().getStep() == 1&& moveForwardOrBack.getClass().getTypeName()) {


            }*/
//            System.out.println("SECILEN BOLGE : " + moveForwardOrBack.getClass().getSimpleName());
                moveForwardOrBack.move(
                        new DirectionLocation().
                                getLocationValueAccordingToEnteredValue(game, choose));

//                printGamelastStuation(game);
//                printArrays(game);

           /* if (oyunbitirildi) {
                System.out.println("OYUN BITIRILDI VE SONRAKI ILK ASAMALAR");
                new Sleep().sleep(1_000);
                oyunbitirildi = false;
            }*/

//            new Sleep().sleep(1_000);

        }

    }


    void printArrays(Game game) {
        new PrintArray().printMultipleArrayBoolean(game.getModel().getVisitedAreas());
        new PrintArray().printMultipleArrayBoolean(game.getPlayer().getVisitedDirections());
//        new Sleep().sleep(250);
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

        System.out.println("ADIM SAYISI : " + game.getPlayer().getStep());
        new PrintArray().printMultipleArray(game.getModel().getGameSquares());
        System.out.println("----------------------------------");
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
