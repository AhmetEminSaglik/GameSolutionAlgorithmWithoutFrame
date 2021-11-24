package print;

import errormessage.ErrorMessage;
import errormessage.joptionpanel.ShowPanel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteProcess implements PrintAble, CloseAbleFile {
    String fileName;
    BufferedWriter bufferedWriter;

    final boolean WRITE_OVER_FILE = false;
    final boolean APPEND_TO_FILE = true;
    boolean filePrintSituation;

    public FileWriteProcess(String name) {
        fileName = name + ".txt";

    }

    public FileWriteProcess(String name, int squareLengt) {
        fileName = name + "_" + squareLengt + ".txt";


    }

    void openFile() {
//        ShowPanel.show(getClass(), "FILE WILL OPEN");
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileName, filePrintSituation));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void appendToFile(String text) {
        updateFileWriteOrAppendCondtion(APPEND_TO_FILE);
        openFile();
        try {
            bufferedWriter.append(text);
        } catch (IOException e) {
            ErrorMessage.appearFatalError(getClass(), e.getMessage());
        } finally {
            closeFile();
        }

    }

    void writeToFile(String text) {
        updateFileWriteOrAppendCondtion(WRITE_OVER_FILE);
        openFile();
        try {
            bufferedWriter.write(text);
        } catch (IOException e) {
            ErrorMessage.appearFatalError(getClass(), e.getMessage());
        } finally {
            closeFile();
        }
    }


    @Override
    public void write(String text) {
        writeToFile(text);
//        ShowPanel.show(getClass(), "gelen text : " + text);
    }

    @Override
    public void append(String text) {
        appendToFile(text);
//        ShowPanel.show(getClass(), "gelen text : " + text);
    }

    @Override
    public void closeFile() {
//        ShowPanel.show(getClass(), "FILE WILL CLOSE");
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            ErrorMessage.appearFatalError(getClass(), e.getMessage());
        }

    }

    void updateFileWriteOrAppendCondtion(boolean newSituation) {
        filePrintSituation = newSituation;
    }

}
