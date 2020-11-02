package Ex3.Documents;

import java.io.File;

public abstract class Document {
    protected File file;

    public Document(String fileName) {
        this.file = new File(fileName);
    }

    public Document() {
        this.file = null;
    }

    public String getName() {
        return file == null ? null : file.getName();
    }

    public String getShortName() {
        String name = getName();
        if(name == null) return null;
        int i = name.length() - 1;
        for(; i >= 0 && name.charAt(i) != '.'; i--) { }
        return name.substring(0, i);
    }

    public String getPath() {
        return file == null ? null : file.getAbsolutePath();
    }
}
