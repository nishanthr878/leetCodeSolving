public class AddTwoNumbers {
    public  ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int v1 = 0, v2 = 0;

        if (l1 != null) {
            v1 = l1.val;
        }
        if (l2 != null) {
            v2 = l2.val;
        }

        int sum = v1 + v2 + carry;

        int newCarry = sum /10;
        int nodeValue = sum % 10;

        ListNode nextNode = addTwoNumbersRecursion(
                (l1 != null) ? l1.next : null,
                (l2 != null) ? l2.next : null,
                newCarry
        );
        return new ListNode(nodeValue, nextNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersRecursion(l1, l2, 0);
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
