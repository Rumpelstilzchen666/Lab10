package Ex3.Documents;

import java.io.*;

public class TextDocument extends Document {

    public TextDocument() {
        super();
    }

    public TextDocument(String fileName) {
        super(fileName);
    }

    public String getText() {
        StringBuilder text = new StringBuilder();
        if(file != null) {
            try {
                BufferedReader reader =
                        new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while(line != null) {
                    text.append(line).append('\n');
                    line = reader.readLine();
                }
                text.delete(text.length() - 1, text.length());
                reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }

    public void setText(String text) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
