import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UrlRepo {
    private static UrlRepo instance = null;
    Map<String,UrlMapping> mappings = new ConcurrentHashMap<>();
    public UrlMapping getMappingByShort(String shortUrl){
        return mappings.get(shortUrl);
    }
    public void putMapping(UrlMapping urlMapping){
        mappings.put(urlMapping.getShortUrl(),urlMapping);
    }
    public static UrlRepo getInstance(){
        if(instance==null){
            synchronized (UrlRepo.class){
                if(instance==null){
                    instance = new UrlRepo();
                    return instance;
                }
            }
        }
        return instance;
    }
}
