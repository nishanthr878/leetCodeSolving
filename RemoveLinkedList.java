public class RemoveLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        return deleteNode(head, val);
    }

    private ListNode deleteNode(ListNode node, int val) {

        if (node == null) {
            return null;
        }

        node.next = deleteNode(node.next, val);

        if (node.val == val) {
            return node.next;
        } else {
            return node;
        }
    }


    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        RemoveLinkedList remover = new RemoveLinkedList();
        ListNode result = remover.removeElements(head, 6);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
