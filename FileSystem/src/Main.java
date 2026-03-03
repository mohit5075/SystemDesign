public class Main {
    public static void main(String[] args) {
        FileSystemService fileSystemService = new FileSystemService();
        fileSystemService.mkdir("/job/dsa/dp/knapsack");
        fileSystemService.createFile("/job/dsa/dp/knapsack/solution.txt");
        fileSystemService.writeFile("/job/dsa/dp/knapsack/solution.txt","This is the knapsack solution.");
        String content = fileSystemService.readFile("/job/dsa/dp/knapsack/solution.txt");
        System.out.println(content);
    }
}