public class CollectionStats {
    private int fileCount;
    private int totalSize;

    public CollectionStats(int fileCount, int totalSize) {
        this.fileCount = fileCount;
        this.totalSize = totalSize;
    }
    public void reduceCount(){
        this.fileCount-=1;
    }
    public void reduceSize(int f){
        this.totalSize-=f;
    }
    public void increaseCount(){
        this.fileCount+=1;
    }
    public void increaseSize(int f){
        this.totalSize+=f;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getTotalSize() {
        return totalSize;
    }
}
