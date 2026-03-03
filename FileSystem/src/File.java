public class File extends FileNode{
    private StringBuilder content;
    public File(String name,FileNode parent){
        super(name,parent);
        this.content = new StringBuilder();
    }

    @Override
    protected boolean isDirectory() {
        return false;
    }

    public void write(String data) {
        content.append(data);
    }

    public String read() {
        return content.toString();
    }
}
