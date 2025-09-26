//import java.util.HashMap;
//
//public class LRUCacheDoubleLinkedList {
//    private int capacity;
//    private HashMap<Integer, Node2> cache;
//    private Node2 left;
//    private Node2 right;
//
//    public LRUCacheDoubleLinkedList (int capacity) {
//        this.capacity = capacity;
//        this.cache = new HashMap<>();
//        this.left = new Node2(0, 0);
//        this.right = new Node2(0, 0);
//        this.left.next = this.right;
//        this.right.prev = this.left;
//    }
//
//    private void remove(Node2 node) {
//        Node2 prev = node.prev;
//        Node2 next = node.next;
//        prev.next = next;
//        next.prev = prev;
//    }
//
//    pr
//}
