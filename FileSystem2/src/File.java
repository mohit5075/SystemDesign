import java.util.ArrayList;
import java.util.List;

public class File extends FileNode{
    private StringBuilder content;
    public File(FileNode parent,String name) {
        super(parent,name);
        this.content = new StringBuilder();
    }

    @Override
    public List<String> ls() {
        return List.of(getName());
    }

    public String getContent(){
        return content.toString();
    }
    public void addContent(String temp){
        content.append(temp);
    }
}
