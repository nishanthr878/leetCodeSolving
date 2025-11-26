public class MyHashMap {
    /**
     * Node class representing each entry in the HashMap
     */
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] buckets;
    private static final int DEFULT_CAPACITY = 1000;

    public MyHashMap() {
        buckets = new Node[DEFULT_CAPACITY];
    }

    private int hash(int key) {
        return key % buckets.length;
    }
    /**
     * Put key-value pair into the HashMap. If the key already exists, update its value.
     */
    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        if(head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = head;
        while(curr != null) {
            if(curr.key == key) {
                curr.value = value;
                return;
            }
            if(curr.next == null) {
                curr.next = new Node(key, value);
                return;
            }
            curr = curr.next;
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if(curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if(curr.key == key) {
                if(prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
