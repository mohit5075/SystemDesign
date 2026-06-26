public class DoublyLinkedList <K,V>{
    public Node<K,V> head,tail;
    public DoublyLinkedList(){
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(Node<K,V> node){

    }

    public void addToFront(Node<K,V> node){

    }

    public void moveToFirst(Node<K,V> node){
        removeNode(node);
        addToFront(node);
    }

    public Node<K,V> removeLast(){
        return null;
    }

}
