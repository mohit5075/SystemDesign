import java.io.File;
import java.util.List;

public abstract class FileNode {
    private String name;
    private FileNode parent;
    public FileNode(FileNode parent, String name){
        this.parent = parent;
        this.name = name;
    }
    public abstract List<String> ls();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileNode getParent() {
        return parent;
    }

    public void setParent(FileNode parent) {
        this.parent = parent;
    }
}
