import java.util.HashMap;
import java.util.Map;

public class LruCache <K,V>{
    private int capacity;
    private DoublyLinkedList<K,V> dll;
    private Map<K,Node<K,V>> nodeMap;
    public LruCache(int capacity){
        this.capacity  = capacity;
        dll = new DoublyLinkedList<>();
        nodeMap = new HashMap<>();
    }
    public void putKey(K key, V value, Long ttl){
        if(nodeMap.containsKey(key)){
            Node<K,V> node = nodeMap.get(key);
            if(node.isExpired()){
                dll.remove(node);
                nodeMap.remove(node.key);
            }
            node.value=value;
            node.expiryTime = System.currentTimeMillis()+ttl;
            dll.moveToFront(node);
        }else{
            Node<K,V> newNode = new Node<>(key,value,System.currentTimeMillis()+ttl);
            if(nodeMap.size()==capacity){
                Node<K,V> removedNode = dll.removeLast();
                if(removedNode!=null) {
                    System.out.println("removing key: "+removedNode.key);
                    nodeMap.remove(removedNode.key);
                }
            }
            dll.addFirst(newNode);
            nodeMap.put(key,newNode);
        }
    }
    public V getKey(K key){
        if(!nodeMap.containsKey(key))return null;
        Node<K,V> node = nodeMap.get(key);
        dll.moveToFront(node);
        return node.value;
    }
    public V getFirst(){
        if(dll.head.next==dll.tail)return null;
        return dll.head.next.value;
    }
}
