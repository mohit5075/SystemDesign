import java.util.*;

import static java.lang.Math.min;

public class Demo {
    Map<String, FileRecord> fileMap = new HashMap<>();
    Map<String,CollectionStats> collectionStatsMap = new HashMap<>();
    private int totalSize;
    public void addFile(String fileId, int size, List<String> collections){
        FileRecord file = fileMap.get(fileId);
        Set<String> collectionSet = new HashSet<>();
        collectionSet.addAll(collections);
        FileRecord newFile = new FileRecord(fileId,size,collectionSet);
        if(file==null){
            fileMap.put(fileId,newFile);
            for(String col : collectionSet){
                CollectionStats collectionStats = collectionStatsMap.get(col);
                if(collectionStats==null)collectionStatsMap.put(col,new CollectionStats(1,size));
                else {
                    collectionStats.increaseCount();
                    collectionStats.increaseSize(size);
                }
            }
            totalSize+=size;
        }else{
            fileMap.put(fileId,newFile);
            Set<String> oldSet = file.getCollections();
            totalSize+=(size-file.getFileSize());
            for(String col : oldSet){
                CollectionStats collectionStats = collectionStatsMap.get(col);
                collectionStats.reduceCount();
                collectionStats.reduceSize(file.getFileSize());
            }
            for(String col : collectionSet){
                CollectionStats collectionStats = collectionStatsMap.get(col);
                collectionStats.increaseCount();
                collectionStats.increaseSize(size);
            }
        }
    }
    public List<String> getCollections(int k){
        List<String>collections = new ArrayList<>();
        for(String names : collectionStatsMap.keySet())collections.add(names);
        Comparator<String>cmp = (a,b)->{
            int s1 = collectionStatsMap.get(a).getTotalSize();
            int s2 = collectionStatsMap.get(b).getTotalSize();
            if(s1!=s2)return Integer.compare(s2,s1);
            return a.compareTo(b);
        };
        collections.sort(cmp);
        k = min(k,collections.size());
        return collections.subList(0,k);
    }
}
