import java.util.HashMap;
import java.util.Map;

public class Directory extends FileNode{
    Map<String,FileNode>children = new HashMap<>();
    public Directory(String name,FileNode parent){
        super(name,parent);
    }

    @Override
    protected boolean isDirectory() {
        return true;
    }

    public void addChild(FileNode node){
        children.put(node.getName(),node);
    }
    public void removeChild(FileNode node){
        children.remove(node.getName());
    }
    public Map<String,FileNode> getChilds(){
        return children;
    }
    public FileNode getChild(String name){
        return children.get(name);
    }
}