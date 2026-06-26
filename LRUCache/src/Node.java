public class Node <K,V>{
    K key;
    V value;
    Node<K,V> prev;
    Node<K,V> next;
    Long expiryTime;

    public Node(K key, V value, Long expiryTime) {
        this.key = key;
        this.value = value;
        this.expiryTime = expiryTime;
    }
    public boolean isExpired(){
        return System.currentTimeMillis()>expiryTime;
    }
}
