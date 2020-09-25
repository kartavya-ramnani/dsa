package linked_list;

// Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
//
//If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
// Example : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 , k=3
// Output : 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 8 -> 7
public class DReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next;

        do {
            ListNode beforeStart = previous;
            ListNode lastNode = current;

            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (beforeStart != null) {
                beforeStart.next = previous;
            } else {
                head = previous;
            }

            previous = lastNode;
            lastNode.next = current;

        } while (current != null);

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode responseHead = DReverseEveryKElements.reverse(head, 3);
        while (responseHead != null) {
            System.out.println(responseHead.value + "->");
            responseHead = responseHead.next;
        }
    }

}
