package linked_list;

// Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
public class CReverseSubList {

    public static ListNode reverse(ListNode head, int start, int end) {
        if (head == null) {
            return null;
        }
        if (start == end) {
            return head;
        }

        // traverse until p
        ListNode current = head;
        ListNode previous = null;
        for (int i = 0; current != null && i < start - 1; i++) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return head;
        }

        ListNode beforeStart = previous;
        ListNode lastNodeOfSublist = current;
        ListNode next;

        for (int i = 0; current != null && i < end - start + 1; i++) {
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

        lastNodeOfSublist.next = current;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode responseHead = CReverseSubList.reverse(head, 2, 4);
        while (responseHead != null) {
            System.out.println(responseHead.value + "->");
            responseHead = responseHead.next;
        }
    }

}
