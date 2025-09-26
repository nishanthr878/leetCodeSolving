import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEndTwoPointers(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while(n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;

    }

    public ListNode removeNthFromEndIteration(ListNode head, int n) {
        int N = 0;
        ListNode cur = head;
        while(cur != null) {
            N++;
            cur = cur.next;
        }

        int removeIndex = N - n;
        if(removeIndex == 0) {
            return head.next;
        }

        cur = head;
        for(int i = 0; i < N -1; i++) {
            if((i + 1) == removeIndex) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }


    public ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int removeIndex = nodes.size() - n;
        if(removeIndex == 0) {
            return head.next;
        }

        nodes.get(removeIndex -1).next = nodes.get(removeIndex).next;
        return head;
    }


    public ListNode removeNthFormEndOfList (ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        helper(dummy, n);
        return dummy.next;
    }

    private int helper(ListNode node, int n) {
        if(node == null) {
            return 0;
        }

        int indexFromEnd = helper(node.next, n ) + 1;

        if(indexFromEnd == n + 1) {
            node.next = node.next.next;
        }
        return indexFromEnd;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode result = solution.removeNthFromEndIteration(head, 2);

        // Print the modified list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
