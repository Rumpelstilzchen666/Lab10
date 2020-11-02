package Ex3.App;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileNameFrame extends JFrame {
    private final JTextField fileNameJTF;
    private final JButton OKButton, undoButton;

    public FileNameFrame(String title) {
        setTitle("Введите адрес " + title + " документа");
        setSize(450, 120);
        setLayout(new GridLayout(2, 1));
        JPanel jtfPnl = new JPanel();
        fileNameJTF = new JTextField(50);
        fileNameJTF.setFont(new Font("MONOSPACED", Font.BOLD, 12));
        fileNameJTF.setText(new File("").getAbsolutePath());
        jtfPnl.add(fileNameJTF);
        add(jtfPnl);
        JPanel buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1, 2));

        JPanel buttonOKPnl = new JPanel();
        OKButton = new JButton("ОК");
        buttonOKPnl.add(OKButton);
        buttonPnl.add(buttonOKPnl);

        JPanel buttonUndoPnl = new JPanel();
        undoButton = new JButton("Отмена");
        buttonUndoPnl.add(undoButton);
        buttonPnl.add(buttonUndoPnl);

        add(buttonPnl);
        setVisible(true);
    }

    public String getFileName() {
        final String[] fileName = new String[]{null};
        OKButton.addActionListener(e -> fileName[0] = fileNameJTF.getText());
        undoButton.addActionListener(e -> fileName[0] = "☺☻♥♦♣♠");
        String allowed = "[\\S&&[^/*?<>|:]]";
        do {
            if(fileName[0] != null) {
                JOptionPane.showMessageDialog(this,
                        "Неверное имя файла!",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
                fileName[0] = null;
            }
            while(fileName[0] == null) {
                try {
                    Thread.sleep(100);
                } catch(Exception ignored) {
                }
            }
        } while(!fileName[0].equals("☺☻♥♦♣♠") &&
                !fileName[0].matches("^[A-Z]:\\\\[" + allowed + " ]*[.][" +
                        allowed + "&&[^\\\\]]+$"));
        return fileName[0];
    }
}
