import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends FileNode{
    private Map<String,FileNode> directoryMap;
    public Directory(FileNode parent,String name) {
        super(parent,name);
        this.directoryMap = new HashMap<>();
    }

    @Override
    public List<String> ls() {
        return new ArrayList<>(directoryMap.keySet());
    }

    public void addDirectory(FileNode fileNode){
        directoryMap.putIfAbsent(fileNode.getName(),fileNode);
    }
    public FileNode getDirectory(String name){
        return directoryMap.get(name);
    }
}
