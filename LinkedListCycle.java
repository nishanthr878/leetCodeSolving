import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while(cur != null) {
            if (seen.contains(cur)) {
                return true;
            }
            seen.add(cur);
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycleTwoPointers(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return  false;
    }


    public static void main(String[] args) {
        // Example usage
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle

        LinkedListCycle cycleDetector = new LinkedListCycle();
        System.out.println(cycleDetector.hasCycle(node1));// Output: true
        System.out.println(cycleDetector.hasCycleTwoPointers(node1)); // Output: true
    }
}
