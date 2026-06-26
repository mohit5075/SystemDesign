public class FileService {
    private Directory root;
    public FileService(){
        this.root = new Directory(null,"/");
    }
    public void mkdir(String path){
        Directory curr = root;
        String [] parts = path.split("/");
        for(int i=1;i<parts.length;i++) {
            FileNode fileNode = curr.getDirectory(parts[i]);
            if(fileNode==null){
                curr.addDirectory(new Directory(curr,parts[i]));
            }
            Directory directory = (Directory) curr.getDirectory(parts[i]);
            curr = directory;
        }
    }
    public FileNode traverse(String path){
        Directory curr = root;
        String [] parts = path.split("/");
        for(int i=1;i<parts.length;i++){
            if(i== parts.length-1)return curr.getDirectory(parts[i]);
            if(curr.getDirectory(parts[i]) instanceof File)return null;
            Directory directory = (Directory) curr.getDirectory(parts[i]);
            curr = directory;
        }
        return curr;
    }
    public void write(String path, String content){
        File file = (File) traverse(path);
        if(file==null)return;
        file.addContent(content);
    }
    public String read(String path){
        File file = (File) traverse(path);
        if(file==null)return "";
        return file.getContent();
    }
}
