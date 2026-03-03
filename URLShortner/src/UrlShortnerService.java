import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortnerService {
    private final UrlRepo urlRepo = UrlRepo.getInstance();
    private AtomicLong counter = new AtomicLong(1000000000);
    private final String base62code = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String createShortUrl(String longUrl, long ttl){
        String shortUrl = createEncoding();
        long expiry = ttl>0?System.currentTimeMillis()+ttl:0;
        UrlMapping urlMapping = new UrlMapping(shortUrl,longUrl,expiry);
        urlRepo.putMapping(urlMapping);
        return urlMapping.getShortUrl();
    }

    private String createEncoding(){
        long currentId = counter.incrementAndGet();
        StringBuilder ans = new StringBuilder();
        while(currentId>0){
            long rem = currentId%62;
            currentId/=62;
            ans.append(base62code.charAt((int) rem));
        }
        return ans.reverse().toString();
    }

    private String getLongUrl(String shortUrl){
        UrlMapping urlMapping = urlRepo.getMappingByShort(shortUrl);
        return urlMapping.getLongUrl();
    }
}
