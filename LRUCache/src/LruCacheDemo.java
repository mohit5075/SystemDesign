public class LruCacheDemo {
    public static void main(String[] args) {
        LruCache<Integer,String> lruCache = new LruCache<>(3);

        lruCache.putKey(1, "One",333L);
        lruCache.putKey(2, "Two",333L);
        lruCache.putKey(3, "Three",333L);
        System.out.println(lruCache.getFirst());// Three
        System.out.println(lruCache.getKey(1)); //One
        System.out.println(lruCache.getFirst()); //One
        lruCache.putKey(4, "Four",333L);System.out.println(lruCache.getFirst()); //Four

        System.out.println(lruCache.getKey(2)); System.out.println(lruCache.getFirst()); //null ,Four
        System.out.println(lruCache.getKey(3)); System.out.println(lruCache.getFirst()); //Three, Three
        System.out.println(lruCache.getKey(4)); System.out.println(lruCache.getFirst()); //Four, Four
    }
}
