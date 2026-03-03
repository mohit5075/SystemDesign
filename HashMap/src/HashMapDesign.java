public class HashMapDesign<K,V> {
    private static final int INITIAL_SIZE = 16;
    private static final int MAXIMUM_CAPACITY=1<<30;
    private int tableSize;
    private Entry[] hashTable;
    public HashMapDesign(int capacity){
        tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }
    private int tableSizeFor(int capacity){
        int n=capacity-1;
        n|=(n>>>1);
        n|=(n>>>2);
        n|=(n>>>4);
        n|=(n>>>8);
        n|=(n>>>16);
        return (n<0?1:(n>=MAXIMUM_CAPACITY?MAXIMUM_CAPACITY:n+1));
    }
    public void put(K key, V value){
        int hash = key.hashCode()%tableSize;
        Entry node = hashTable[hash];
        if(node==null){
            Entry entry = new Entry(key,value);
            hashTable[hash]=entry;
        }else{
            Entry prev = node;
            while(node!=null){
                if(node.getKey()==key){
                    node.value=value;return;
                }
                prev=node;
                node=node.next;
            }
            prev.next = new Entry<>(key,value);
        }
    }
    public V get(K key){
        int hash = key.hashCode()%tableSize;
        Entry node = hashTable[hash];
        while(node!=null){
            if(node.getKey()==key){
                return (V) node.getValue();
            }
            node=node.next;
        }
        return null;
    }
}
