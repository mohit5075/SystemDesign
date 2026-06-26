import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
    private int capacity;
    private DoublyLinkedList dll;
    private int size;
    Map<K,Node<K,V>> keynode;
    public LRUCache(int capacity){
        this.capacity = capacity;
        keynode = new HashMap<>();
        dll = new DoublyLinkedList<>();
        this.size =0;
    }
    public V get(K key){
        Node<K, V> node = keynode.get(key);
        if(node==null)return null;
        dll.moveToFirst(node);
        return node.value;
    }
    public void add(K key, V value){
        if(keynode.containsKey(key)){
            Node<K, V> node = keynode.get(key);
            node.value = value;
            dll.moveToFirst(node);
            return;
        }else {
            Node<K, V> node =  new Node<>(key, value);
            if(size==capacity){
                Node<K, V> lastNode = dll.removeLast();
                keynode.remove(lastNode.key,lastNode);
            }else{
                size++;
            }
            dll.addToFront(node);
            keynode.put(key,node);
        }
    }
}
