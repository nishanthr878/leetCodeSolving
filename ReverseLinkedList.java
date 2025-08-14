public class ReverseLinkedList {
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        if(head.next != null) {
            newHead = reverseListRecursive(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3 , node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode reversedHead = rll.reverseListRecursive(head);
        // Alternatively, you can use the iterative method
        ListNode reversedHead2 = rll.reverseListIterative(head);

        // Print reversed list
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println();
        current = reversedHead2;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
