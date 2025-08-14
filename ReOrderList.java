import java.util.ArrayList;
import java.util.List;

public class ReOrderList {
    public void reOrderListFastSlow(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            prev = second;
            second = tmp;
        }


        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

        System.out.println("Reordered Linked List:");
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }




    public void reOrderListRecursion(ListNode head) {
        head = recurive(head, head.next);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private ListNode recurive(ListNode root, ListNode cur) {
        if (cur == null) {
            return root;
        }
        root = recurive(root, cur.next);
        if(root == null) {
            return null;
        }

        ListNode tmp = null;
        if (root == cur || root.next == cur) {
            cur.next = null;
        } else {
            tmp = root.next;
            root.next = cur;
            cur.next = tmp;
        }
        return tmp;
    }


    public void reOrderLinkedListBruteForce(ListNode head) {
        if (head == null ){
            return;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int i = 0, j = nodes.size() -1;
        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;
            if ( i >j) {
                break;
            }
            nodes.get(j).next = nodes.get(i);
            j--;
        }
        nodes.get(i).next = null; // Last node should point to null
        System.out.println("Reordered Linked List:");
        for (ListNode node : nodes) {
            System.out.print(node.val + " ");
        }
    }

    public static void main(String args[]) {
        ListNode node = new ListNode(2,
                new ListNode(4,
                new ListNode(6,
                new ListNode(8
//                new ListNode(10)
                ))));

        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reOrderListFastSlow(node);

    }
}
