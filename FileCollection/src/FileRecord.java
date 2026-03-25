import java.util.Set;
import java.util.UUID;

public class FileRecord {
    private String id;
    private int fileSize;
    private Set<String> collections;

    public FileRecord(String id,int fileSize, Set<String> collections) {
        this.id = id;
        this.fileSize = fileSize;
        this.collections = collections;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public Set<String> getCollections() {
        return collections;
    }

    public void setCollections(Set<String> collections) {
        this.collections = collections;
    }
}
