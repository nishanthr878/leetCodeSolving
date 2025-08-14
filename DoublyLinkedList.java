public class DoublyLinkedList {
    String val;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    DoublyLinkedList(String val, DoublyLinkedList next, DoublyLinkedList prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
