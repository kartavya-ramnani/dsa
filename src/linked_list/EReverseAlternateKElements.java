package linked_list;

// Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
//
//If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
// Example : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 , k=2
// output : 2 -> 1 -> 3 -> 4 -> 6 -> 5 -> 7 -> 8
public class EReverseAlternateKElements {

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        int odd = -1;

        do {
            if (odd < 0) {

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

            } else {
                for (int i = 0; current != null && i < k; i++) {
                    previous = current;
                    current = current.next;
                }
            }

            odd *= -1;

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

        ListNode responseHead = EReverseAlternateKElements.reverse(head, 2);
        while (responseHead != null) {
            System.out.println(responseHead.value + "->");
            responseHead = responseHead.next;
        }
    }

}
