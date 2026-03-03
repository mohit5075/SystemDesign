public abstract class FileNode{
    private String name;
    private FileNode parent;
    public FileNode(String name, FileNode parent){
        this.name = name;
        this.parent = parent;
    }
    public String getName(){
        return name;
    }
    public FileNode getParent(){
        return parent;
    }
    protected abstract boolean isDirectory();
}
