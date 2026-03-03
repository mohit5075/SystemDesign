public class UrlMapping {
    private String shortUrl;
    private String longUrl;
    private long ttl;

    public UrlMapping(String shortUrl, String longUrl, long ttl) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.ttl = ttl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public long getTtl() {
        return ttl;
    }
}
