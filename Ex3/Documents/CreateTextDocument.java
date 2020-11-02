package Ex3.Documents;

public class CreateTextDocument extends CreateDocument {
    @Override
    public Document createNew() {
        return new TextDocument();
    }

    @Override
    public Document getOpen(String filePath){
        return new TextDocument(filePath);
    }
}
