public class DoublyLinkedList <K,V>{
    Node<K,V> head;
    Node<K,V> tail;
    public DoublyLinkedList(){
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        tail.prev=head;
        head.next=tail;
    }
    public void addFirst(Node<K,V> node){
        Node<K,V> firstNode = head.next;
        head.next=node;
        node.next=firstNode;
        firstNode.prev=node;
        node.prev=head;
    }
    public Node<K,V> removeLast(){
        if(tail.prev==null)return null;
        Node<K,V> node = tail.prev;
        node.prev.next=tail;
        tail.prev=node.prev;
        return node;
    }
    public void remove(Node<K,V> node){
        Node<K,V> prevnode = node.prev;
        prevnode.next=node.next;
        node.next.prev=prevnode;
    }
    public void moveToFront(Node<K,V> node){
        remove(node);
        addFirst(node);
    }
}
