public class MergeTwoSortedLinkedList {
//    public ListNode mergeTwoListIteration(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode node = dummy;
//
//        while ()
//    }


    public ListNode mergeTwoListRecurssive(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if(l1.val <= l2.val) {
            l1.next = mergeTwoListRecurssive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListRecurssive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
        ListNode mergedList = mergeTwoSortedLinkedList.mergeTwoListRecurssive(l1, l2);

        // Print merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        System.out.println();
    }
}
