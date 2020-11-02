package Ex3.Documents;

import Ex3.App.FileNameFrame;

import javax.swing.*;
import java.io.File;

public abstract class CreateDocument {
    public abstract Document createNew();

    public abstract Document getOpen(String filePath);

    public Document createOpen() {
        FileNameFrame fileNameFrame = new FileNameFrame("существующего");
        String fileName = fileNameFrame.getFileName();
        while(!fileName.equals("☺☻♥♦♣♠") && !new File(fileName).isFile()) {
            JOptionPane.showMessageDialog(fileNameFrame,
                    "Такого файла не существует!",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            fileName = fileNameFrame.getFileName();
        }
        fileNameFrame.setVisible(false);
        return fileName.equals("☺☻♥♦♣♠") ? null : getOpen(fileName);
    }

    public Document createOpen(String filePath) {
        String allowed = "[\\S&&[^/*?<>|:]]";
        return filePath == null ||
                !filePath.matches("^[A-Z]:\\\\[" + allowed + " ]*[.][" +
                        allowed + "&&[^\\\\]]+$") ? createNew() :
                getOpen(filePath);
    }
}
