import java.util.HashMap;


public class CopyListWithRandomPointrs {


    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        // Example usage
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.random = node1;

        CopyListWithRandomPointrs solution = new CopyListWithRandomPointrs();
        Node copiedList = solution.copyRandomList(node1);

        // Print copied list to verify
        Node curr = copiedList;
        while (curr != null) {
            System.out.println("Value: " + curr.val + ", Random: " + (curr.random != null ? curr.random.val : "null"));
            curr = curr.next;
        }
    }
}
