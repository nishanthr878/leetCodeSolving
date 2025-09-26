public class IsPalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode[] left = new ListNode[]{head};
        return check(head, left);
    }

    private boolean check(ListNode right, ListNode[] left) {
        if(right == null) {
            return true;
        }

        if(!check(right.next , left)) {
            return false;
        }

        if(right.val != left[0].val) {
            return false;
        }

        left[0] = left[0].next;
        return true;
    }


    public static void main(String[] args) {
        // Example: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));

        IsPalindromeLinkedList pll = new IsPalindromeLinkedList();
        System.out.println(pll.isPalindrome(head)); // true
    }
}
