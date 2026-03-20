import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UrlShortnerService urlShortnerService = new UrlShortnerService();
        String shortUrl = urlShortnerService.createShortUrl("https://example.com/very/long/url",0);
        System.out.println("https://example.com/"+shortUrl);
        String shortUrl2 = urlShortnerService.createShortUrl("https://example.com/very/long/url2",0);
        System.out.println("https://example.com/"+shortUrl2);
    }
}