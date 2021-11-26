package game.play;

import game.Game;
import print.FileWriteProcess;
import print.PrintAble;
import printarray.StringFormat;

public class ComparisonOfSolutions {
    private Game game;
    public CopyModel copyModel;

    public ComparisonOfSolutions(Game game) {
        this.game = game;
        copyModel = new CopyModel();
    }

    public void compareSolution() {
        copyModel.sendModelToCompareAndAddToList(game.getModel());
    }

    public void deleteBothIfTheyAreSame(CopyModel cp1, CopyModel cp2) {
        while (cp1.modelList.size() > 0 && cp2.modelList.size() > 0) {
            for (int i = 0; i < cp1.modelList.size(); i++) {
                for (int j = 0; j < cp2.modelList.size(); j++) {
                    if (cp1.comparedItemsAreSame(cp1.modelList.get(i), cp2.modelList.get(j))) {
                        cp1.modelList.remove(i);
                        cp2.modelList.remove(j);
                        i = 0;
                        j = 0;
                    }
                }
            }
        }
        PrintAble printAble = new FileWriteProcess("diff");
//        System.out.println("#####################  MODEL 1111111111111111111   #################");
        String text = "#####################  MODEL 1111111111111111111   #################";
        for (int i = 0; i < cp1.modelList.size(); i++) {
            text += "\n" +
                    "index : " + i + "\n";

            text += new StringFormat().getStringFormatArray(cp1.modelList.get(i));
            text += " -----------------------\n";

            printAble.append(text);
            text = "\n\n";
        }
        printAble.append("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
//        System.out.println("#####################  MODEL 22222222222222222222222  #################");
        text = "#####################  MODEL 22222222222222222222222  #################";
        for (int i = 0; i < cp2.modelList.size(); i++) {
            text += "\n" +
                    "index : " + i + "\n";
            text += new StringFormat().getStringFormatArray(cp2.modelList.get(i));
            text += " -----------------------";

            printAble.append(text);
            text = "\n\n";
        }

    }
}
