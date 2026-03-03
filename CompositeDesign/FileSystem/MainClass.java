public class MainClass {
    public static void main(String[] args) {
        FileSystem file1 = new File("file1");
        FileSystem file2 = new File("file2");
        FileSystem file3 = new File("file3");
        FileSystem directory = new Directory("directory1");
        FileSystem directory2 = new Directory("directory2");
        ((Directory) directory2).add(file2);
        ((Directory) directory2).add(file3);
        ((Directory) directory).add(directory2);
        ((Directory) directory).add(file1);
        directory.ls();
    }
}
