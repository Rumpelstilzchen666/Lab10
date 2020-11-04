package Ex3.App;

import Ex3.Documents.CreateDocument;
import Ex3.Documents.Document;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public abstract class App extends JFrame {
    protected final int[] actions = {0};
    protected final CreateDocument createDoc;
    protected Document doc;

    protected App(String filePath, CreateDocument createDoc) {
        setSize(500, 500);
        setLayout(new BorderLayout());
        this.createDoc = createDoc;
        doc = createDoc.createOpen(filePath);
        setTitle((doc.getShortName() == null ? "Безымянный" : doc.getName()));

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Файл");
        JMenuItem menuFCreate = new JMenuItem("Создать");
        menuFile.add(menuFCreate);
        JMenuItem menuFOpen = new JMenuItem("Открыть…");
        menuFile.add(menuFOpen);
        JMenuItem menuFSave = new JMenuItem("Соханить");
        menuFile.add(menuFSave);
        JMenuItem menuFSaveAs = new JMenuItem("Соханить как…");
        menuFile.add(menuFSaveAs);
        addItemsToMenuFile(menuFile);
        menuBar.add(menuFile);
        addMenuToMenuBar(menuBar);
        add(menuBar, BorderLayout.NORTH);

        menuFCreate.addActionListener(e -> actions[0] = 1);
        menuFOpen.addActionListener(e -> actions[0] = 2);
        menuFSave.addActionListener(e -> actions[0] = 3);
        menuFSaveAs.addActionListener(e -> actions[0] = 4);
    }

    protected abstract void addItemsToMenuFile(JMenu menuFile);

    protected abstract void addMenuToMenuBar(JMenuBar menuBar);

    protected void work() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch(Exception ignored) {
            }
            switch (actions[0]) {
                case 1 -> {
                    if(safeSaveChanges()) {
                        doc = createDoc.createNew();
                        setTitle("Безымянный");
                        setContent();
                    }
                }
                case 2 -> {
                    if(safeSaveChanges())
                        openFile();
                }
                case 3, 4 -> saveContent(actions[0] == 4);
                default -> extraActions();
            }
            actions[0] = 0;
        }
    }

    protected abstract void setContent();

    protected void openFile() {
        Document newDoc = createDoc.createOpen();
        if(newDoc != null) {
            doc = newDoc;
            setTitle(doc.getShortName());
            setContent();
        }
    }

    protected abstract void extraActions();

    protected boolean safeSaveChanges() {
        if(isChanged()) {
            UIManager.put("OptionPane.yesButtonText", "Сохранить");
            UIManager.put("OptionPane.noButtonText", "Не сохранять");
            UIManager.put("OptionPane.cancelButtonText", "Отмена");
            int result = JOptionPane.showConfirmDialog(this,
                    "Вы хотите сохранить изменения в файле \"" + getTitle() +
                            "\"?",
                    "Подтвердить замену", JOptionPane.YES_NO_CANCEL_OPTION);
            if(result == JOptionPane.YES_OPTION) return saveContent(false);
            return result == JOptionPane.NO_OPTION;
        }
        return true;
    }

    protected abstract boolean isChanged();

    protected boolean saveContent(boolean createNewFile) {
        String fileName = doc.getPath();
        if(createNewFile || fileName == null)
            fileName = createNewFile();
        if(fileName == null)
            return false;
        saveContentTo(fileName);
        setTitle(doc.getShortName());
        return true;
    }

    protected String createNewFile() {
        FileNameFrame fileNameFrame = new FileNameFrame("нового");
        String fileName = fileNameFrame.getFileName();
        File newFile, newFileParent;
        while(!fileName.equals("☺☻♥♦♣♠")) {
            newFile = new File(fileName);
            if(newFile.isFile()) {
                if(newFile.getName().equals(doc.getName()))
                    break;
                else {
                    UIManager.put("OptionPane.yesButtonText", "Да");
                    UIManager.put("OptionPane.noButtonText", "Нет");
                    int result = JOptionPane.showConfirmDialog(fileNameFrame,
                            newFile.getName() +
                                    " уже существует.\nВы хотите заменить его?",
                            "Подтвердить замену", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION) {
                        if(newFile.delete())
                            break;
                        else
                            JOptionPane.showMessageDialog(this,
                                    "Данный файл невозможно заменить!",
                                    "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else {
                newFileParent = newFile.getParentFile();
                if(newFileParent.exists())
                    break;
                else
                    if(newFileParent.mkdirs())
                        break;
                    else
                        JOptionPane.showMessageDialog(this,
                                "Невозможно создать файл по указанному адресу!",
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            fileName = fileNameFrame.getFileName();
        }
        fileNameFrame.setVisible(false);
        return fileName.equals("☺☻♥♦♣♠") ? null : fileName;
    }

    protected abstract void saveContentTo(String fileName);
}
