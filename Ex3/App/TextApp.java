package Ex3.App;

import Ex3.Documents.CreateTextDocument;
import Ex3.Documents.TextDocument;

import javax.swing.*;
import java.awt.*;

public class TextApp extends App {
    protected final TextArea textArea;

    public TextApp(String filePath) {
        super(filePath, new CreateTextDocument());
        textArea = new TextArea("", 10, 10,
                TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea.setFont(new Font("MONOSPACED", Font.BOLD, 14));
        add(textArea, BorderLayout.CENTER);
        setContent();
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextApp(args.length > 0 ? args[0] : null).work();
    }

    @Override
    protected void extraActions() {
        if(actions[0] == 5)
            new TextApp(null);
    }

    @Override
    protected void addItemsToMenuFile(JMenu menuFile) {
        JMenuItem menuFNewFrame = new JMenuItem("Новое окно");
        menuFile.add(menuFNewFrame);
        menuFNewFrame.addActionListener(e -> actions[0] = 5);
    }

    @Override
    protected void addMenuToMenuBar(JMenuBar menuBar) {

    }

    @Override
    protected void setContent() {
        textArea.replaceRange(((TextDocument) doc).getText(), 0,
                textArea.getText().length());
    }

    @Override
    protected boolean isChanged() {
        String text = textArea.getText();
        return (doc.getName() == null && text.length() != 0) ||
                !((TextDocument) doc).getText().equals(text);
    }

    @Override
    protected void saveContentTo(String fileName) {
        TextDocument txtDoc = (TextDocument) createDoc.createOpen(fileName);
        txtDoc.setText(textArea.getText());
        doc = txtDoc;
    }
}
