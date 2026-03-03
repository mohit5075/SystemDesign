public class FileSystemService {
    private Directory root;
    public FileSystemService(){
        this.root = new Directory("/",null);
    }

    private FileNode traverse(String path) {
        String[] parts = path.split("/");
        Directory curr = root;

        for (int i = 1; i < parts.length; i++) {
            FileNode node = curr.getChild(parts[i]);
            if (node == null) return null;

            if (i == parts.length - 1) return node;
            if (!node.isDirectory()) return null;

            curr = (Directory) node;
        }
        return curr;
    }

    public void mkdir(String path) {
        String[] parts = path.split("/");
        Directory curr = root;

        for (int i = 1; i < parts.length; i++) {
            curr.getChilds().putIfAbsent(
                    parts[i], new Directory(parts[i], curr)
            );
            curr = (Directory) curr.getChild(parts[i]);
        }
    }

    public void createFile(String path) {
        int idx = path.lastIndexOf('/');
        String dirPath = path.substring(0, idx);
        String fileName = path.substring(idx + 1);

        Directory dir = (Directory) traverse(dirPath);
        if (dir != null) {
            dir.addChild(new File(fileName, dir));
        }
    }

    public void writeFile(String path, String data) {
        File file = (File) traverse(path);
        if (file != null) {
            file.write(data);
        }
    }

    public String readFile(String path) {
        File file = (File) traverse(path);
        return file == null ? null : file.read();
    }
}
