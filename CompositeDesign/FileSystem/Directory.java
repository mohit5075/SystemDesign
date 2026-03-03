import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    private String directoryName;
    private List<FileSystem> directoryFiles;
    public Directory(String directoryName){
        this.directoryName = directoryName;
        this.directoryFiles = new ArrayList<>();
    }
    public void add(FileSystem fileSystem){
        directoryFiles.add(fileSystem);
    }
    @Override
    public void ls() {
        System.out.println("Directory Name is: "+directoryName);
        for(FileSystem fileSystem : directoryFiles){
            fileSystem.ls();
        }
    }
}
