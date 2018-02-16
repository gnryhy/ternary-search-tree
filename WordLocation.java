
public class WordLocation {

    private int position;
    private String fileName;

    public WordLocation(int position, String fileName){
        this.position = position;
        this.fileName = fileName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

